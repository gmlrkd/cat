package com.myneko.client.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myneko.client.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<NoticeVO> noticeList() {
		
		return session.selectList("noticeList");
	}

	@Override
	public int noticeCount(NoticeVO nvo) {
		
		return (Integer)session.selectOne("noticeCount", nvo);
	}

	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		return session.selectOne("noticeDetail",nvo);
	}

}
