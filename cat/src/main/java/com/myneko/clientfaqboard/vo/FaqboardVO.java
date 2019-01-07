package com.myneko.clientfaqboard.vo;

import java.util.Date;

import com.myneko.client.common.util.Paging;

public class FaqboardVO extends Paging {
private int f_number;//글번호
private String f_title;//글제목
private String f_content;//내용
private String f_image;//이미지
private Date f_date;//등록일
private int a_number;//관리자 번호
//조건 검색시 사용할 필드
private String search;
private String keyword;
//제목 클릭시 정렬을 위한 필드
private String order_by;
private String order_sc;
//페이징 처리
private String page;// 페이지 번호
private String pageSize;//페이지에 보여주는 줄수
private String start_row;//시작레코드 번호
private String end_row;//종료레코드 번호
public String getOrder_by() {
	return order_by;
}
public void setOrder_by(String order_by) {
	this.order_by = order_by;
}
public String getOrder_sc() {
	return order_sc;
}
public void setOrder_sc(String order_sc) {
	this.order_sc = order_sc;
}
public String getStart_row() {
	return start_row;
}
public void setStart_row(String start_row) {
	this.start_row = start_row;
}
public String getEnd_row() {
	return end_row;
}
public void setEnd_row(String end_row) {
	this.end_row = end_row;
}
public String getSearch() {
	return search;
}
public void setSearch(String search) {
	this.search = search;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public String getPage() {
	return page;
}
public void setPage(String page) {
	this.page = page;
}
public String getPageSize() {
	return pageSize;
}
public void setPageSize(String pageSize) {
	this.pageSize = pageSize;
}
public int getF_number() {
	return f_number;
}
public void setF_number(int f_number) {
	this.f_number = f_number;
}
public String getF_title() {
	return f_title;
}
public void setF_title(String f_title) {
	this.f_title = f_title;
}
public String getF_content() {
	return f_content;
}
public void setF_content(String f_content) {
	this.f_content = f_content;
}
public String getF_image() {
	return f_image;
}
public void setF_image(String f_image) {
	this.f_image = f_image;
}
public Date getF_date() {
	return f_date;
}
public void setF_date(Date f_date) {
	this.f_date = f_date;
}
public int getA_number() {
	return a_number;
}
public void setA_number(int a_number) {
	this.a_number = a_number;
}
}
