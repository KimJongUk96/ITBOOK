package com.itbook.vo.Meeting;
/**
 * @author ����
 * ����Ȱ������ ���̺�
 * �������Ϲ�ȣ
 * �������ϸ�
 * �������ϵ����
 * ���ӰԽ��ǹ�ȣ
 */
import java.sql.Date;

public class MeetingPicture {
	private String pictureNum;
	private String pictureName;
	private Date pictureDate;
	private String metNum;
	public String getPictureNum() {
		return pictureNum;
	}
	public void setPictureNum(String pictureNum) {
		this.pictureNum = pictureNum;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public Date getPictureDate() {
		return pictureDate;
	}
	public void setPictureDate(Date pictureDate) {
		this.pictureDate = pictureDate;
	}
	public String getMetNum() {
		return metNum;
	}
	public void setMetNum(String metNum) {
		this.metNum = metNum;
	}
	
	@Override
	public String toString() {
		return "MeetingPicture [pictureNum=" + pictureNum + ", pictureName=" + pictureName + ", pictureDate="
				+ pictureDate + ", metNum=" + metNum + "]";
	}
	
}
