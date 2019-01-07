package com.myneko.client.inquery.dao;

import java.util.List;

import com.myneko.client.inquery.vo.InqueryVO;

public interface InqueryDAO {
    //글목록
	public List<InqueryVO> InqueryList(InqueryVO ivo);

	//글삭제
	public int InqueryDelete(int iNumber);
	//글수정
	public int InUpdate(InqueryVO bvo);

	//글상세
	public InqueryVO InqueryDetail(InqueryVO pvo);

	//글입력
	public int Inqueryinsert(InqueryVO bvo);

	//페이징
	public int InqueryListCnt(InqueryVO bvo);

	

}
