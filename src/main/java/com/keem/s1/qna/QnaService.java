package com.keem.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keem.s1.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//list
	public List<QnaDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		Long totalCount = qnaDAO.total(pager);
		pager.makenum(totalCount);
		List<QnaDTO> ar = qnaDAO.list(pager);
		
		return ar;
	}
	
	//insert
	public int add(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.add(qnaDTO);
	}
	
	//detail
	public QnaDTO detail(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.detail(qnaDTO);
	}
	
	//delete
	public int delete(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.delete(qnaDTO);
	}
	
	//update
	public int update(QnaDTO qnaDTO) throws Exception{
		return qnaDAO.update(qnaDTO);
	}
}
