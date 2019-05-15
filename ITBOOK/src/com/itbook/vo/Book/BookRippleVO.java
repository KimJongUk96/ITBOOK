package com.itbook.vo.Book;
/**이달의책 답글테이블
 * 이달의책답글번호
 * 내용
 * 작성일자
 * 이달의책 댓글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class BookRippleVO {

	private String bookRipNum;
	private String bookRipContent;
	private Date bookRipDate;
	private String bookComtNum;
	private String memNum;
	public String getBookRipNum() {
		return bookRipNum;
	}
	public void setBookRipNum(String bookRipNum) {
		this.bookRipNum = bookRipNum;
	}
	public String getBookRipContent() {
		return bookRipContent;
	}
	public void setBookRipContent(String bookRipContent) {
		this.bookRipContent = bookRipContent;
	}
	public Date getBookRipDate() {
		return bookRipDate;
	}
	public void setBookRipDate(Date bookRipDate) {
		this.bookRipDate = bookRipDate;
	}
	public String getBookComtNum() {
		return bookComtNum;
	}
	public void setBookComtNum(String bookComtNum) {
		this.bookComtNum = bookComtNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "BookRipple [bookRipNum=" + bookRipNum + ", bookRipContent=" + bookRipContent + ", bookRipDate="
				+ bookRipDate + ", bookComtNum=" + bookComtNum + ", memNum=" + memNum + "]";
	}
	
	
}
