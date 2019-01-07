package com.myneko.client.inquery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myneko.client.common.util.FileUploadUtil;
import com.myneko.client.common.util.Util;
import com.myneko.client.inquery.service.InqueryService;
import com.myneko.client.inquery.vo.InqueryVO;
import com.myneko.client.page.Paging;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping(value = "/inquery")
public class InqueryController {

	@Autowired
	private InqueryService InqueryService;

	// 글목록 구현하기
	@RequestMapping(value = "/InqueryList", method = RequestMethod.GET)
	public String InqueryList(@ModelAttribute InqueryVO bvo,@RequestParam("m_number") String m_number, Model model) {
		
		if(m_number == null) {
			return "inquery/InqueryList";
		}else {
		// 페이지 세팅
		Paging.setPage(bvo);
		// 전체 레코드수 구현
		// 글번호 재설정
		
		List<InqueryVO> InqueryList = InqueryService.InqueryList(bvo);

		int total = InqueryService.InqueryListCnt(bvo);
		log.info(total + "");

		int count = total - (Util.nvl(bvo.getPage()) - 1) * Util.nvl(bvo.getPageSize());
		log.info("count=" + count);

		model.addAttribute("inquery", InqueryList);
		model.addAttribute("data", bvo);
		model.addAttribute("count", count);
		model.addAttribute("total", total);

		return "inquery/InqueryList";
		}
	}

	// 글쓰기 구현하기
	@RequestMapping(value = "/Inqueryinsert", method = RequestMethod.POST)
	public String InqueryInsert(@ModelAttribute InqueryVO bvo, HttpServletRequest request) throws Exception {
		log.info("inqueryInsert 호출 성공");
		int result = 0;
		String mav = "";
		bvo.setI_whether("X");
		bvo.setM_number(Integer.parseInt(bvo.getM_number() + ""));
		if (bvo.getFile() != null) {
			String i_image = FileUploadUtil.fileUpload(bvo.getFile(), request, "inquiry");
			bvo.setI_image(i_image);
		} else {
			bvo.setI_image("'");
		}

		result = InqueryService.Inqueryinsert(bvo);

		if (result == 1) {
			mav = "redirect:/inquery/InqueryList?m_number=" + bvo.getM_number();
		} else {
			mav = "redirect:/inquery/InqueryWriteForm";
		}

		return mav;
	}

	// 글상세 보기
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value = "/InqueryDetail")
	public ModelAndView InqueryDetail(@ModelAttribute InqueryVO pvo, Model model) {
		log.info("inqueryDetail 호출 성공");

		InqueryVO detail = new InqueryVO();
		ModelAndView mav = new ModelAndView();
		detail = InqueryService.InqueryDetail(pvo);
		if (detail != null && (!detail.equals(""))) {
			detail.setI_content(detail.getI_content().toString().replaceAll("\n", "<br>"));
		}
		mav.addObject("inqueryDetail", detail);
		mav.setViewName("inquery/InqueryDetail");
		return mav;
	}

	// 글삭제 구현
	@RequestMapping(value = "InqueryDelete")
	public String InqueryDelete(@ModelAttribute InqueryVO bvo, HttpSession m_number) {
		log.info("inqueryDelete 호출 성공");
		int result = 0;
		result = InqueryService.InqueryDelete(bvo.getI_number());
		if (result == 1) {
			// 삭제후 목록으로 이동
			return "redirect:/inquery/InqueryList?m_number=" + m_number.getAttribute("m_number");
		} else {
			return "redirect:/inquery/InqueryDetail?number=" + bvo.getI_number();
		}
	}

	// 글 수정 폼 출력하기
	@RequestMapping(value = "/InqueryUpdateForm")
	public String InUpdateForm(@ModelAttribute InqueryVO ivo, Model model) {
		log.info("inqueryupdateForm 호출 성공");

		InqueryVO updateData = InqueryService.InqueryDetail(ivo);
		updateData = InqueryService.InqueryDetail(ivo);

		model.addAttribute("updateData", updateData);
		return "inquery/InqueryUpdateForm";
	}

	// 글수정 구현

	@RequestMapping(value = "/inqueryUpdate")
	public String InUpdate(@ModelAttribute InqueryVO bvo) {
		log.info("inqueryUpdate 호출 성공");

		int result = 0;
		String url = "";

		result = InqueryService.InUpdate(bvo);

		if (result == 1) {

			// 수정후 상세페이지으로 이동
			url = "/inquery/InqueryDetail?i_number=" + bvo.getI_number();
		} else {
			// 아래주소 수정후 목록 이동
			url = "/inquery/inqueryUpdateForm=" + bvo.getI_number();
		}

		return "redirect:" + url;
	}

	// 글 쓰기 폼 출력하기
	@RequestMapping(value = "/InqueryWriteForm", method = RequestMethod.GET)
	public String inqueryWriteForm() {
		log.info("inqueryWriteForm 호출 성공");
		return "inquery/InqueryWriteForm";
	}

}
