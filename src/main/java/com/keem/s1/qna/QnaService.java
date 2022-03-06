package com.keem.s1.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	//list
	public List<QnaDTO> list() throws Exception{
		List<QnaDTO> ar = qnaDAO.list();
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
}
