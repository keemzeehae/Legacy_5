package com.keem.s1.util;

public class Pager {

	//primitive 타입이 아니라 Reference 타입으로 불러옴 (null)이 넘어올수 있기 때문에
	//페이지당 보여줄 row갯수
	private Long perPage;
	
	//페이지번호
	private Long page;
	
	//시작번호
	private Long startRow;
	
	//끝번호
	private Long lastRow;

	//--------검색에서 사용하는 변수------------
	private String search;
	
	private String kind;
	
	
	//-----------------JSP 사용 변수-----------------
	
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
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=this.getPage()*this.getPerPage();
		
	}
	//row가 몇개야 
	public void makenum(Long totalCount) {
		//1. 전체 row의 갯수를 구해옴
		
		
//		Long totalCount=208L; 처음에는 값을 직접 입력해줬다
		
		//2. 전체 page의 갯수 구하기
		Long totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		//3. 블럭당 갯수 블럭의 의미는 아래 보여지는 번호 (한페이지당 보여지는 번호)
		Long perBlock=10L;
		
		//4. 전체 블럭의 갯수 
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		//5. page번호로 현재 몇번째 Block인지 계산
		//1번: 1-10
		//2번:11-20
		//page block
		//1    1
		//2    1
		//...
		//9    1
		//10   1
		//11   2
		//20   2
		//21   3
		//curBlock -> 현재블럭번호
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		
		//6. curBlock로 starNum, lastNum 구하기
		//curBlock이 몇번인지에 따라 startNumber, lastNumber이 얼마인지 알아야함
		
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
		
		
		//7. 이전, 다음블럭의 유무를
		
		this.pre=false;
		if(curBlock>1) {
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock>curBlock) {
			this.next=true;
		}
		
		//현재블럭이 마지막 블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
	}
	
	
	
	
	public Long getPerPage() {
		//null값이 오거나 0이 오거나 음수가 올때 셋팅
		if(this.perPage==null||this.perPage<1) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
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
		//this.search="%"+this.search+"%";
		
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
