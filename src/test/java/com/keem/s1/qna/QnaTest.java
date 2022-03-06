package com.keem.s1.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;

public class QnaTest extends MyJunitTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void delete() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(21L);
		int result = qnaDAO.delete(qnaDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void detail() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(21L);
		qnaDTO=qnaDAO.detail(qnaDTO);
		assertNotNull(qnaDTO);
	}
	@Test
	public void add() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("confirm");
		qnaDTO.setContents("test");
		qnaDTO.setWriter("deo");
		
		int result = qnaDAO.add(qnaDTO);
		assertEquals(1, result);
	}
	
	
	//list
	//@Test
	public void list() throws Exception{
		List<QnaDTO> ar = qnaDAO.list();
		assertEquals(2, ar.size());
	}
	
	
}
