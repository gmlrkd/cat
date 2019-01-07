package com.myneko.client.notice.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myneko.client.notice.vo.NoticeVO;

@Repository
public interface NoticeDAO {
	
	public List<NoticeVO> noticeList();
	
	//페이징
	public int noticeCount(NoticeVO nvo);
	
	public NoticeVO noticeDetail(NoticeVO nvo);

}
