package com.keem.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.keem.s1.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="delete")
	public String delete(NoticeDTO noticeDTO) throws Exception{
		int result=noticeService.delete(noticeDTO);
		return "redirect:./list";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO) throws Exception{
		int result =noticeService.add(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() throws Exception{
		
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView mv, NoticeDTO noticeDTO) throws Exception{
		noticeDTO=noticeService.detail(noticeDTO);
		mv.addObject("notice", noticeDTO);
		mv.setViewName("notice/detail");
		return mv;
	}
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception{
		
		List<NoticeDTO> ar = noticeService.list(pager);
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
		mv.setViewName("notice/list");
		
		return mv;
	}
}
