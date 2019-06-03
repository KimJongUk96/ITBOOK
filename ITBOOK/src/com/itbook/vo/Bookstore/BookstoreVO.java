package com.itbook.vo.Bookstore;

public class BookstoreVO {
	private String bookstoreNum;
	private String bookstoreTitle;
	private String bookstoreContent;
	private String bookstoreUrl;
	//memNum추가
	private String memNum;
	
	
	
	public String getMemNum() {
		return memNum;
	}



	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}



	public String getBookstoreNum() {
		return bookstoreNum;
	}



	public void setBookstoreNum(String bookstoreNum) {
		this.bookstoreNum = bookstoreNum;
	}



	public String getBookstoreTitle() {
		return bookstoreTitle;
	}



	public void setBookstoreTitle(String bookstoreTitle) {
		this.bookstoreTitle = bookstoreTitle;
	}



	public String getBookstoreContent() {
		return bookstoreContent;
	}



	public void setBookstoreContent(String bookstoreContent) {
		this.bookstoreContent = bookstoreContent;
	}



	public String getBookstoreUrl() {
		return bookstoreUrl;
	}



	public void setBookstoreUrl(String bookstoreUrl) {
		this.bookstoreUrl = bookstoreUrl;
	}



	@Override
	public String toString() {
		return "BookstoreVO [bookstoreNum=" + bookstoreNum + ", bookstoreTitle=" + bookstoreTitle
				+ ", bookstoreContent=" + bookstoreContent + ", bookstoreUrl=" + bookstoreUrl + ", memNum=" + memNum
				+ "]";
	}



	
	
	
}
