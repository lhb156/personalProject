package member.service;

import java.util.Map;

import member.dao.MemberDaoImp;
import member.dao.MemberDaoInf;
import member.model.MemberVO;

public class MemberServiceImp implements MemberServiceInf {

	private static MemberServiceInf service = new MemberServiceImp();
	
	private MemberDaoInf dao;
	
	private MemberServiceImp(){
		dao = MemberDaoImp.getInstance();
	}
	
	public static MemberServiceInf getInstance(){
		return service;
	}
	
	
	@Override
	public MemberVO signInCheck(Map<String, String> map) {
		MemberVO memVO = null;
		
		memVO = dao.signInCheck(map);
		
		return memVO;
	}

}
