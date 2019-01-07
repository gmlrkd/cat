package com.myneko.client.mail.service;

import java.util.List;

import com.myneko.client.member.vo.MemberVO;

public interface MailService {
	
	public List<MemberVO> findAccount(String email);
	
	public MemberVO findPassword(MemberVO mvo);
	
}
