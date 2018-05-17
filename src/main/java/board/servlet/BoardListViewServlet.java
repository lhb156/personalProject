package board.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.model.Board_kindVO;
import board.service.BoardServiceImp;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardListViewServlet
 */
@WebServlet("/returnList")
public class BoardListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service;
	
    public BoardListViewServlet() {
        super();
        service=BoardServiceImp.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int board_kind_seq = 0;
		
		if(request.getParameter("board_kind")==null){
			board_kind_seq = 1;
		}else{
			board_kind_seq = Integer.parseInt(request.getParameter("board_kind"));
		}
		System.out.println("category : "+board_kind_seq);
		String board_kind_nm = service.getBoardKindName(board_kind_seq);
		List<Board_kindVO> kindList= service.getBoardKind();
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1: Integer.parseInt(pageString);
		
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null? 10 : Integer.parseInt(pageSizeString);
		
		Map<String, Object> resultMap = service.getBoardPageList(page, pageSize, board_kind_seq);
		List<BoardVO> list = (List<BoardVO>) resultMap.get("boardList");
		for (BoardVO boardVO : list) {
			String before = (boardVO.getBoard_title()).replace(" ", "&emsp;");
			boardVO.setBoard_title(before);
		}
		
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		request.setAttribute("board_kind", board_kind_seq);
		request.setAttribute("board_kind_nm", board_kind_nm);
		request.setAttribute("kindList", kindList);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/exchangeBoard.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_kind_seq = (int) request.getAttribute("board_kind");
		List<BoardVO> list = service.getBoardList(board_kind_seq);
		String board_kind_nm = service.getBoardKindName(board_kind_seq);
		List<Board_kindVO> kindList= service.getBoardKind();
		
		request.setAttribute("board_kind", board_kind_seq);
		request.setAttribute("board_kind_nm", board_kind_nm);
		request.setAttribute("kindList", kindList);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/board/exchangeBoard.jsp");
		rd.forward(request, response);
	}

}
