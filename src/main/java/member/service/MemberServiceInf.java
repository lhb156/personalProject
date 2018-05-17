package member.service;

import java.util.Map;

import member.model.MemberVO;

public interface MemberServiceInf {

	/**
	 * 
	* Method : signInCheck
	* 최초작성일 : 2018. 5. 11.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param map
	* @return MemberVO
	* Method 설명 : Map객체에 아이디와 비밀번호를 받아 로그인 성공 시 회원의 정보를 가져오는 메서드
	 */
	public MemberVO signInCheck(Map<String, String> map);
	
	
}
