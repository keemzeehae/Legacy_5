package com.keem.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keem.s1.util.Pager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
	
	
	public int add (NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	//list
	public List<NoticeDTO> list(Pager pager) throws Exception{
		//DAO 메서드 호출 전 전처리 작업
		pager.makeRow();
		Long totalCount=noticeDAO.total(pager);
		pager.makeNum(totalCount);
		
		//호출 후 후처리 작업 
		List<NoticeDTO> ar = noticeDAO.list(pager);
		return ar;
		
	}
}
