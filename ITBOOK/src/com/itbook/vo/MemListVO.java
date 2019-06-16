package com.itbook.vo;

import java.sql.Timestamp;

/**
 * 모임가입일
 * 회원번호
 * 모임번호
 * 아이디 
 * 이름
 * 승인
 * @author 종욱
 *
 */
public class MemListVO {
	
	private Timestamp joinDate;
	private String memNum;
	private String metNum;
	private String memName;
	private String memId;
	private String approval;
	
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	@Override
	public String toString() {
		return "MemListVO [joinDate=" + joinDate + ", memNum=" + memNum + ", metNum=" + metNum + ", memName=" + memName
				+ ", memId=" + memId + ", approval=" + approval + "]";
	}
	


	
	
}
