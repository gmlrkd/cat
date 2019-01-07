package com.myneko.client.carereply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myneko.client.carereply.service.CareReplyService;
import com.myneko.client.carereply.vo.CareReplyVO;

import lombok.extern.java.Log;

@RestController
@RequestMapping(value="/replies")
@Log
public class CareReplyController {
	
	@Autowired
	private CareReplyService careReplyService;
	
	// 댓글 목록 구현
	@RequestMapping(value = "/all/{ci_number}.do", method = RequestMethod.GET)
	public ResponseEntity<List<CareReplyVO>> list(@PathVariable("ci_number") Integer ci_number){
		ResponseEntity<List<CareReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(careReplyService.replyList(ci_number), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 댓글 쓰기 구현
	@RequestMapping(value="/replyInsert")
	public ResponseEntity<String> replyInsert(@RequestBody CareReplyVO rvo){
		log.info("replyInsert 호출 성공!");
		ResponseEntity<String> entity = null;
		int result;
		try {
			result = careReplyService.replyInsert(rvo);
			if(result==1) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 댓글 수정
	@RequestMapping(value ="/{rep_number}.do", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> replyUpdate(@PathVariable("rep_number") Integer rep_number, @RequestBody CareReplyVO rvo) {
		log.info("replyUpdate 호출 성공!");
		ResponseEntity<String> entity = null;
		try {
			rvo.setRep_number(rep_number);
			careReplyService.replyUpdate(rvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	// 댓글 삭제
	@RequestMapping(value = "/{rep_number}.do", method = RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable("rep_number") Integer rep_number) {
		log.info("replyDelete 호출 성공!");
		ResponseEntity<String> entity = null;
		try {
			careReplyService.replyDelete(rep_number);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}

















