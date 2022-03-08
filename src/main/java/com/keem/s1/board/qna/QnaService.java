package com.keem.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keem.s1.board.BoardDTO;
import com.keem.s1.board.BoardService;
import com.keem.s1.util.Pager;
@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {

		pager.makeRow();
		pager.makenum(qnaDAO.total(pager));
	
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

	
	public int reply(QnaDTO qnaDTO) throws Exception{
		//qnaDTO .num : 부모글의 num
		//qnaDTO .title : 폼에서 입력한 답글제목 
		//qnaDTO .writer : 폼에서 입력한 답글작성자
		//qnaDTO .contents :  폼에서 작성한 답글 내용
		//qnaDTO .regDate :  NULL
		//qnaDTO .hit :  NULL
		//qnaDTO .ref :  NULL 부모글의 글번호가 무조건 ref가 같지는 않음
		//qnaDTO .step :  NULL
		//qnaDTO .depth :  NULL
		// 글을 하나 조회하는 method-> detail
		//1. 부모의 정보를 조회 (ref,step,depth)
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		//2. 답글의 ref는 부모의 ref 값
		qnaDTO.setRef(parent.getRef());
		//3. 답글의 step은 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		//4. 답글의 depth 는 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//5. step update 
		//System.out.println(parent.getStep());
		//System.out.println(parent.getRef());
		
		int result=qnaDAO.stepUpdate(parent);
		
		//System.out.println(result);
		
		//6. 답글 insert 
		result=qnaDAO.reply(qnaDTO);

		return result;
	}
}
