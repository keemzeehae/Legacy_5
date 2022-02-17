package com.keem.s1.notice;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NoticeDTO {
	
//	SimpleDateFormat format1 = new SimpleDateFormat("yy/mm/dd");
//	Calendar date = Calendar.getInstance();
//	String sysdate = format1.format(date.getTime());
	
	private Long num;
	private String title;
	private String contents;
	private String writer;
	private Calendar regDate;
	private Long hit;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Calendar getRegDate() {
		return regDate;
	}
	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	
	
	
	
}
