package com.myneko.client.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myneko.client.notice.dao.NoticeDAO;
import com.myneko.client.notice.vo.NoticeVO;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO dao;

	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = new ArrayList<>();
		list = dao.noticeList();
		
		return list;
	}

	@Override
	public int noticeCount(NoticeVO nvo) {
		return dao.noticeCount(nvo);
	}

	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		return dao.noticeDetail(nvo);
	}

}
