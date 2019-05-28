package com.itbook.vo.Meeting;
/**
 * 모임댓글번호
 * 내용
 * 작성일자
 * 모임게시글번호
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class MetCommentVO {
	
	private String metComtNum;
	private String metComtContent;
	private Date metComtDate;
	private String metBrdNum;
	private String memNum;
	private String metComtParent;
	public String getMetComtNum() {
		return metComtNum;
	}
	public void setMetComtNum(String metComtNum) {
		this.metComtNum = metComtNum;
	}
	public String getMetComtContent() {
		return metComtContent;
	}
	public void setMetComtContent(String metComtContent) {
		this.metComtContent = metComtContent;
	}
	public Date getMetComtDate() {
		return metComtDate;
	}
	public void setMetComtDate(Date metComtDate) {
		this.metComtDate = metComtDate;
	}
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMetComtParent() {
		return metComtParent;
	}
	public void setMetComtParent(String metComtParent) {
		this.metComtParent = metComtParent;
	}
	@Override
	public String toString() {
		return "MetCommentVO [metComtNum=" + metComtNum + ", metComtContent=" + metComtContent + ", metComtDate="
				+ metComtDate + ", metBrdNum=" + metBrdNum + ", memNum=" + memNum + ", metComtParent=" + metComtParent
				+ "]";
	}
	
	
	
	
}
