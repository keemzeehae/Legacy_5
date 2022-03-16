package com.keem.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.keem.s1.member.MemberDTO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("로그인 Interceptor");
		MemberDTO memberDTO=(MemberDTO)request.getSession().getAttribute("member");

		//return이 boolean타입
		boolean check=true;
		if(memberDTO==null) {
			check=false;
			//forward 형식일때 jsp -servlet 문법 사용
//			request.setAttribute("message", "로그인이 필요합니다");
//			request.setAttribute("path", "../member/login");
//			RequestDispatcher view=request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
//			view.forward(request, response);
			
			//redirect 형식 일때 ""
			response.sendRedirect("../member/login");
		}
		return check;
	}
}
