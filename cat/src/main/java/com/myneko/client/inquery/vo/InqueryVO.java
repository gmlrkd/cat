package com.myneko.client.inquery.vo;

import org.springframework.web.multipart.MultipartFile;

import com.myneko.client.common.vo.CommonVO;

public class InqueryVO extends CommonVO {
	private int i_number;// 글번호
	private String i_content;// 내용
	private String i_title;// 제목
	private MultipartFile file; // 파일
	private String i_image;// 이미지
	private String i_whether;// 답변여부
	private String i_date;// 등록일
	private int m_number; // 작성자 번호
	private String m_id;//작성자 아이디
	
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getI_number() {
		return i_number;
	}

	public void setI_number(int i_number) {
		this.i_number = i_number;
	}

	public String getI_content() {
		return i_content;
	}

	public void setI_content(String i_content) {
		this.i_content = i_content;
	}

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_image() {
		return i_image;
	}

	public void setI_image(String i_image) {
		this.i_image = i_image;
	}

	public String getI_whether() {
		return i_whether;
	}

	public void setI_whether(String i_whether) {
		this.i_whether = i_whether;
	}

	public String getI_date() {
		return i_date;
	}

	public void setI_date(String i_date) {
		this.i_date = i_date;
	}

}
