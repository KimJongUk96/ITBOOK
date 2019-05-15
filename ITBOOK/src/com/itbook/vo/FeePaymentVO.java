package com.itbook.vo;
/**
 * 회비납부내용
 * 날짜
 * 회원번호
 * @author 종욱
 *
 */

import java.sql.Date;

public class FeePaymentVO {

	private String payDetail;
	private Date payDate;
	private int memNum;
	public String getPayDetail() {
		return payDetail;
	}
	public void setPayDetail(String payDetail) {
		this.payDetail = payDetail;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	@Override
	public String toString() {
		return "FeePayment [payDetail=" + payDetail + ", payDate=" + payDate + ", memNum=" + memNum + "]";
	}
	
	
}
