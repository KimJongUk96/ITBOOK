package com.itbook.vo;

import java.sql.Timestamp;


/**속성
 * 회원테이블
 * 회원번호
 * 회원아이디
 * 회원비밀번호
 * 주민등록번호
 * 이름
 * 전화번호
 * 이메일
 * 권한
 * 가입일자
**/
public class MemberVO {
	
	private String memNum;
	private String memId;
	private String memPw;
	private String jumin;
	private String memName;
	private String adr;
	private String phone;
	private String email;
	private String authority;
	private Timestamp signDate;
	
	
	
	public String getMemNum() {
		return memNum;
	}



	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}



	public String getMemId() {
		return memId;
	}



	public void setMemId(String memId) {
		this.memId = memId;
	}



	public String getMemPw() {
		return memPw;
	}



	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}



	public String getJumin() {
		return jumin;
	}



	public void setJumin(String jumin) {
		this.jumin = jumin;
	}



	public String getMemName() {
		return memName;
	}



	public void setMemName(String memName) {
		this.memName = memName;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public Timestamp getSignDate() {
		return signDate;
	}



	public void setSignDate(Timestamp signDate) {
		this.signDate = signDate;
	}
	
	
	public String getAdr() {
		return adr;
	}



	public void setAdr(String adr) {
		this.adr = adr;
	}



	@Override
	public String toString() {
		return "MemberVO [memNum=" + memNum + ", memId=" + memId + ", memPw=" + memPw + ", jumin=" + jumin
				+ ", memName=" + memName + ", adr=" + adr + ", phone=" + phone + ", email=" + email + ", authority="
				+ authority + ", signDate=" + signDate + "]";
	}



	
	



	
	
}
