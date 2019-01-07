package com.myneko.client.review.dao;

import java.util.List;

import com.myneko.client.review.vo.ReviewVO;

public interface ReviewDao {

	public List<ReviewVO> reviewList(ReviewVO rvo);

	public int reviewInsert(ReviewVO rvo);

	public ReviewVO reviewDetail(ReviewVO rvo);

	public int reviewUpdate(ReviewVO rvo);

	public int reviewDelete(int r_number);

	public int reviewListCnt(ReviewVO rvo);
}
