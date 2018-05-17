package member.servlet;

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
import member.service.MemberServiceImp;
import member.service.MemberServiceInf;
import board.model.BoardVO;
import board.model.Board_kindVO;
import board.service.BoardServiceImp;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/loginProcess")
public class SignInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MemberServiceInf memberService;
	private BoardServiceInf boardService;
       
	public SignInServlet() {
		super();
		memberService = MemberServiceImp.getInstance();
		boardService = BoardServiceImp.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board_kindVO> kindList= boardService.getBoardKind();
		
		request.setAttribute("kindList", kindList);
		RequestDispatcher rd = request.getRequestDispatcher("/main/main.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		map.put("mem_id", mem_id);
		map.put("mem_pass", mem_pass);
		
		MemberVO memVO = memberService.signInCheck(map);
		
		List<Board_kindVO> kindList= boardService.getBoardKind();
		
		if(memVO != null){
			session.setAttribute("memVO", memVO);
			request.setAttribute("kindList", kindList);
			request.setAttribute("memVO", memVO);
			request.setAttribute("board_kind", 1);
			RequestDispatcher rd = request.getRequestDispatcher("/main/main.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/signin/login.jsp");
		}
		
	}

}
