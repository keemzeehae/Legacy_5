package com.keem.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="mypage",method=RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//value값은 object type 이고  object의 특징은 모든 클래스의 부모라는 점
		MemberDTO memberDTO=(MemberDTO)session.getAttribute("member");
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto",memberDTO);
		return mv;
	}
	
	//logout
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
		
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpSession session,MemberDTO memberDTO, String remember, Model model, HttpServletResponse response) throws Exception{
		System.out.println("Remember: "+remember);
		
		if (remember!=null&&remember.equals("1")) {
			
			//쿠키 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			//cookie.setPath("/");
			cookie.setMaxAge(-1);
			//응답
			response.addCookie(cookie);
			
		}else {
			Cookie cookie= new Cookie("remember","");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO= memberService.login(memberDTO);
		
//		String path="redirect:./login";
//		if(memberDTO !=null) {
//			//로그인한 사용자의 정보가 Session에 들어가 있음 member라는 이름으로 
//			session.setAttribute("member", memberDTO);
//			path="redirect:../";
//		}
		String message="Login fail";
		String p="./login";
		
		if(memberDTO!=null) {
			session.setAttribute("member", memberDTO);
			message="Login Success";
			p="../";
		}
		model.addAttribute("path",p);
		model.addAttribute("message",message);
		String path="common/result";
		return path;
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public void login(Model model,@CookieValue(value="rememberId",defaultValue ="",required=false) String rememberId) throws Exception{
		model.addAttribute("rememberId", rememberId);
	}
	
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, MultipartFile photo) throws Exception{
		System.out.println(photo.getOriginalFilename());
		System.out.println(photo.getSize());
		int result = memberService.join(memberDTO,photo);
		return "redirect:../";
	}

	@RequestMapping(value="join",method=RequestMethod.GET)
	public void join() throws Exception{
		
	}
	@RequestMapping(value="joinCheck",method=RequestMethod.GET)
	public void joinCheck() throws Exception {
		
	}
}
