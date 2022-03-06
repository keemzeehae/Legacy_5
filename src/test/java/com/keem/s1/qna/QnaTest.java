package com.keem.s1.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;
import com.keem.s1.util.Pager;

public class QnaTest extends MyJunitTest {

	@Autowired
	private QnaDAO qnaDAO;

	//@Test
	public void delete() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(21L);
		int result = qnaDAO.delete(qnaDTO);
		assertEquals(1, result);
	}

	// @Test
	public void detail() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(21L);
		qnaDTO = qnaDAO.detail(qnaDTO);
		assertNotNull(qnaDTO);
	}

	//@Test
	public void add() throws Exception {
		for (int i = 0; i < 200; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("title" + i);
			qnaDTO.setContents("test" + i);
			qnaDTO.setWriter("choi" + i);

			int result = qnaDAO.add(qnaDTO);

			if (i % 10 == 0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("Insert Done");
		// assertEquals(1, result);
	}

	// list
	@Test
	public void list() throws Exception {
		Pager pager=new Pager();
		pager.makeRow();
		
		List<QnaDTO> ar = qnaDAO.list(pager);
		System.out.println(ar.get(0).getNum());
		System.out.println(ar.get(9).getNum());
		assertEquals(10, ar.size());
	}

}
