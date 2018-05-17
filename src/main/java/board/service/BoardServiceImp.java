package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDaoImp;
import board.dao.BoardDaoInf;
import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;

public class BoardServiceImp implements BoardServiceInf {

	private static BoardServiceInf service = new BoardServiceImp();
	
	private BoardDaoInf dao;
	
	private BoardServiceImp(){
		dao = BoardDaoImp.getInstance();
	}
	
	public static BoardServiceInf getInstance(){
		return service;
	}
	
	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		List<BoardVO> list = null;
		
		list = dao.getBoardList(category_seq);
		
		return list;
	}

	@Override
	public List<Board_kindVO> getBoardKind() {
		List<Board_kindVO> list = null;
		
		list = dao.getBoardKind();
		
		return list;
	}

	@Override
	public String getBoardKindName(int board_kind_seq) {
		String board_kind_nm = "";
		board_kind_nm = dao.getBoardKindName(board_kind_seq);
		return board_kind_nm;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = 0;
		result = dao.insertBoard(boardVO);
		return result;
	}

	@Override
	public BoardVO getBoardInfo(int board_seq) {
		BoardVO boardVO = null;
		boardVO = dao.getBoardInfo(board_seq);
		return boardVO;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		int result = 0;
		result = dao.modifyBoard(boardVO);
		return result;
	}

	@Override
	public int deleteBoard(int board_seq) {
		int result = 0;
		result = dao.deleteBoard(board_seq);
		return result;
	}

	@Override
	public int Editboard(int board_kind_seq) {
		int result = 0;
		result = dao.Editboard(board_kind_seq);
		return result;
	}

	@Override
	public int insertBoardKind(Map<String, String> map) {
		int result = 0;
		result = dao.insertBoardKind(map);
		return result;
	}

	@Override
	public Map<String, Object> getBoardPageList(int page, int pageSize, int category_seq) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<BoardVO> userList = dao.getBoardPageList(page, pageSize, category_seq);
		System.out.println("category"+category_seq);
		int a =dao.getUserTotalCnt(category_seq);
		System.out.println("a : "+a);
		String pageNav = makePageNav(page,dao.getUserTotalCnt(category_seq),category_seq);
		
		resultMap.put("boardList", userList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}

	private String makePageNav(int page, int userTotalCnt,int category_seq) {
		//userTotalCnt = 30
		//paseSize = 10
		//totalPag = 3
		
		int pageTotalCnt = (int)(Math.ceil((double)userTotalCnt /10));
		
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		if(page != 1){
			pageNav.append("		<li><a href=\"viewExchange?page=1&pageSize=10&board_kind="+category_seq+"\" aria-label=\"Previous\">");
			pageNav.append("			<span aria-hidden=\"true\">&laquo;</span></a></li>");
			
			pageNav.append("		<li><a href=\"viewExchange?page="+ (page-1) +"&pageSize=10&board_kind="+category_seq+"\" aria-label=\"Previous\">");
			pageNav.append("			<span aria-hidden=\"true\">&lt;</span></a></li>");
		}
		//pageTotalCnt만큼 루프를 돌리고 싶을 때
		for (int i = 1; i <= pageTotalCnt; i++) {
			if(i == page){
				pageNav.append("				<li class='active'><a href=\"viewExchange?page="+ i +"&pageSize=10&board_kind="+category_seq+"\">"+ i +"</a></li>");
			}else{
				pageNav.append("				<li><a href=\"viewExchange?page="+ i +"&pageSize=10&board_kind="+category_seq+"\">"+ i +"</a></li>");
				
			}
		}
		if(page != pageTotalCnt){
			pageNav.append("		<li><a href=\"viewExchange?page="+ (page+1) +"&pageSize=10&board_kind="+category_seq+"\" aria-label=\"Previous\">");
			pageNav.append("			<span aria-hidden=\"true\">&gt;</span></a></li>");
			
			pageNav.append("				<li><a href=\"viewExchange?page="+ pageTotalCnt +"&pageSize=10&board_kind="+category_seq+"\" aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span></a></li>");
			
		}
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
		
		return pageNav.toString();
	}

	@Override
	public int reBoard(BoardVO boardVO) {
		int result = 0;
		
		result =  dao.reBoard(boardVO);
		return result;
	}

	@Override
	public int insertReply(ReplyVO replyVO) {
		int result = 0;
		
		result =  dao.insertReply(replyVO);
		return result;
	}

	@Override
	public int deleteReply(int reply_seq) {
		int result = 0;
		
		result =  dao.deleteReply(reply_seq);
		return result;
	}

	@Override
	public List<ReplyVO> getReplyList(int re_board_seq) {
		List<ReplyVO> list =  null;
		list = dao.getReplyList(re_board_seq);
		return list;
	}
	
	

}
