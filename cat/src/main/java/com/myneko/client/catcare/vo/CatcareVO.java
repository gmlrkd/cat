package com.myneko.client.catcare.vo;

import com.myneko.client.common.vo.CommonVO;

public class CatcareVO extends CommonVO {
	private int ci_number;
	private String ci_title;
	private String ci_content;
	private String ci_writer;
	private String ci_image;
	private String ci_date;
	private int a_number;

	public CatcareVO() {
		super();
	}

	public CatcareVO(int ci_number, String ci_title, String ci_content, String ci_writer, String ci_image,
			String ci_date, int a_number) {
		super();
		this.ci_number = ci_number;
		this.ci_title = ci_title;
		this.ci_content = ci_content;
		this.ci_writer = ci_writer;
		this.ci_image = ci_image;
		this.ci_date = ci_date;
		this.a_number = a_number;
	}

	public int getCi_number() {
		return ci_number;
	}

	public void setCi_number(int ci_number) {
		this.ci_number = ci_number;
	}

	public String getCi_title() {
		return ci_title;
	}

	public void setCi_title(String ci_title) {
		this.ci_title = ci_title;
	}

	public String getCi_content() {
		return ci_content;
	}

	public void setCi_content(String ci_content) {
		this.ci_content = ci_content;
	}

	public String getCi_writer() {
		return ci_writer;
	}

	public void setCi_writer(String ci_writer) {
		this.ci_writer = ci_writer;
	}

	public String getCi_image() {
		return ci_image;
	}

	public void setCi_image(String ci_image) {
		this.ci_image = ci_image;
	}

	public String getCi_date() {
		return ci_date;
	}

	public void setCi_date(String ci_date) {
		this.ci_date = ci_date;
	}

	public int getA_number() {
		return a_number;
	}

	public void setA_number(int a_number) {
		this.a_number = a_number;
	}

}
