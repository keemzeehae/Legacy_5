package com.keem.s1.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.keem.s1.board.BoardDTO;
import com.keem.s1.member.MemberDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("WriterCheck Interceptor PostHandle");
	
		String method = request.getMethod();
		System.out.println("Method: "+method);
		
		if(method.equals("POST")) {
			//return을 만나는 순간 강제로 종료 
			return;
		}
		
		//login 정보
		MemberDTO memberDTO= (MemberDTO)request.getSession().getAttribute("member");
		
		//writer정보
		Map<String, Object> map= modelAndView.getModel();
		BoardDTO boardDTO=(BoardDTO)map.get("dto");
		
		System.out.println(memberDTO.getId());
		System.out.println(boardDTO.getWriter());
		
		if(!memberDTO.getId().equals(boardDTO.getWriter())) {
			//spring 문법
			
			//1. forward
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message","수정권한이 없습니다.");
			modelAndView.addObject("path","./list");
			
			//2. redirect
			
		}
	
	}
}
