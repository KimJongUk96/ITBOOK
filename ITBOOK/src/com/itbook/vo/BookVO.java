package com.itbook.vo;
/**책등록 테이블
 * 책번호
 * 책제목
 * 저자
 * 출판사
 * 출판일
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class BookVO {
	
	private String bookNum;
	private String bookTitle;
	private String writer;
	private String publisher;
	private Date publishDate;
	private String memNum;
	
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "Book [bookNum=" + bookNum + ", bookTitle=" + bookTitle + ", writer=" + writer + ", publisher="
				+ publisher + ", publishDate=" + publishDate + ", memNum=" + memNum + "]";
	}
	
	
}
