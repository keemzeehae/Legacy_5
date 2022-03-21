package com.keem.s1.board.notice.noticeReply;

import java.sql.Date;

public class NoticeReplyDTO {

	
	private Long replynum;
	private Long num;
	private String writer;
	private String contents;
	private Date regDate;
	
	public Long getReplynum() {
		return replynum;
	}
	public void setReplynum(Long replynum) {
		this.replynum = replynum;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
