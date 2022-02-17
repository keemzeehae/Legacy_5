package com.keem.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.keem.s1.MyJunitTest;


public class NoticeTest extends MyJunitTest {
	@Autowired
	private NoticeDAO noticeDAO;
	//@Test
	public void list() throws Exception{
		List<NoticeDTO> ar = noticeDAO.list();
		assertEquals(0,ar.size());
	}
	//@Test
	public void add() throws Exception{
		NoticeDTO noticeDTO= new NoticeDTO();
		noticeDTO.setTitle("notice2");
		noticeDTO.setContents("contents2");
		noticeDTO.setWriter("bong");
		//noticeDTO.setRegDate("2022/01/23");
		noticeDTO.setHit(10L);
		
		int result = noticeDAO.add(noticeDTO);
		assertEquals(1, result);
	}
	//@Test
	public void detailTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(15L); //여기 무슨말인지 이해가 잘 안감 이 줄이 왜 필요한지 모르겠음
		noticeDTO=noticeDAO.detail(1L);
		assertNotNull(noticeDTO);
	}
	@Test
	public void deleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(1L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
		
	} 
	
}
