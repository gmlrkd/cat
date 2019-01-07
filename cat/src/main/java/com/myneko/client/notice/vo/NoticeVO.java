package com.myneko.client.notice.vo;


import com.myneko.client.common.vo.CommonVO;

import lombok.Data;

@Data
public class NoticeVO extends CommonVO {
private String n_title;
private String n_content;
private String n_image;
private String file;
private String n_date;
private int n_number;
}
