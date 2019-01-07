package com.myneko.client.inquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myneko.client.inquery.dao.InqueryDAO;
import com.myneko.client.inquery.vo.InqueryVO;

@Service
@Transactional
public class InqueryServiceImpl implements InqueryService {
	@Autowired
	private InqueryDAO InqueryDao;

//리스트 전체 글목록 수 구현
@Override
public int InqueryListCnt(InqueryVO bvo) {
	
	return InqueryDao.InqueryListCnt(bvo);
}

	@Override
	//글목록 구현
	public List<InqueryVO> InqueryList(InqueryVO ivo) {
		List<InqueryVO> myList = null;
		
		myList = InqueryDao.InqueryList(ivo);
		return myList;
	}

	//글상세
	@Override
	public InqueryVO InqueryDetail(InqueryVO pvo) {
		InqueryVO detail = InqueryDao.InqueryDetail(pvo);
		return detail;
	}

	//글삭제
	@Override
	public int InqueryDelete(int i_number) {
		int result = 0;
		try {
			result = InqueryDao.InqueryDelete(i_number);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	//글입력
	public int Inqueryinsert(InqueryVO bvo) {
		
		System.out.println(bvo.getI_content());
		int result = 0;
		try {
			result = InqueryDao.Inqueryinsert(bvo);

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

	
	//글수정
	@Override
	public int InUpdate(InqueryVO bvo) {
		int result = 0;
		try {
			result = InqueryDao.InUpdate(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

}
