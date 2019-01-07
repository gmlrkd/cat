package com.myneko.client.cart.vo;

public class CartVO {
	private int ct_number;
	private int m_number;
	private int p_number;
	private String m_id;
	private int ct_amount;
	private String p_name;
	private int p_price;
	private int money;
	private int total_money;
	private String p_image;

	public CartVO() {
		super();
	}

	public int getCt_number() {
		return ct_number;
	}

	public void setCt_number(int ct_number) {
		this.ct_number = ct_number;
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

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getCt_amount() {
		return ct_amount;
	}

	public void setCt_amount(int ct_amount) {
		this.ct_amount = ct_amount;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

}
