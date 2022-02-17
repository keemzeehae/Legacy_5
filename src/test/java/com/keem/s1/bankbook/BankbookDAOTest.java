package com.keem.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;

public class BankbookDAOTest extends MyJunitTest {

	@Autowired
	private BankbookDAO bankbookDAO;
	@Test
	public void check() {
		assertNotNull(bankbookDAO);
	}
	//list
	@Test
	public void list() throws Exception{
		List<BankbookDTO> ar =bankbookDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	//insert -add
	//@Test
	public void add() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookName("book2");
		bankbookDTO.setBookContents("contents");
		bankbookDTO.setBookRate(5.1);
		bankbookDTO.setBookSale(1);
		
		int result = bankbookDAO.add(bankbookDTO);
		assertEquals(1, result);
	}
	@Test
	public void detailTest() throws Exception{
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNumber(150L);
		bankbookDTO=bankbookDAO.detail(2L);
		assertNotNull(bankbookDTO);
	}
	//delete
	@Test
	public void deleteTest() throws Exception{
		BankbookDTO bankbookDTO= new BankbookDTO();
		bankbookDTO.setBookNumber(2L);
		int result = bankbookDAO.delete(bankbookDTO);
		assertEquals(1, result);
	}
}
