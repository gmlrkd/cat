package com.myneko.client.inquery.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myneko.client.inquery.vo.InqueryVO;

@Repository
public class InqueryDAOImpl implements InqueryDAO {
	@Autowired
	private SqlSession session;
	
	//전체 레코드 건수 구현
	@Override
	public int InqueryListCnt(InqueryVO bvo) {
		
		return (Integer)session.selectOne("InqueryListCnt", bvo);
	}

//글목록 구현
	@Override
	public List<InqueryVO> InqueryList(InqueryVO ivo) {

		return session.selectList("InqueryList", ivo);

	}

	// 삭제
	@Override
	public int InqueryDelete(int iNumber) {

		return (Integer) session.delete("InqueryDelete", iNumber);
	}

	// 글 수정
	@Override
	public int InUpdate(InqueryVO bvo) {

		return session.update("InUpdate", bvo);
	}

	// 상세구현
	@Override
	public InqueryVO InqueryDetail(InqueryVO pvo) {

		return (InqueryVO) session.selectOne("InqueryDetail", pvo);
	}

	// 글입력
	@Override
	public int Inqueryinsert(InqueryVO bvo) {
		System.out.println(bvo.getI_content());
		return (Integer) session.insert("Inqueryinsert", bvo);
	}

}
