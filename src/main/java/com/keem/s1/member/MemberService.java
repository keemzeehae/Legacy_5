package com.keem.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keem.s1.bankbook.BankbookDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	public int join(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.join(memberDTO);
	}

}
