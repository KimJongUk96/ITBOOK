package com.itbook.vo.Meeting;
/**
 * @author 정원
 * 독서모임번호
 * 독서모임명
 * 대표자명
 * 키워드
 * 모임개설일
 * 모임인원수
 *
 */

import java.sql.Date;

public class MeetingVO {
	private String metNum;
	private String metName;
	private String metIntro;
	private String represent;
	private String keyword;
	private Date metDate;
	private int headCount;
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	public String getMetName() {
		return metName;
	}
	public void setMetName(String metName) {
		this.metName = metName;
	}
	public String getMetIntro() {
		return metIntro;
	}
	public void setMetIntro(String metIntro) {
		this.metIntro = metIntro;
	}
	public String getRepresent() {
		return represent;
	}
	public void setRepresent(String represent) {
		this.represent = represent;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Date getMetDate() {
		return metDate;
	}
	public void setMetDate(Date metDate) {
		this.metDate = metDate;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	
	@Override
	public String toString() {
		return "MeetingVO [metNum=" + metNum + ", metName=" + metName + ", metIntro=" + metIntro + ", represent="
				+ represent + ", keyword=" + keyword + ", metDate=" + metDate + ", headCount=" + headCount + "]";
	}
	
}
