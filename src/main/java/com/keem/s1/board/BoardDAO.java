package com.keem.s1.board;

import java.util.List;

import com.keem.s1.util.Pager;

public interface BoardDAO {

	//ADDFILE
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	//detail 추상메서드
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//list
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	//total 
	public Long total(Pager pager) throws Exception;
}

