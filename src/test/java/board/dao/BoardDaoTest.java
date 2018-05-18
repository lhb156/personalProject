package board.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;

public class BoardDaoTest {


	/**
	 * 
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 12.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시판의 id를 받아 List로 받아오는 메서드
	 */
	@Test
	public void getBoardListTest() {
		/***Given***/
		List<BoardVO> list = new ArrayList<BoardVO>();
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		list = dao.getBoardList(1);
		/***Then***/
		assertEquals(11, list.size());
	}
	
	/**
	 * 
	* Method : getBoardKind
	* 최초작성일 : 2018. 5. 12.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트를 읽어오는 메서드
	 */
	@Test
	public void getBoardKindTest(){
		/***Given***/
		List<Board_kindVO> list = new ArrayList<Board_kindVO>();
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		list = dao.getBoardKind();
		/***Then***/
		assertEquals(5, list.size());
	}
	
	/**
	 * 
	* Method : getBoardKindName
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param board_kind_seq
	* @return
	* Method 설명 : 게시판의 ID를 받아 게시판 이름을 return하는 메서드
	 */
	@Test
	public void getBoardKindNameTest(){
		/***Given***/
		int board_kind_seq = 1;
		String board_kind_nm = "";
		
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		board_kind_nm = dao.getBoardKindName(board_kind_seq);
		
		/***Then***/
		assertEquals("NOTICE", board_kind_nm);
		
	}
	
	/**
	 * 
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param boardVO
	* @return Success 0 or Fail 1
	* Method 설명 : 게시판에 새로운 글을 쓰는 메서드
	 */
	@Test
	public void insertBoardTest(){
		/***Given***/
		int result = 0;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		BoardVO boardVO = new BoardVO();
		
		boardVO.setCategory_seq(2);
		boardVO.setReg_id("test02");
		boardVO.setBoard_title("타이틀입니다");
		boardVO.setBoard_content("콘텐트입니당");
		boardVO.setDel_yn("y");
		
		result = dao.insertBoard(boardVO);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : getBoardInfo
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : List에서 클릭한 게시물의 ID로 Info를 얻어오는 메서드
	 */
	@Test
	public void getBoardInfoTest(){
		/***Given***/
		int board_seq = 2;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		BoardVO boardVO = dao.getBoardInfo(board_seq);
		/***Then***/
		assertEquals(boardVO.getBoard_seq(), board_seq);
	}
	
	/**
	 * 
	* Method : modifyBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 선택한 게시물을 수정하는 메서드
	 */
	@Test
	public void modifyBoardTest(){
		/***Given***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(1);
		boardVO.setCategory_seq(5);
		boardVO.setBoard_title("수정타이틀");
		boardVO.setBoard_content("수정 내용");
		boardVO.setReg_dt(new Date());
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		int result = dao.modifyBoard(boardVO);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : modifyBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 선택한 게시물을 삭제상태로 변경하는 메서드
	 */
	@Test
	public void deleteBoardTest(){
		/***Given***/
		int board_seq = 16;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		int result = dao.deleteBoard(board_seq);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : board_kind
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param board_kind_seq
	* @return
	* Method 설명 : 게시판 번호를 기준으로 게시판 활성화 여부를 결정하는 메서드
	 */
	@Test
	public void EditboardTest(){
		/***Given***/
		int board_kind_seq = 6;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		int result = dao.Editboard(board_kind_seq);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : insertBoardKind
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 작성자ID와 게시판 이름을 받아 새로운 게시판을 생성하는 메서드
	 */
	@Test
	public void insertBoardKindTest(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("create_id", "test01");
		map.put("board_kind_nm", "두번째 테스트 게시판");
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		int result = dao.insertBoardKind(map);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : reBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 답글을 작성하는 메서드
	 */
	@Test
	public void reBoardTest(){
		/***Given***/
		int result = 0;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		BoardVO boardVO = new BoardVO();
		
		boardVO.setCategory_seq(5);
		boardVO.setPboard_seq(25);
		boardVO.setReg_id("test02");
		boardVO.setGroup_seq(18);
		boardVO.setBoard_title("타이틀입니다");
		boardVO.setBoard_content("콘텐트입니당");
		
		result = dao.reBoard(boardVO);
		/***Then***/
		assertEquals(1, result);

	}

	/**
	 * 
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param Board_seq
	* @return
	* Method 설명 : 게시반 번호를 받아 게시판에 댓글을 다는 메서드
	 */
	@Test
	public void insertReplyTest(){
		/***Given***/
		ReplyVO replyVO = new ReplyVO();
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		replyVO.setRe_board_seq(30);
		replyVO.setRe_mem_id("test05");
		replyVO.setRe_cont("내용입니다잉");
		int result = dao.insertReply(replyVO);
		/***Then***/
		assertEquals(1, result);
	}
	
	/**
	 * 
	* Method : deleteReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : 댓글을 지우는 메서드
	 */
	@Test
	public void deleteReplyTest(){
		/***Given***/
		int reply_seq = 7;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		int reulst = dao.deleteReply(reply_seq);
		/***Then***/
		assertEquals(1, reulst);
	}
	
	/**
	 * 
	* Method : getReplyList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시물의 댓글을 가져오는 메서드
	 */
	@Test
	public void getReplyListTest(){
		/***Given***/
		List<ReplyVO> list = new ArrayList<ReplyVO>();
		int re_board_seq = 3;
		/***When***/
		BoardDaoInf dao = BoardDaoImp.getInstance();
		list = dao.getReplyList(re_board_seq);
		/***Then***/
		assertEquals(2, list.size());
	}
	
}
