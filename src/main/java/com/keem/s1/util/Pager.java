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
	
	//---------------JSP사용변수----------
	
	private Long startNum;
	private Long lastNum;
	
	
	private boolean pre;
	private boolean next;
	
	

	
	public Long getStartNum() {
		return startNum;
	}



	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}



	public Long getLastNum() {
		return lastNum;
	}



	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}



	public void makeRow() {
		this.startRow=(this.getPageNum()-1)*this.getLine()+1;
		this.lastRow=this.getPageNum()*this.getLine();
	}
	
	public void makeNum(Long totalCount) {
		Long totalPage=totalCount/this.getLine();
		if(totalCount%this.getLine()!=0) {
			totalPage++;
			
		}
		Long perBlock=10L;
		
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		Long curBlock=this.getPageNum()/perBlock;
		if(this.getPageNum()%perBlock!=0) {
			curBlock++;
		}
		//-----여기까지 했음 curBlock으로 startNum, lastNum 구하기 부터 해야함
	}
	
	public Long getLine() {
		//null이 오거나 0이 오거나 음수가 올때 셋팅
		if(this.line==null||this.line<1) {
			this.line=10L;
		}
		
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
	}

	public Long getPageNum() {
		if(this.pageNum==null||this.pageNum<1) {
			this.pageNum=1L;
		}
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
