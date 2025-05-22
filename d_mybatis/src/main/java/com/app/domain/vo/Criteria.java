package com.app.domain.vo;

public class Criteria {
	private int page;
	private int pageCount;
	private int startPage;
	private int endPage;
	private int rowCount;
	private int startRow;
	private int endRow;
	private int realEnd;
	private boolean prev, next;
	
	public Criteria(int page, int total) {
		this.rowCount = 10;		// 한페이지당 표시되는 행 개수, 데이터 갯수
		this.pageCount = 10;	// 밑에 게시글 페이지 블록 개수이다.
		
		// 페이지가 1보다 작으면 1로 설정,
		this.page = page == 0 ? 1 : page;
		
		// 전체 페이지가 속한 블록의 마지막 페이지 계산.
		// round: 반올림 ceiling: 올림 floor: 내림
		this.endPage = (int)(Math.ceil(this.page / (double)pageCount)) * pageCount;
		
		// 현재 페이지가 속한 블록의 시작 페이지 계산식
		this.startPage = endPage - (pageCount - 1);
		
		// 전체 데이터 개수를 기반으로 실제 마지막 페이지 계산
		this.realEnd = (int)Math.ceil(total / (double)rowCount);
		
		// 끝 페이지가 realend 보다 크면 (페이지 끝번호를 조정)
		this.endPage = this.endPage > realEnd ? realEnd : endPage;
		
		// 마지막 페이지가 0이면 최소 페이지를 1로 설정 (페이지 번호는 최소 1부터 시작해야함)
		this.endPage = this.endPage == 0 ? 1 : this.endPage;
		
		// 현재페이지에서 보여줄 마지막 행 갯수 계산 (rowcount는 페이지당 행 항목개수)
		this.endRow = rowCount * this.page;
		
		// 현재 페이지 에서 보여줄 첫 번째 행번호 계산 (endRow에서 rowCount만큼 빼줌)
		this.startRow = endRow - (rowCount - 1);
		
		// 이전 페이지 버튼 활성화 여부( startPage가 1보다 크면 true)
		this.prev = startPage > 1;
		
		// 다음 페이지 버튼 활성화 여부 (realend가 endPage와 다르면 true)
		this.next = realEnd != endPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", rowCount=" + rowCount + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
}
