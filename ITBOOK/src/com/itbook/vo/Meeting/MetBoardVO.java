package com.itbook.vo.Meeting;

import java.util.Date;

/**
 * 모임게시판번호
 * 게시판명
 * 내용
 * 모임번호
 * @author 종욱
 *
 */
public class MetBoardVO {
	
	private String metBrdNum;
	private String metBrdName;
	private String metBrdContent;
	private String metBrdFile;
	private int metBrdCount;
	private Date regDate;
	private String metNum;
	private String metBrdCategory;
	private String memName;
	private String memNum;
	
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMetBrdCategory() {
		return metBrdCategory;
	}
	public void setMetBrdCategory(String metBrdCategory) {
		this.metBrdCategory = metBrdCategory;
	}
	public String getMetBrdNum() {
		return metBrdNum;
	}
	public void setMetBrdNum(String metBrdNum) {
		this.metBrdNum = metBrdNum;
	}
	public String getMetBrdName() {
		return metBrdName;
	}
	public void setMetBrdName(String metBrdName) {
		this.metBrdName = metBrdName;
	}
	public String getMetBrdContent() {
		return metBrdContent;
	}
	public void setMetBrdContent(String metBrdContent) {
		this.metBrdContent = metBrdContent;
	}
	public String getMetBrdFile() {
		return metBrdFile;
	}
	public void setMetBrdFile(String metBrdFile) {
		this.metBrdFile = metBrdFile;
	}
	public int getMetBrdCount() {
		return metBrdCount;
	}
	public void setMetBrdCount(int metBrdCount) {
		this.metBrdCount = metBrdCount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	@Override
	public String toString() {
		return "MetBoardVO [metBrdNum=" + metBrdNum + ", metBrdName=" + metBrdName + ", metBrdContent=" + metBrdContent
				+ ", metBrdFile=" + metBrdFile + ", metBrdCount=" + metBrdCount + ", regDate=" + regDate
				+ ", metNum=" + metNum + ", metBrdCategory=" + metBrdCategory + ", memName=" + memName + ", memNum="
				+ memNum + "]";
	}

	
	
	
	
	
	
	
	
}
