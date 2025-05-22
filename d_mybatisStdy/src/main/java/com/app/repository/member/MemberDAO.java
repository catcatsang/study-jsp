package com.app.repository.member;

import org.apache.ibatis.session.SqlSession;

import com.app.domain.vo.MemberVO;
import com.app.mybatis.config.MyBatisConfig;

public class MemberDAO {

	public SqlSession sqlSession;
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	회원가입
 	public void insert (MemberVO memberVO) {
 		sqlSession.insert("member.insert", memberVO);
 	}
	
	
}
