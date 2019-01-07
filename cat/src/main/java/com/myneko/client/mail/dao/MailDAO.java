package com.myneko.client.mail.dao;

import java.util.List;

import com.myneko.client.member.vo.MemberVO;

public interface MailDAO {

	public List<MemberVO> findAccount(String email);

	public MemberVO findPassword(MemberVO mvo);
}
