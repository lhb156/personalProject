package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberVO;
import board.model.AdFileVO;
import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;
import board.service.BoardServiceImp;
import board.service.BoardServiceInf;

@WebServlet("/viewContent")
public class BoardContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service ;
	
    public BoardContentViewServlet() {
        super();
        service=BoardServiceImp.getInstance();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		MemberVO memVO = (MemberVO) session.getAttribute("memVO");
		BoardVO boardVO = service.getBoardInfo(board_seq);
		
		int board_kind = Integer.parseInt(request.getParameter("board_kind"));
		
		String yn ="";
		if(boardVO.getReg_id().equals(memVO.getMem_id())){
			yn = "OK";
			request.setAttribute("yn", yn);
		}else{
			yn = "NO";
			request.setAttribute("yn", yn);
		}
		System.out.println(yn);
		
		List<Board_kindVO> kindList = service.getBoardKind();
		List<ReplyVO> replyList = service.getReplyList(board_seq);
		List<AdFileVO> fileList = service.getFileList(board_seq);
		
		request.setAttribute("fileList", fileList);
		request.setAttribute("replyList", replyList);
		request.setAttribute("board_kind", board_kind);
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("kindList", kindList);
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_kind_seq = Integer.parseInt(request.getParameter("board_kind"));
		
		request.setAttribute("board_kind", board_kind_seq);
		
		List<Board_kindVO> kindList = service.getBoardKind();
		request.setAttribute("kindList", kindList);
		RequestDispatcher rd = request.getRequestDispatcher("/board/newBoard.jsp");
		rd.forward(request, response);
	}

}
