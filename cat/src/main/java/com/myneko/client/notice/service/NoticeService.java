package com.myneko.client.notice.service;

import java.util.List;

import com.myneko.client.notice.vo.NoticeVO;

public interface NoticeService {

	public List<NoticeVO> noticeList();
	
	//페이징
		public int noticeCount(NoticeVO nvo);
		
		public NoticeVO noticeDetail(NoticeVO nvo);
}
