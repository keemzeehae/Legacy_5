package com.keem.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BankbookDAO {
	

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESAPCE="com.keem.s1.bankbook.BankbookDAO.";
	
	//detail 
	public BankbookDTO detail(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.selectOne(NAMESAPCE+"detail", bankbookDTO);
		
	}
	
	
	//list
	public List<BankbookDTO> list() throws Exception{
		return sqlSession.selectList(NAMESAPCE+"list");
	}
	//insert
	public int add(BankbookDTO bankbookDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE+"add",bankbookDTO );
	}
	
	//delete
	public int delete(BankbookDTO bankbookDTO) throws Exception{
		return sqlSession.delete(NAMESAPCE+"delete", bankbookDTO);
	}
	
}
