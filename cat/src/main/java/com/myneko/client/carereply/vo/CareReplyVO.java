package com.myneko.client.carereply.vo;

public class CareReplyVO {
	private int rep_number;
	private String rep_content;
	private String rep_date;
	private String rep_id;
	private int ci_number;
	private int m_number;

	public CareReplyVO() {
		super();
	}

	public CareReplyVO(int rep_number, String rep_content, String rep_date, String rep_id, int ci_number,
			int m_number) {
		super();
		this.rep_number = rep_number;
		this.rep_content = rep_content;
		this.rep_date = rep_date;
		this.rep_id = rep_id;
		this.ci_number = ci_number;
		this.m_number = m_number;
	}

	public int getRep_number() {
		return rep_number;
	}

	public void setRep_number(int rep_number) {
		this.rep_number = rep_number;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public String getRep_date() {
		return rep_date;
	}

	public void setRep_date(String rep_date) {
		this.rep_date = rep_date;
	}

	public String getRep_id() {
		return rep_id;
	}

	public void setRep_id(String rep_id) {
		this.rep_id = rep_id;
	}

	public int getCi_number() {
		return ci_number;
	}

	public void setCi_number(int ci_number) {
		this.ci_number = ci_number;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}
}
