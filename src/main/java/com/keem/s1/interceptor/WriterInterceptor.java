package com.keem.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.keem.s1.board.BoardDTO;
import com.keem.s1.board.qna.QnaDAO;
import com.keem.s1.board.qna.QnaDTO;
import com.keem.s1.member.MemberDTO;

@Component
public class WriterInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		boolean check=true;
		System.out.println("Writer Interceptor");
		
		Long num=Long.parseLong(request.getParameter("num"));
		BoardDTO boardDTO = new QnaDTO();
		boardDTO.setNum(num);
		boardDTO=qnaDAO.detail(boardDTO);
		
		MemberDTO memberDTO= (MemberDTO)request.getSession().getAttribute("member");
		
		if(!boardDTO.getWriter().equals(memberDTO.getId())) {
			check=false;
			//forward 방식
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("path", "./list");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			//redirect 방식
		}
		return check;
	}
}
