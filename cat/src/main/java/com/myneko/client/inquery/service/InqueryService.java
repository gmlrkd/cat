package com.myneko.client.inquery.service;

import java.util.List;

import com.myneko.client.inquery.vo.InqueryVO;

public interface InqueryService {
	//글목록
	public List<InqueryVO> InqueryList(InqueryVO ivo);
	//글상세
	public InqueryVO InqueryDetail(InqueryVO pvo);
	//글삭제
	public int InqueryDelete(int i);
	//글쓰기
	public int Inqueryinsert(InqueryVO bvo);
	//글수정
	public int InUpdate(InqueryVO bvo);
	
	//전체 글목록 갯수
	public int InqueryListCnt(InqueryVO bvo);
	
}
