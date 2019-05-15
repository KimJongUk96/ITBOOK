package com.itbook.vo.Book;
/**이달의책 댓글 테이블
 * 이달의책 댓글번호
 * 내용
 * 작성일자
 * 이달의책게시글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class BookCommentVO {
	
	private String bookComtNum;
	private String bookComtContent;
	private Date bookComtDate;
	private String bookBrdNum;
	private String memNum;
	public String getBookComtNum() {
		return bookComtNum;
	}
	public void setBookComtNum(String bookComtNum) {
		this.bookComtNum = bookComtNum;
	}
	public String getBookComtContent() {
		return bookComtContent;
	}
	public void setBookComtContent(String bookComtContent) {
		this.bookComtContent = bookComtContent;
	}
	public Date getBookComtDate() {
		return bookComtDate;
	}
	public void setBookComtDate(Date bookComtDate) {
		this.bookComtDate = bookComtDate;
	}
	public String getBookBrdNum() {
		return bookBrdNum;
	}
	public void setBookBrdNum(String bookBrdNum) {
		this.bookBrdNum = bookBrdNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "BookComment [bookComtNum=" + bookComtNum + ", bookComtContent=" + bookComtContent + ", bookComtDate="
				+ bookComtDate + ", bookBrdNum=" + bookBrdNum + ", memNum=" + memNum + "]";
	}
	
	
	
}
