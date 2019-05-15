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
	private Date metCometDate;
	private String metPostNum;
	private String memNum;
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
	public Date getMetCometDate() {
		return metCometDate;
	}
	public void setMetCometDate(Date metCometDate) {
		this.metCometDate = metCometDate;
	}
	public String getMetPostNum() {
		return metPostNum;
	}
	public void setMetPostNum(String metPostNum) {
		this.metPostNum = metPostNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "MetCommentVO [metComtNum=" + metComtNum + ", metComtContent=" + metComtContent + ", metCometDate="
				+ metCometDate + ", metPostNum=" + metPostNum + ", memNum=" + memNum + "]";
	}
	
	
}
