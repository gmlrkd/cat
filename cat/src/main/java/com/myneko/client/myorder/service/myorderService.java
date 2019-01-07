package com.myneko.client.myorder.service;

import java.util.List;

import com.myneko.client.md.vo.MdVO;
import com.myneko.client.member.vo.MemberVO;
import com.myneko.client.myorder.vo.myorderVO;

public interface myorderService {

	public List<myorderVO> myorderList(myorderVO mvo);

	 public myorderVO myorderDetail(myorderVO mvo); 

	public List<MdVO> findProduct(int o_number); // 주문번호 안에 주문상품찾기(상품명, 썸네일 등등)

	public MemberVO findMember(int o_number); // 주문자 정보

	public myorderVO findOrder(int o_number); // 주문서 정보

	public int myorderDelete(int o_number);
	
	public int myorderListCnt(myorderVO mvo);

	public int myorderAddressModify(myorderVO mvo);
}
