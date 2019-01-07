package com.myneko.client.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myneko.client.review.vo.ReviewVO;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	private SqlSession session;

	public List<ReviewVO> reviewList(ReviewVO rvo) {
		return session.selectList("reviewList", rvo);
	}

	@Override
	public int reviewInsert(ReviewVO rvo) {
		return session.insert("reviewInsert", rvo);
	}

	// review 상세 구현
	@Override
	public ReviewVO reviewDetail(ReviewVO rvo) {
		return (ReviewVO) session.selectOne("reviewDetail", rvo);
	}

	@Override
	public int reviewUpdate(ReviewVO rvo) {
		return session.update("reviewUpdate", rvo);
	}

	@Override
	public int reviewDelete(int r_number) {
		return session.delete("reviewDelete", r_number);
	}

	@Override
	public int reviewListCnt(ReviewVO rvo) {
		return (Integer)session.selectOne("reviewListCnt", rvo);
	}

}
