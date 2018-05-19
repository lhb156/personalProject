package board.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import member.model.MemberVO;
import util.FileUtil;
import board.model.AdFileVO;
import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;
import board.service.BoardServiceImp;
import board.service.BoardServiceInf;

@WebServlet("/boardWrite")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class BoardWriteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String UPLOAD_PATH = "D:/A_TeachingMaterial/7.JspSpring/uploadStorage";
	
	BoardServiceInf service;
       
    public BoardWriteServlet() {
        super();
        service = BoardServiceImp.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String btnValue = request.getParameter("editBtn");
		
		if(btnValue.equals("수정")){
			HttpSession session = request.getSession();
			MemberVO memVO = (MemberVO) session.getAttribute("memVO");
			String reg_id = memVO.getMem_id();
			int category_seq =Integer.parseInt(request.getParameter("board_kind"));
			
			int board_seq = Integer.parseInt(request.getParameter("board_seq"));
			String board_title = request.getParameter("edit_title");
			String board_content = request.getParameter("smarteditor");
			
			BoardVO boardVO = new BoardVO();
			boardVO.setCategory_seq(category_seq);
			boardVO.setReg_id(reg_id);
			boardVO.setBoard_title(board_title);
			boardVO.setBoard_content(board_content);
			boardVO.setBoard_seq(board_seq);
			
			List<Board_kindVO> list = service.getBoardKind();
			
			request.setAttribute("kindList", list);
			request.setAttribute("boardVO", boardVO);
			request.setAttribute("board_kind", category_seq);
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardModify.jsp");
			rd.forward(request, response);
			
		}else if(btnValue.equals("삭제")){
			int board_seq = Integer.parseInt(request.getParameter("board_seq"));
			System.out.println("board_seq : "+board_seq);
			int category_seq =Integer.parseInt(request.getParameter("board_kind"));
			
			int result = service.deleteBoard(board_seq);
			System.out.println("result" + result);
			
			request.setAttribute("board_kind", category_seq);
			RequestDispatcher rd = request.getRequestDispatcher("/returnList");
			rd.forward(request, response);
			
		}else if(btnValue.equals("답글")){
			
			HttpSession session = request.getSession();
			MemberVO memVO = (MemberVO) session.getAttribute("memVO");
			String reg_id = memVO.getMem_id();
			int category_seq =Integer.parseInt(request.getParameter("board_kind"));
			int group_seq = Integer.parseInt(request.getParameter("group_seq"));
			int board_seq = Integer.parseInt(request.getParameter("board_seq"));
			
			List<Board_kindVO> list = service.getBoardKind();
			
			
			request.setAttribute("kindList", list);
			request.setAttribute("group_seq", group_seq);
			request.setAttribute("pboard_seq", board_seq);
			request.setAttribute("board_kind", category_seq);
			RequestDispatcher rd = request.getRequestDispatcher("/board/reWrite.jsp");
			rd.forward(request, response);
			
		}else if(btnValue.equals("등록")){
			HttpSession session = request.getSession();
			MemberVO memVO = (MemberVO) session.getAttribute("memVO");
			String re_mem_id = memVO.getMem_id();
			String re_cont = request.getParameter("replytxt");
			int re_board_seq = Integer.parseInt(request.getParameter("board_seq"));
			
			ReplyVO replyVO = new ReplyVO();
			replyVO.setRe_board_seq(re_board_seq);
			replyVO.setRe_mem_id(re_mem_id);
			replyVO.setRe_cont(re_cont);
			
			int result = service.insertReply(replyVO);
			List<ReplyVO> replyList = service.getReplyList(re_board_seq);
			List<Board_kindVO> list = service.getBoardKind();
			
			request.setAttribute("board_seq", re_board_seq);
			request.setAttribute("kindList", list);
			request.setAttribute("replyList", replyList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/viewContent?board_seq="+re_board_seq);
			rd.forward(request, response);
			
			
		}else if(btnValue.equals("re_del")){
			
			int reply_seq = Integer.parseInt(request.getParameter("re_del"));
			int re_board_seq = Integer.parseInt(request.getParameter("board_seq"));
			int deleteReply = service.deleteReply(reply_seq);
			
			
			List<Board_kindVO> list = service.getBoardKind();
			
			List<ReplyVO> replyList = service.getReplyList(re_board_seq);
			
			request.setAttribute("board_seq", re_board_seq);
			request.setAttribute("kindList", list);
			request.setAttribute("replyList", replyList);
			RequestDispatcher rd = request.getRequestDispatcher("/viewContent?board_seq="+re_board_seq);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		Collection<Part> parts = request.getParts();
		
		MemberVO memVO = (MemberVO) session.getAttribute("memVO");
		String reg_id = memVO.getMem_id();
		int category_seq =Integer.parseInt(request.getParameter("board_kind"));
		String board_title = request.getParameter("new_subject");
		String board_content = request.getParameter("smarteditor");
		
		int pboard_seq= 0;
		
		System.out.println("length"+request.getParameter("pboard_seq").length());
		if(request.getParameter("pboard_seq").length()!=0){
			System.out.println("pboard_seq : "+request.getParameter("pboard_seq"));
			pboard_seq = Integer.parseInt(request.getParameter("pboard_seq"));
			request.setAttribute("pboard_seq", pboard_seq);
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setCategory_seq(category_seq);
		boardVO.setReg_id(reg_id);
		boardVO.setBoard_title(board_title);
		boardVO.setBoard_content(board_content);
		
		String status = request.getParameter("status");
		if(status.equals("new")){
			int result = service.insertBoard(boardVO);
		}else{
			int group_seq = Integer.parseInt(request.getParameter("group_seq"));
			request.setAttribute("group_seq", group_seq);
			boardVO.setPboard_seq(pboard_seq);
			boardVO.setGroup_seq(group_seq);
			int result = service.reBoard(boardVO);
		}
		
		for (Part part : parts) {
			if(part.getName().equals("addFile")){
				String contentString = part.getHeader("Content-disposition");
				String fileName = FileUtil.getFileName(contentString);

				int value =fileName.lastIndexOf(".");
				String extension = fileName.substring(value);
				
				String uploadPath = getServletContext().getRealPath("/uploadFolder");
				String filePath = UPLOAD_PATH + java.io.File.separator + UUID.randomUUID().toString()+extension;
				
				AdFileVO adFile = new AdFileVO();
				adFile.setAdfile_route(UUID.randomUUID().toString()+extension);
				
				service.insertFile(adFile);
				
				part.write(filePath);
				part.delete();
			}
		}
		//filePath webmember.mem_profile에 저장
		// 기존 : uri 형태로 지정 /uploadfolder/jellyfish.jpg
		// 변경 : 물리적 디스크의 절대경로로 저장 "D:\\A_TeachingMaterial\\7.JspSpring\\uploadStorage";
		
		request.setAttribute("smarteditor", board_content);
		request.setAttribute("board_kind", category_seq);
		response.sendRedirect(request.getContextPath()+"/returnList?board_kind="+category_seq);
//		RequestDispatcher rd = request.getRequestDispatcher("/returnList");
//		rd.forward(request, response);
		
		
	}

}
