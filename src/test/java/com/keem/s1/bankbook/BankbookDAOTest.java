package com.keem.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;
import com.keem.s1.util.Pager;

public class BankbookDAOTest extends MyJunitTest {

	@Autowired
	private BankbookDAO bankbookDAO;

	// @Test
	public void check() {
		assertNotNull(bankbookDAO);
	}

	// list
	@Test
	public void list() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<BankbookDTO> ar = bankbookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(9).getBookNumber());
		assertEquals(10, ar.size());
	}

	// insert -add
	//@Test
	public void add() throws Exception {
		
		for (int i=0; i<200; i++) {
			BankbookDTO bankbookDTO = new BankbookDTO();
			bankbookDTO.setBookName("bookname"+i);
			bankbookDTO.setBookContents("contents"+i);
			
			double rate = Math.random(); //0.0~1.0 미만을 리턴해줌 0.1234567
			rate=rate*1000;   //123.45678
			int r = (int)rate; //123
			rate=r/100.0;//1.23
			
			bankbookDTO.setBookRate(rate); //총3자리, 소숫점 2자리
			bankbookDTO.setBookSale(1);

			int result = bankbookDAO.add(bankbookDTO);
			
			if(i%10==0) {
			Thread.sleep(1000); //1초동안 멈추세요 밀리세컨즈 단위
			}
		}
		System.out.println("Insert Done");
		//assertEquals(1, result);
	} 

	// @Test
	public void detailTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(150L);
		bankbookDTO = bankbookDAO.detail(bankbookDTO);
		assertNotNull(bankbookDTO);
	}

	// delete
	// @Test
	public void deleteTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(2L);
		int result = bankbookDAO.delete(bankbookDTO);
		assertEquals(1, result);
	}
}
