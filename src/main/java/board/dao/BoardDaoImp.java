package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;
import board.model.Board_kindVO;
import board.model.ReplyVO;

public class BoardDaoImp implements BoardDaoInf {
private static BoardDaoInf dao = new BoardDaoImp();
	
	private SqlSessionFactory ssf;
	
	
	private BoardDaoImp(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream ips = null;
		try {
			ips = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(ips);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDaoInf getInstance(){
		return dao;
	}
	

	@Override
	public List<BoardVO> getBoardList(int category_seq) {
		
		SqlSession session = ssf.openSession();
		List<BoardVO> list = session.selectList("board.getBoardList",category_seq);
		session.close();
		return list;
	}

	@Override
	public List<Board_kindVO> getBoardKind() {
		SqlSession session = ssf.openSession();
		List<Board_kindVO> list = session.selectList("board.getBoardKind");
		session.close();
		return list;
	}
	
	@Override
	public String getBoardKindName(int board_kind_seq) {
		SqlSession session = ssf.openSession();
		String board_kind_nm = session.selectOne("board.getBoardKindName",board_kind_seq);
		session.close();
		return board_kind_nm;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession session = ssf.openSession();
		int result = session.insert("board.newBoardWrite",boardVO);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public BoardVO getBoardInfo(int board_seq) {
		SqlSession session = ssf.openSession();
		BoardVO boardVO = session.selectOne("board.getBoardInfo",board_seq);
		session.close();
		return boardVO;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		SqlSession session = ssf.openSession();
		int result = session.update("board.modifyBoard",boardVO);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int deleteBoard(int board_seq) {
		SqlSession session = ssf.openSession();
		int result = session.update("board.deleteBoard",board_seq);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int Editboard(int board_kind_seq) {
		SqlSession session = ssf.openSession();
		int result = session.update("board.eidtBoard",board_kind_seq);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int insertBoardKind(Map<String, String> map) {
		SqlSession session = ssf.openSession();
		int result = session.insert("board.insertBoardKind",map);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int getUserTotalCnt(int board_kind_seq) {
		SqlSession session = ssf.openSession();
		int board_kind_cnt = session.selectOne("board.getBoardCnt",board_kind_seq);
		session.close();
		return board_kind_cnt;
	}

	@Override
	public List<BoardVO> getBoardPageList(int page, int pageSize, int category_seq) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("category_seq", category_seq);
		
		SqlSession sqlSession = ssf.openSession();
		List<BoardVO> userList = sqlSession.selectList("board.getBoardPageList",paramMap);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int reBoard(BoardVO boardVO) {
		SqlSession session = ssf.openSession();
		
		int result = session.insert("board.reBoard",boardVO);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int insertReply(ReplyVO replyVO) {
		SqlSession session = ssf.openSession();
		int result = session.insert("board.insertReply",replyVO);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public int deleteReply(int reply_seq) {
		SqlSession session = ssf.openSession();
		int result = session.insert("board.deleteReply",reply_seq);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public List<ReplyVO> getReplyList(int re_board_seq) {
		SqlSession session = ssf.openSession();
		List<ReplyVO> list = session.selectList("board.getReplyList",re_board_seq);
		return list;
	}


}
