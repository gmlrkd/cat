package com.myneko.client.cart.vo;

import lombok.Data;

@Data
public class PartiorderVO {
	private int po_number;	//프리마리키
	private int o_number;	//주문번호
	private int p_number;	//상품번호
	private int po_amount;	//주문한 갯수
	private int po_price;	//상품가격
}
