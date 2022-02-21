package com.keem.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankbookController {

	@Autowired
	private BankbookService bankbookService;
	
	@RequestMapping(value="delete")
	public String delete(BankbookDTO bankbookDTO) throws Exception{
		int result = bankbookService.delete(bankbookDTO);
		return "redirect:./list";
		
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(BankbookDTO bankbookDTO) throws Exception{
		int result= bankbookService.add(bankbookDTO);
		//view의 이름을 줘야함 String을 준 이유
		return "redirect:./list";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() throws Exception {
		
	}

	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView mv, BankbookDTO bankbookDTO) throws Exception{
		bankbookDTO= bankbookService.detail(bankbookDTO);
		mv.addObject("book", bankbookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
//Modle 로만 해도 void로 해주면 기본으로 찾아서 들어가니까 Model 이라고 하는게 더 편할 수 있음
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		// ModelandView
		// 매개변수 선언
		// 메서드내에서 객체 생성

		List<BankbookDTO> ar = bankbookService.list();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/list");
		return mv;
	}
}
