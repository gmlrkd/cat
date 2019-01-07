package com.myneko.client.cart.vo;

import lombok.Data;

@Data
public class CatorderVO {
	
	private int o_number;	//구매번호
	private String o_state;	//구매건 상태
	
	private String o_waybill;	//송장번호
	private String o_date;		//주문한날짜
	private String o_paywith;	//주문방법
	private int o_milage;	//주문했을때 발생한 마일리지
	private int o_totalprice;	//결제한금액
	private int o_count;	//주문한 상품개수 (예, A1+B1+C1=3개 / A4+B2+C1=3개)
	
	private String o_zipcode;	//배송지 우편번호
	private String o_address;	//배송지 주소
	private String o_phone;		//배송받을사람 폰번호
	private String o_name;		//배송받을사람이름
	
	private int m_number;		//주문한 고객번호
	
	private int u_milage;		//이번주문에서 사용한 마일리지
}
