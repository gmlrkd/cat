package com.myneko.client.common.page;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private int page = 1;
	private int total = 1;
	private int list_size = 5;
	private int page_size = 5;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(getPaging());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setList_size(int list_size) {
		this.list_size = list_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}
	
	public String getPaging() {
		String ret = "";
		if(page<1) page=1;
		if(total<1) return "";
		
		int currentFirst = ((page-1)/page_size) * page_size + 1;
		int currentLast = ((page-1)/page_size) * page_size + page_size;
		int nextFirst = (((page-1)/page_size)+1) * page_size + 1;
		int prevFirst = (((page-1)/page_size)-1) * page_size + 1;
		int lastPage = (((page-1)/page_size)-1) * page_size + 1;
		lastPage = total/list_size;
		
		if(total%list_size != 0) lastPage = lastPage + 1;
		currentLast = (currentLast>lastPage)?lastPage:currentLast;
		
		ret += "<div class='paginate'>";
		
		if (page>1) {
			ret += " <a href=\"javascript:goPage('1')\"><span><strong>&lt;&lt;</strong></span></a> ";
		} else {
			ret += " <span><strong>&lt;&lt;</strong></span> ";
		}
		if (prevFirst > 0) {
			ret += " <a href=\"javascript:goPage('"+prevFirst+"');\"><span><strong>&lt;</strong></span></a> ";
		} else {
			ret += " <span><strong>&lt;</strong></span> ";
		}
		
		for (int j=currentFirst; j<currentFirst+page_size && j<=lastPage; j++) {
			if (j <= currentLast ) {
				if (j == page ) {
					ret += " <a href='#' class='on textAn'>"+j+"</a> ";
				} else {
					ret += " <a href=\"javascript:goPage('"+j+"');\"class='textAn'>"+j+"</a> ";
				}
			}
		}
		
		if (nextFirst <= lastPage ) {
			ret += " <a href=\"javascript:goPage('"+nextFirst+"')\"><span><strong>&gt;</strong></span></a> ";
		} else {
			ret += " <span><strong>&gt;</strong></span> ";
		}
		if ( page<lastPage ) {
			ret += " <a href=\"javascript:goPage('"+lastPage+"')\"><span><strong>&gt;&gt;</strong></span></a> ";
		} else {
			ret += " <span><strong>&gt;&gt;</strong></span> ";
		}
		ret += " </div> ";
		
		return ret;
	}

}


















