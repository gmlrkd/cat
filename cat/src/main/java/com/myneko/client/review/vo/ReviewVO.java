package com.myneko.client.review.vo;

import org.springframework.web.multipart.MultipartFile;

import com.myneko.client.common.vo.CommonVO;

public class ReviewVO extends CommonVO {

	private int r_number; // 글번호
	private String r_title; // 제목
	private String r_content; // 내용
	private String r_date; // 작성일
	private int r_starrate; // 평점
	private int m_number; // 회원번호
	private int p_number; // 상품번호

	//파일 업로드 위한 속성
	private MultipartFile file; //첨부파일
	private String r_file=""; //실제서버에 저장한 파일명
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getR_file() {
		return r_file;
	}

	public void setR_file(String r_file) {
		this.r_file = r_file;
	}

	public ReviewVO() {
		super();
	}

	public ReviewVO(int r_number, String r_title, String r_content, String r_image, String r_date, int r_starrate,
			int m_number, int p_number) {
		super();
		this.r_number = r_number;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_date = r_date;
		this.r_starrate = r_starrate;
		this.m_number = m_number;
		this.p_number = p_number;
	}

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public int getR_starrate() {
		return r_starrate;
	}

	public void setR_starrate(int r_starrate) {
		this.r_starrate = r_starrate;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public int getP_number() {
		return p_number;
	}

	public void setP_number(int p_number) {
		this.p_number = p_number;
	}

	@Override
	public String toString() {
		return "ReviewVO [r_number=" + r_number + ", r_title=" + r_title + ", r_content=" + r_content + ", r_image="
				+ ", r_date=" + r_date + ", r_starrate=" + r_starrate + ", m_number=" + m_number
				+ ", p_number=" + p_number + "]";
	}

}
