package com.keem.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BankbookDAO {
	

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.keem.s1.bankbook.BankbookDAO.";
	
	//update
	public int update(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update",bankbookDTO);
	}
	
	//detail 
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detail", bankbookDTO);
		
	}
	
	
	//list
	public List<BankbookDTO> list() throws Exception{
		return sqlSession.selectList(NAMESPACE+"list");
	}
	//insert
	public int add(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add",bankbookDTO );
	}
	
	//delete
	public int delete(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", bankbookDTO);
	}
	
}
