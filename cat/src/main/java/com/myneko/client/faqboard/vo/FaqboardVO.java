package com.myneko.client.faqboard.vo;

import java.util.Date;

import com.myneko.client.common.vo.CommonVO;

import lombok.Data;

@Data
public class FaqboardVO extends CommonVO {
private int f_number;//글번호
private String f_title;//글제목
private String f_content;//내용
private String f_image;//이미지
private Date f_date;//등록일
private int a_number;//관리자 번호


}