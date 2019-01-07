package com.myneko.client.boast.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myneko.client.boast.service.BoastService;
import com.myneko.client.boast.vo.BoastVO;
import com.myneko.client.common.util.Paging;
import com.myneko.client.common.util.Util;

import lombok.extern.java.Log;
@Log
@Controller
@RequestMapping(value = "/boast/**")
public class BoastController {
	@Autowired
	private BoastService boardService;
	//글목록
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView boastservice(@ModelAttribute BoastVO bvo, Model model) {
		// 페이징 세팅
		ModelAndView mav = new ModelAndView();
		Paging.setPage(bvo);
		// 전체 레코드수 구현
		int total = boardService.boastCnt(bvo);
		log.info(total + "" + bvo.getKeyword());
		// 글번호 재설정
		int count = total - (Util.nvl(bvo.getPage()) - 1) * Util.nvl(bvo.getPageSize());
		log.info("no" + bvo.getPage());
		List<BoastVO> boastList = boardService.boastList(bvo);
		// 페이징 추가
		mav.addObject("count", count);
		mav.addObject("total", total);
		mav.addObject("data", bvo);
		mav.addObject("boastList", boastList);
		mav.setViewName("/boast/boastList");
		return mav;
	}
	// 상세구현
	@RequestMapping(value = "/boastDetail", method = RequestMethod.GET)
	public String boastDetail(@ModelAttribute BoastVO pvo, Model model) {
		log.info(pvo.getB_number() + "");
		BoastVO detail = new BoastVO();
		detail = boardService.boastDetail(pvo);
		if (detail != null) {
			detail.setB_content(detail.getB_content().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "/boast/boastDetail";
	}

	// 글쓰기 폼 출력하기
	@RequestMapping(value = "/writeBoast")
	public String writeBoast() {
		log.info("writeBoast 호출성공");
		return "/boast/writeBoast";
	}
	// 글쓰기 구현하기
	@RequestMapping(value = "/boastInsert", method = RequestMethod.POST)
	public ModelAndView boastInsert(@ModelAttribute BoastVO bvo, Model model,HttpServletRequest request)  {
		System.out.println(bvo);
		ModelAndView mav = new ModelAndView();
		int result = 0;
		result = boardService.boastInsert(bvo);
		if (result == 1) {
			mav.addObject("code", 1);
		} else {
			mav.addObject("code", 0);
		}
		mav.setViewName("/boast/boastInsertSuc");
		return mav;
	}
	
	}

