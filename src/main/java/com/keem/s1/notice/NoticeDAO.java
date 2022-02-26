package com.keem.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keem.s1.util.Pager;
@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.keem.s1.notice.NoticeDAO.";
	
	//total
	public Long total(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total",pager);
	}
	
	//list
	public List<NoticeDTO> list (Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list",pager);
		
	}
	//insert
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail",noticeDTO);
	}
	//delete
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete",noticeDTO);
	} 

}

