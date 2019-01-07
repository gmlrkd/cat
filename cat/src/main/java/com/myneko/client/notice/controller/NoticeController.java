package com.myneko.client.notice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myneko.client.common.util.Paging;
import com.myneko.client.common.util.Util;
import com.myneko.client.notice.service.NoticeService;
import com.myneko.client.notice.vo.NoticeVO;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;

	
@RequestMapping(value="/list")
public String noticeList (@ModelAttribute NoticeVO nvo,Model model) {
	List<NoticeVO> list = new ArrayList<>();
	
	
	Paging.setPage(nvo);
	int total = service.noticeCount(nvo);
	int count = total - (Util.nvl(nvo.getPage()) - 1) * Util.nvl(nvo.getPageSize());
	
	list =service.noticeList();
	model.addAttribute("list",list);
	model.addAttribute("total",total);
	model.addAttribute("count", count);
	model.addAttribute("data", nvo);
	
	return "/notice/noticelist";
}

@RequestMapping(value="/detail",method=RequestMethod.GET)
public String noticeDetail(@ModelAttribute NoticeVO nvo,@RequestParam("n_number")String n_number,Model model) {
	
	System.out.println(n_number);
	
	nvo.setN_number(Integer.parseInt(n_number));
	nvo = service.noticeDetail(nvo);
	System.out.println(nvo.getN_content());
	
	model.addAttribute("nvo",nvo);
			
	return "/notice/detail";
}
@RequestMapping(value="/noticedetail",method=RequestMethod.GET)
public String Detail(@RequestParam("n_number")String n_number,Model model) {
	NoticeVO nvo = new NoticeVO();
	
	System.out.println(n_number);
	
	nvo.setN_number(Integer.parseInt(n_number));
	nvo = service.noticeDetail(nvo);
	System.out.println(nvo.getN_content());
	
	model.addAttribute("nvo",nvo);
			
	return "/noitce/noticedetail";
}


}
