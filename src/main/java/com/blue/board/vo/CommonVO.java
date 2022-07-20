package com.blue.board.vo;

public class CommonVO {
	
	String pagination;
	String functionName;
	
	int currentPageNo;	// ������������ȣ
	int countPerPage;	// �� ȭ�� ��� �Խù� ��
	int countPerList;	// �� ȭ�� ��� ������ ��
	int totalCount;		// �� �Խù� ��
	int totalPageCount;	// �� ������ ��
	
	int startNo;
	int endNo;
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
	public String getPagination() {
		return pagination;
	}
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
	public int getCountPerList() {
		return countPerList;
	}
	public void setCountPerList(int countPerList) {
		this.countPerList = countPerList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
}
