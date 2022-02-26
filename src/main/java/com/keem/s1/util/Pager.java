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
	
	
	//--------------검색에서 사용하는 변수
	
	private String search;
	private String kind;
	
	
	
	//---------------JSP사용변수----------
	
	private Long startNum;
	private Long lastNum;
	
	
	private boolean pre;
	private boolean next;
	




	public void makeRow() {
		this.startRow=(this.getPageNum()-1)*this.getLine()+1;
		this.lastRow=this.getPageNum()*this.getLine();
	}
	
	public void makeNum(Long totalCount) {
		
		Long totalPage=totalCount/this.getLine();
		if(totalCount%this.getLine() != 0) {
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
		//-----여기까지 했음 curBlock으로 startNum, lastNum 구하기
		//curBlock이 몇번인지에 따라 startNum, lastNum 이 얼마인지 알아야함
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		//이전, 다음 블럭의 유무를
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock > curBlock) {
			this.next=true;
		}
		
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}
		
	}
	
	public Long getLine() {
		//null이 오거나 0이 오거나 음수가 올때 셋팅>>한줄도 없음 또는 누군가 음수값 넣을때
		if(this.line==null || this.line < 1) {
			this.line=10L; 
		}
		
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
	}
	
	public Long getPageNum() {
		//페이지 번호에 아무것도 넣어주지 않거나 음수일때 1번 페이지를 보여줘라
		if(this.pageNum==null || this.pageNum<1) {
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

	public boolean isPre() {
		return pre;
	}



	public void setPre(boolean pre) {
		this.pre = pre;
	}



	public boolean isNext() {
		return next;
	}



	public void setNext(boolean next) {
		this.next = next;
	}

	public String getSearch() {
		
		//검색어가 없으면 search=null
		if(this.search==null) {
			this.search="";
			
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
	

}
