package member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;
import member.model.MemberVO;

public class MemberDaoImp implements MemberDaoInf{

	private static MemberDaoInf dao = new MemberDaoImp();
	
	private SqlSessionFactory ssf;
	
	
	private MemberDaoImp(){
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream ips = null;
		try {
			ips = Resources.getResourceAsStream(resource);
			ssf = new SqlSessionFactoryBuilder().build(ips);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoInf getInstance(){
		return dao;
	}
	
	
	@Override
	public MemberVO signInCheck(Map<String, String> map) {
		 
		SqlSession session = ssf.openSession();
		MemberVO memVO = session.selectOne("member.sgininCheck",map);
		session.close();
		
		return memVO; 
		
	}

	
}
