package com.keem.s1.bankbook;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.keem.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankbookController {

	@Autowired
	private BankbookService bankbookService;

	
	//update
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(BankbookDTO bankbookDTO) throws Exception{
		int result=bankbookService.update(bankbookDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public void update(BankbookDTO bankbookDTO, Model model) throws Exception{
		//매개변수로 받은 DTO랑 detail()안에 들어있는 DTO랑 값이 다름 결과값을 덮어씌우는것
		bankbookDTO=bankbookService.detail(bankbookDTO);
		model.addAttribute("dto",bankbookDTO);
	}
	
	@RequestMapping(value="delete")
	public String delete(BankbookDTO bankbookDTO,Model model) throws Exception{
		int result = bankbookService.delete(bankbookDTO);
		
		String view="common/result";
		if(bankbookDTO==null) {
			model.addAttribute("path","bankbook/list");
			model.addAttribute("message","없는 번호 입니다");
			
		}else {
			model.addAttribute("path","./list");
			model.addAttribute("message","삭제되었습니다");
		}
		return view;
		
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

	//조회가 성공하면 출력
	//조회가 실패하면 alert 로 없는 번호입니다 
	// 다시 list로 이동
	//common/result 활용
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(Model model, BankbookDTO bankbookDTO) throws Exception{
		bankbookDTO= bankbookService.detail(bankbookDTO);
		String view="common/result";
		
		if (bankbookDTO!=null) {
			view="bankbook/detail";
			model.addAttribute("book",bankbookDTO);
		}else {
			model.addAttribute("message","없는번호 입니다");
			model.addAttribute("path","./list");
		}
		return view;
	}
//Modle 로만 해도 void로 해주면 기본으로 찾아서 들어가니까 Model 이라고 하는게 더 편할 수 있음
	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// ModelandView
		// 매개변수 선언
		// 메서드내에서 객체 생성

		List<BankbookDTO> ar = bankbookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager",pager);
		mv.setViewName("bankbook/list");
		return mv;
	}
}
