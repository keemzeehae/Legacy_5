package com.keem.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		System.out.println("Controller 진입 전 실행");
		// TODO Auto-generated method stub
//		prehandler -> 디스패처서블릿에서 컨트롤러로 가는 사이에 실행된다
//		return 이 true면 controller로 계속 진행
//		return 이 false면 controller로 진행 x
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Controller에서 Dispatcher Servlet으로 가기전 실행");

	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("view(jsp)렌더링 후 (html변환 후) 실행");
		
	}
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
	
		System.out.println("비동기 요청시 postHandle과 afterCompletion을 수행하지 않고 이메서드를 수행");
	}
}
