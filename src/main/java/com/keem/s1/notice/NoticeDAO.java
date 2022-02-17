package com.keem.s1.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.keem.s1.notice.NoticeDAO.";
	
	
	public List<NoticeDTO> list () throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
		
	}
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add",noticeDTO);
	}
	
	public NoticeDTO detail(Long number) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"detail",number);
	}
	
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete",noticeDTO);
	} 

}

