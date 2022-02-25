package com.keem.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;
import com.keem.s1.util.Pager;

public class NoticeTest extends MyJunitTest {
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void list() throws Exception {
		Pager pager = new Pager();
		pager.setLine(10L);
		pager.makeRow();
		List<NoticeDTO> ar = noticeDAO.list(pager);
		System.out.println(ar.get(0).getNum());
		System.out.println(ar.get(9).getNum());
		
		assertEquals(10, ar.size());
	}

	//@Test
	public void add() throws Exception {
		for (int i = 0; i < 200; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("notice" + i);
			noticeDTO.setContents("contents" + i);
			noticeDTO.setWriter("bong" + i);
			// noticeDTO.setRegDate("2022/01/23");
			noticeDTO.setHit(0L);

			int result = noticeDAO.add(noticeDTO);
			if (i % 10 == 0) {
				Thread.sleep(1000);

			}
		}
		System.out.println("Insert done");
		// assertEquals(1, result);
	}

	// @Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(15L); // test
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}

	// @Test
	public void deleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);

	}

}
