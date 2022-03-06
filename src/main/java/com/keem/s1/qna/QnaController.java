package com.keem.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(QnaDTO qnaDTO) throws Exception{
		int result =qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView detail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaDTO = qnaService.detail(qnaDTO);
		mv.addObject("dto",qnaDTO);
		mv.setViewName("qna/detail");
		return mv;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(QnaDTO qnaDTO) throws Exception{
		int result=qnaService.add(qnaDTO);
		return "redirect:./list";
				
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public void add() throws Exception{
		
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception{
		List<QnaDTO> ar = qnaService.list();
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		return mv;
	}
	
}
