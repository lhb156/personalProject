package member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import member.model.MemberVO;

import org.junit.Test;

public class MemberDaoTest {

	@Test
	public void signInCheck() {
		
		/***Given***/
		MemberDaoInf dao = MemberDaoImp.getInstance();
		String mem_id = "a001";
		String mem_pass = "1"; 
		/***When***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id );
		map.put("mem_pass", mem_pass);
		
		MemberVO memVO = dao.signInCheck(map);
		
		/***Then***/
		assertNotNull(memVO);
		assertEquals("김은대", memVO.getMem_name());
		
	}

}
