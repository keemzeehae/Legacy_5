package com.keem.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;

public class MemberTest extends MyJunitTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void mypage() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO=memberDAO.mypage(memberDTO);
		assertNotNull(memberDTO);
	}
	
	//@Test
	public void login() throws Exception{
		
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId("J");
			memberDTO.setPw("L");
			memberDTO=memberDAO.login(memberDTO);
			
			assertNotNull(memberDTO);
	}

	//@Test
	public void join() throws Exception {
		MemberDTO memberDTO = new MemberDTO(); // dommy data 가짜 데이터

		memberDTO.setId("J");
		memberDTO.setPw("L");
		memberDTO.setName("Jenn");
		memberDTO.setPhone("010-111-111");
		memberDTO.setEmail("tom@gmail.com");

		int result = memberDAO.join(memberDTO);

		assertEquals(1, result);
	}

}
