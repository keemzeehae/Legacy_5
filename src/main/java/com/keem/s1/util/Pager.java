package com.keem.s1.util;

public class Pager {
	
	//페이지당 보여줄 row갯수
	private Long line;
	
	//페이지번호
	private Long pageNum;
	
	//시작번호
	private Long startRow;
	
	//끝번호
	private Long lastRow;

	
	public void makeNum() {
		this.startRow=(this.getPageNum()-1)*this.getLine()+1;
	}
	
	public Long getLine() {
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
	}

	public Long getPageNum() {
		return pageNum;
	}

	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	
	
	

}
