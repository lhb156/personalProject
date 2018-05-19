package board.dao;

import java.util.List;
import java.util.Map;

import board.model.AdFileVO;
import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;

public interface BoardDaoInf {


	/**
	 * 
	* Method : getBoardList
	* 최초작성일 : 2018. 5. 12.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시판의 id를 받아 List로 받아오는 메서드
	 */
	public List<BoardVO> getBoardList(int category_seq);
	
	/**
	 * 
	* Method : getBoardKind
	* 최초작성일 : 2018. 5. 12.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 리스트를 읽어오는 메서드
	 */
	public List<Board_kindVO> getBoardKind();
	
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
	public String getBoardKindName(int board_kind_seq);
	
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
	public int insertBoard(BoardVO boardVO);
	
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
	public BoardVO getBoardInfo(int board_seq);
	
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
	public int modifyBoard(BoardVO boardVO);
	
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
	public int deleteBoard(int board_seq);
	
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
	public int Editboard(int board_kind_seq);
	
	
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
	public int insertBoardKind(Map<String,String> map);

	/**
	 * 
	* Method : getUserTotalCnt
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 선택한 게시판의 게시물 리스트를 페이징해서 받아오는 메서드
	 */
	public int getUserTotalCnt(int board_kind_seq);

	/**
	 * 
	* Method : getUserPageList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 :
	 */
	public List<BoardVO> getBoardPageList(int page, int pageSize, int category_seq);
	
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
	public int reBoard(BoardVO boardVO);
	
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
	public int insertReply(ReplyVO replyVO);
	
	/**
	 * 
	* Method : deleteReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : 리플을 지우는 메서드
	 */
	public int deleteReply(int reply_seq);
	
	/**
	 * 
	* Method : getReplyList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @return
	* Method 설명 : 해당 게시물의 댓글을 가져오는 메서드
	 */
	public List<ReplyVO> getReplyList(int re_board_seq);
	
	/**
	 * 
	* Method : insertFile
	* 최초작성일 : 2018. 5. 18.
	* 작성자 : PC22
	* 변경이력 :
	* @param adFile
	* Method 설명 :
	 */
	public int insertFile(AdFileVO adFile);
	
	/**
	 * 
	* Method : getFileList
	* 최초작성일 : 2018. 5. 18.
	* 작성자 : PC22
	* 변경이력 :
	* @param adFile
	* @return
	* Method 설명 :
	 */
	public List<AdFileVO> getFileList(int board_seq);
}
