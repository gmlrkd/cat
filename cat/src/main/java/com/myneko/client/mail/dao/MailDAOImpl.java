package com.myneko.client.mail.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myneko.client.member.vo.MemberVO;

@Repository
public class MailDAOImpl implements MailDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<MemberVO> findAccount(String email) {
		return session.selectList("findAccount",email);
	}
	@Override
	public MemberVO findPassword(MemberVO mvo) {
		return session.selectOne("findPassword",mvo);
	}

}
