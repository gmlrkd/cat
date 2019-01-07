package com.myneko.client.myorder.vo;

import com.myneko.client.common.vo.CommonVO;

public class myorderVO extends CommonVO {
	private int o_number; // 주문번호
	private String o_state; // 주문상태
	private int o_amount; // 주문수량
	private String o_trackno; // 운송장 번호
	private String o_date; // 주문일자
	private String o_chargeway; // 결제수단
	private int o_usemilage; // 사용한 마일리지
	private int o_totalprice; // 주문총액
	private String o_address; // 배송지 주소
	private String o_phone; // 수취인 연락저
	private String o_name; // 수취인성명
	private String o_zipcode; // 배송지우편번호
	private int m_number; // 회원번호
	private int p_number; // 상품번호

	public myorderVO() {
		super();
	}

	public myorderVO(int o_number, String o_state, int o_amount, String o_trackno, String o_date,
			String o_chargeway, int o_usemilage, int o_totalprice, String o_address, String o_phone, String o_name,
			String o_zipcode, int m_number, int p_number) {
		super();
		this.o_number = o_number;
		this.o_state = o_state;
		this.o_amount = o_amount;
		this.o_trackno = o_trackno;
		this.o_date = o_date;
		this.o_chargeway = o_chargeway;
		this.o_usemilage = o_usemilage;
		this.o_totalprice = o_totalprice;
		this.o_address = o_address;
		this.o_phone = o_phone;
		this.o_name = o_name;
		this.o_zipcode = o_zipcode;
		this.m_number = m_number;
		this.p_number = p_number;
	}

	public int getO_number() {
		return o_number;
	}

	public void setO_number(int o_number) {
		this.o_number = o_number;
	}

	public String getO_state() {
		return o_state;
	}

	public void setO_state(String o_state) {
		this.o_state = o_state;
	}

	public int getO_amount() {
		return o_amount;
	}

	public void setO_amount(int o_amount) {
		this.o_amount = o_amount;
	}

	public String getO_trackno() {
		return o_trackno;
	}

	public void setO_trackno(String o_trackno) {
		this.o_trackno = o_trackno;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getO_chargeway() {
		return o_chargeway;
	}

	public void setO_chargeway(String o_chargeway) {
		this.o_chargeway = o_chargeway;
	}

	public int getO_usemilage() {
		return o_usemilage;
	}

	public void setO_usemilage(int o_usemilage) {
		this.o_usemilage = o_usemilage;
	}

	public int getO_totalprice() {
		return o_totalprice;
	}

	public void setO_totalprice(int o_totalprice) {
		this.o_totalprice = o_totalprice;
	}

	public String getO_address() {
		return o_address;
	}

	public void setO_address(String o_address) {
		this.o_address = o_address;
	}

	public String getO_phone() {
		return o_phone;
	}

	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_zipcode() {
		return o_zipcode;
	}

	public void setO_zipcode(String o_zipcode) {
		this.o_zipcode = o_zipcode;
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
		return "myorderListVO [o_number=" + o_number + ", o_state=" + o_state + ", o_amount=" + o_amount
				+ ", o_trackno=" + o_trackno + ", o_date=" + o_date + ", o_chargeway=" + o_chargeway + ", o_usemileage="
				+ o_usemilage + ", o_totalprice=" + o_totalprice + ", o_address=" + o_address + ", o_phone=" + o_phone
				+ ", o_name=" + o_name + ", o_zipcode=" + o_zipcode + ", m_number=" + m_number + ", p_number="
				+ p_number + "]";
	}

}
