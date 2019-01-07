package com.myneko.client.member.vo;

import java.util.Date;

public class MemberVO {
	private int m_number;
	private String m_name;
	private String m_state;
	private String m_phone;
	private String m_password;
	private String m_id;
	private String m_zipcode;
	private String m_address;
	private String m_email;
	private int m_milage;
	private int c_number;
	private Date m_register;

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public String getM_state() {
		return m_state;
	}

	public void setM_state(String m_state) {
		this.m_state = m_state;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public int getM_milage() {
		return m_milage;
	}

	public void setM_milage(int m_milage) {
		this.m_milage = m_milage;
	}

	public Date getM_register() {
		return m_register;
	}

	public void setM_register(Date m_register) {
		this.m_register = m_register;
	}

	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_zipcode() {
		return m_zipcode;
	}

	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}


	
}
