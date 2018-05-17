package board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.MemberVO;
import board.model.Board_kindVO;
import board.service.BoardServiceImp;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardControllServlet
 */
@WebServlet("/boardEdit")
public class BoardControllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf service;
       
    public BoardControllServlet() {
        super();
        service = BoardServiceImp.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board_kindVO> kindList= service.getBoardKind();
		request.setAttribute("kindList", kindList);
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardEdit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int editNum = Integer.parseInt(request.getParameter("status"));
		
		if(editNum==1){
			int board_kind_yn = Integer.parseInt(request.getParameter("kind_yn"));
			int result = service.Editboard(board_kind_yn);
			response.sendRedirect(request.getContextPath()+"/boardEdit");
		}else{
			HttpSession session = request.getSession();
			MemberVO memVO = (MemberVO) session.getAttribute("memVO");
			String board_kind_nm = request.getParameter("careteBoard");
			String create_id = memVO.getMem_id();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("create_id", create_id);
			map.put("board_kind_nm", board_kind_nm);
			service.insertBoardKind(map);
			response.sendRedirect(request.getContextPath()+"/boardEdit");
		}
		
	}

}
