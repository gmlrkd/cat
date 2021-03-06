package com.myneko.client.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myneko.client.mail.dao.MailDAO;
import com.myneko.client.member.vo.MemberVO;

@Service
@Transactional
public class MailServiceImpl implements MailService {

	@Autowired
	private MailDAO dao;

	@Override
	public List<MemberVO> findAccount(String email) {
		return dao.findAccount(email);
	}
	
	@Override
	public MemberVO findPassword(MemberVO mvo) {
		return dao.findPassword(mvo);
	}


}
