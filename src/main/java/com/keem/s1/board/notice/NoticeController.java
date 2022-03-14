package com.keem.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.keem.s1.board.BoardDTO;
import com.keem.s1.board.BoardFileDTO;
import com.keem.s1.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String board() {
		return "notice";
	}
	@RequestMapping(value="photoDownload", method = RequestMethod.GET)
	public ModelAndView fileDown(NoticeFileDTO noticeFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeFileDTO = noticeService.detailFile(noticeFileDTO);
		//file down받는 클래스 bean의 이름으로 
		
		mv.setViewName("fileDown");
		mv.addObject("file",noticeFileDTO);
		return mv;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception{
		int result=noticeService.update(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO,NoticeDTO noticeDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO=noticeService.detail(noticeDTO);
		mv.setViewName("board/update");
		mv.addObject("dto",boardDTO);
		return mv;
	}
	
	
	@RequestMapping(value="delete")
	public String delete(NoticeDTO noticeDTO) throws Exception{
		int result=noticeService.delete(noticeDTO);
		return "redirect:./list";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO,MultipartFile [] files) throws Exception{
		int result =noticeService.add(noticeDTO,files);
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public ModelAndView add() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView mv, NoticeDTO noticeDTO) throws Exception{
		BoardDTO boardDTO=noticeService.detail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	//list
	@RequestMapping(value="list", method=RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.list(pager);
		mv.addObject("list",ar);
		mv.setViewName("board/list");
		
		return mv;
	}
}
