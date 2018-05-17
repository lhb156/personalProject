package member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import member.dao.MemberDaoImp;
import member.dao.MemberDaoInf;
import member.model.MemberVO;

import org.junit.Test;

public class MemberServiceTest {

	@Test
	public void signInCheck() {
		
		/***Given***/
		MemberServiceInf service = MemberServiceImp.getInstance();
		String mem_id = "a001";
		String mem_pass = "1"; 
		/***When***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id );
		map.put("mem_pass", mem_pass);
		
		MemberVO memVO = service.signInCheck(map);
		
		/***Then***/
		assertNotNull(memVO);
		assertEquals("김은대", memVO.getMem_name());
		
	}

}
