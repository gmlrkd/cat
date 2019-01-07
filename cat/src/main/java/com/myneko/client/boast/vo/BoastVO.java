package com.myneko.client.boast.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.myneko.client.common.vo.CommonVO;

import lombok.Data;

@Data
public class BoastVO extends CommonVO{
	private int b_number;// 글번호
	private String b_title;// 글제목
	private String b_image="";// 이미지
	private String b_content;// 내용
	private Date b_date;// 등록일
	private int m_number;// 회원번호
	private String b_division;
	//조건 검색시 사용할 필드
	private String search;
	private String keyword;
	//제목 클릭시 정렬을 위한 필드
	private String order_by;
	private String order_sc;
	//페이징 처리
	private String page;// 페이지 번호
	private String pageSize;// 페이지에 보여주는 줄수
	private String start_row;// 시작레코드 번호
	private String end_row;// 종료레코드 번호
	//파일업로드를 위한 속성
	private MultipartFile file;//첨부파일
	
}
