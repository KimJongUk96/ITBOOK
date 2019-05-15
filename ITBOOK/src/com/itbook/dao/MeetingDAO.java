package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.Meeting.MeetingVO;
import util.DBManager;

/**
 * @author 정원
 */
public class MeetingDAO {

	private static MeetingDAO instance;
	
	public static MeetingDAO getInstance() {
		if (instance == null) {
			instance = new MeetingDAO();
		}
		return instance;
	}
	
	// 독서모임 조회
	/*private int metNum;
	private String metName;
	private String metIntro;
	private String represent;
	private Date metDate;
	private int headCount;
	*/
	public List<MeetingVO> selectAllMeetings() {
		
		String sql = "SELECT metNum"
				+ "         ,metName"
				+ "         ,metIntro"
				+ "         ,represent"
				+ "         ,metDate"
				+ "         ,headCount"
				+ "	  FROM itbook.meeting";
		
		List<MeetingVO> list = new ArrayList<MeetingVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				MeetingVO mVo = new MeetingVO();
				
				mVo.setMetNum(rs.getInt("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setHeadCount(rs.getInt("headCount"));
				
				//MeetingVO를 담는 list에 mVo를 추가
				list.add(mVo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//리턴값이 없는 printStackTrace() 메소드를 호출하면 메소드가 내부적으로 가장 자세한 예외 정보를 화면에 출력한다.
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//독서모임 생성
	public List<MeetingVO> insertMeeting(MeetingVO mVo) {
		
		String sql = "INSERT INTO Meeting ("
				+ "    metName"
				+ "   ,metIntro"
				+ "   ,represent"
				+ "   ,metDate"
				+ "   ,headCount)"
				+ "values (?"
				+ "       , ?"
				+ "       , ?"
				+ "       , ?"
				+ "       , ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetIntro());
			pstmt.setString(3, mVo.getRepresent());
			pstmt.setDate(4, mVo.getMetDate());
			pstmt.setInt(5, mVo.getHeadCount());
			
			//update쿼리 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	
	/*
	 * 독서모임 게시판 자동생성
	 * 모임생성할 때 자동으로 게시판도 만들어짐
	 */
	
}
