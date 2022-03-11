package com.keem.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.keem.s1.board.BoardDTO;
import com.keem.s1.board.notice.NoticeDTO;
import com.keem.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String board() {
		return "qna";
	}
	@RequestMapping(value="reply",method=RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result=qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	@RequestMapping(value="reply",method=RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO,ModelAndView mv) throws Exception{
		mv.addObject("dto",qnaDTO);//부모글 번호
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(BoardDTO boardDTO) throws Exception{
		int result=qnaService.update(boardDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO, QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO=qnaService.detail(qnaDTO);
		mv.setViewName("board/update");
		mv.addObject("dto",boardDTO);
		return mv;
	}
	
	@RequestMapping(value="delete")
	public String delete(BoardDTO boardDTO) throws Exception{
		int result=qnaService.delete(boardDTO);
		return "redirect:./list";
	}
		
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(BoardDTO boardDTO,MultipartFile [] files) throws Exception{
		int result=qnaService.add(boardDTO,files);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView add() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	//detail
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public String detail(BoardDTO boardDTO,Model model) throws Exception{
		boardDTO=qnaService.detail(boardDTO);
		model.addAttribute("dto",boardDTO);
		return "board/detail";
	}
	
	//list
	@RequestMapping(value="list",method=RequestMethod.GET)
	public String list(Pager pager,Model model) throws Exception{
		
		List<BoardDTO> ar=qnaService.list(pager);
		model.addAttribute("list",ar);
		return "board/list";
	}
}
