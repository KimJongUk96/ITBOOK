package com.itbook.vo;

import java.sql.Date;

/**
 * 모임가입일
 * 회원번호
 * 모임번호
 * @author 종욱
 *
 */
public class MemListVO {
	
	private Date joinDate;
	private int memNum;
	private int metNum;
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getMetNum() {
		return metNum;
	}
	public void setMetNum(int metNum) {
		this.metNum = metNum;
	}
	@Override
	public String toString() {
		return "MemListVO [joinDate=" + joinDate + ", memNum=" + memNum + ", metNum=" + metNum + "]";
	}
	
	
}
