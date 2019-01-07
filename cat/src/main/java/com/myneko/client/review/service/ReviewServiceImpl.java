package com.myneko.client.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myneko.client.review.dao.ReviewDao;
import com.myneko.client.review.vo.ReviewVO;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	//review목록 구현
	@Override
	public List<ReviewVO> reviewList(ReviewVO rvo) {
		List<ReviewVO> myList = null;
		myList = reviewDao.reviewList(rvo);
		return myList;
	}

	
	// review 입력 구현
	public int reviewInsert(ReviewVO rvo) {
		int result = 0;
		try {
			result = reviewDao.reviewInsert(rvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	//review 상세 구현
	@Override
	public ReviewVO reviewDetail(ReviewVO rvo) {
		ReviewVO detail = null;
		detail = reviewDao.reviewDetail(rvo);
		return detail;
	}


	@Override
	public int reviewUpdate(ReviewVO rvo) {
		int result = 0;
		try {
			result = reviewDao.reviewUpdate(rvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


	@Override
	public int reviewDelete(int r_number) {
		int result = 0;
		try {
			result = reviewDao.reviewDelete(r_number);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


	@Override
	public int reviewListCnt(ReviewVO rvo) {
		return reviewDao.reviewListCnt(rvo);
	}



}
