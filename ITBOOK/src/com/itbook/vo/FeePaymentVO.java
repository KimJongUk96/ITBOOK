package com.itbook.vo;
/**
 * 회비납부내용
 * 날짜
 * 회원번호
 * @author 종욱
 *
 */

public class FeePaymentVO{
	private String payNum; //후원번호
	private String payName; //후원이름
	private String payEmail; //후원이메일
	private String payMobileNumber; //후원자 전화번호
	private String payZipcode; //우편번호
	private String payAttach; //소속
	private String payPosition; //직급
	private String payMessage; //메세지
	private String payBank; //은행
	private String payFee; //후원금액
	private String paySponsor; //후원방식
	private String payBankNum; //계좌번호
	private String bankName; //예금주
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public String getPayEmail() {
		return payEmail;
	}
	public void setPayEmail(String payEmail) {
		this.payEmail = payEmail;
	}
	public String getPayMobileNumber() {
		return payMobileNumber;
	}
	public void setPayMobileNumber(String payMobileNumber) {
		this.payMobileNumber = payMobileNumber;
	}
	public String getPayZipcode() {
		return payZipcode;
	}
	public void setPayZipcode(String payZipcode) {
		this.payZipcode = payZipcode;
	}
	public String getPayAttach() {
		return payAttach;
	}
	public void setPayAttach(String payAttach) {
		this.payAttach = payAttach;
	}
	public String getPayPosition() {
		return payPosition;
	}
	public void setPayPosition(String payPosition) {
		this.payPosition = payPosition;
	}
	public String getPayMessage() {
		return payMessage;
	}
	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}
	public String getPayBank() {
		return payBank;
	}
	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}
	public String getPayFee() {
		return payFee;
	}
	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}
	public String getPaySponsor() {
		return paySponsor;
	}
	public void setPaySponsor(String paySponsor) {
		this.paySponsor = paySponsor;
	}
	public String getPayBankNum() {
		return payBankNum;
	}
	public void setPayBankNum(String payBankNum) {
		this.payBankNum = payBankNum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "FeePaymentVO [payNum=" + payNum + ", payName=" + payName + ", payEmail=" + payEmail
				+ ", payMobileNumber=" + payMobileNumber + ", payZipcode=" + payZipcode + ", payAttach=" + payAttach
				+ ", payPosition=" + payPosition + ", payMessage=" + payMessage + ", payBank=" + payBank + ", payFee="
				+ payFee + ", paySponsor=" + paySponsor + ", payBankNum=" + payBankNum + ", bankName=" + bankName + "]";
	}
	


	
}

