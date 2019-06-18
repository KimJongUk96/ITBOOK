package com.itbook.vo;

import java.sql.Timestamp;

/**
 * 紐⑥��媛�����
 * ����踰���
 * 紐⑥��踰���
 * ���대�� 
 * �대�
 * �뱀��
 * @author 醫���
 *
 */
public class MemListVO {
	
	private String memNum;
	private String metNum;
	private Timestamp joinDate;
	private String memName;
	private String memId;
	private String approval;
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
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
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
		return "MemListVO [memNum=" + memNum + ", metNum=" + metNum + ", joinDate=" + joinDate + ", memName=" + memName
				+ ", memId=" + memId + ", approval=" + approval + "]";
	}
	
}
