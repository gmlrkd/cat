package com.myneko.client.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myneko.client.common.page.Paging;
import com.myneko.client.common.util.FileUploadUtil;
import com.myneko.client.common.util.Util;
import com.myneko.client.review.service.ReviewService;
import com.myneko.client.review.vo.ReviewVO;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value = "/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// 리뷰목록
	@RequestMapping(value = "/reviewList", method = RequestMethod.GET)

	public String reviewList(@ModelAttribute ReviewVO rvo, Model model) {
		System.out.println("reviewList 호출 성공");
		rvo.setPageSize(5 + "");
		System.out.println(rvo.getP_number());
		Paging.setPage(rvo);
		int total = reviewService.reviewListCnt(rvo);
		log.info("total =" + total);

		// 글번호 재설정
		int count = total - (Util.nvl(rvo.getPage()) - 1) * Util.nvl(rvo.getPageSize());
		log.info("count=" + count);

		List<ReviewVO> reviewList = reviewService.reviewList(rvo);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("data", rvo);
		model.addAttribute("count", count);
		model.addAttribute("total", total);

		return "review/reviewList";
	}

	// reviewWriteForm 출력하기

	@RequestMapping(value = "/reviewWriteForm")
	public String reviewWriteForm() {
		log.info("reviewWriteForm 호출 성공");
		return "review/reviewWriteForm";
	}

	// review 쓰기 구현
	@RequestMapping(value = "/reviewInsert", method = RequestMethod.POST)
	public String reviewInsert(@ModelAttribute ReviewVO rvo, Model model, HttpServletRequest request) throws Exception {
		log.info("reviewInsert 호출 성공");

		int result = 0;
		String url = "";

		if (rvo.getFile() != null) {
			String r_file = FileUploadUtil.fileUpload(rvo.getFile(), request, "review");
			rvo.setR_file(r_file);
		}
		result = reviewService.reviewInsert(rvo);
		if (result == 1) {
			url = "/review/reviewList";
		} else {
			url = "/review/reviewWriteForm";
		}
		return "redirect:" + url;
	}

	// review 상세보기 구현
	@RequestMapping(value = "/reviewDetail", method = RequestMethod.GET)
	public String reviewDetail(@ModelAttribute ReviewVO rvo, Model model) {
		log.info("reviewDetail 호출 성공");
		log.info("r_number=" + rvo.getR_number());

		ReviewVO detail = new ReviewVO();
		detail = reviewService.reviewDetail(rvo);

		if (detail != null && (!detail.equals(""))) {
			detail.setR_content(detail.getR_content().toString().replaceAll("\n", "<br>"));
		}

		model.addAttribute("reviewDetail", detail);

		return "review/reviewDetail";
	}

	// 글 수정 폼 출력 하기
	@RequestMapping(value = "/updateForm")
	public String updateForm(@ModelAttribute ReviewVO rvo, Model model) {
		log.info("updateForm 호출 성공");
		log.info("r_number=" + rvo.getR_number());
		ReviewVO updateData = new ReviewVO();
		updateData = reviewService.reviewDetail(rvo);

		model.addAttribute("updateData", updateData);
		return "review/updateForm";
	}

	// review 글수정 구현
	@RequestMapping(value = "/reviewUpdate", method = RequestMethod.POST)
	public String reviewUpdate(@ModelAttribute ReviewVO rvo) {
		log.info("reviewUpdate 호출 성공");

		int result = 0;
		String url = "";
		result = reviewService.reviewUpdate(rvo);

		if (result == 1) {
			url = "/review/reviewDetail?r_number=" + rvo.getR_number();
		} else {
			url = "/review/updateForm=" + rvo.getR_number();
		}

		return "redirect:" + url;
	}

	// review 삭제 구현하기
	@RequestMapping(value = "/reviewDelete")
	public String reviewDelete(@ModelAttribute ReviewVO rvo) {
		log.info("reviewDelete 호출 성공");

		int result = 0;
		String url = "";

		result = reviewService.reviewDelete(rvo.getR_number());

		if (result == 1) {
			url = "/review/reviewList";
		} else {
			url = "/review/reviewDetail?r_number=" + rvo.getR_number();
		}
		return "redirect:" + url;
	}
}
