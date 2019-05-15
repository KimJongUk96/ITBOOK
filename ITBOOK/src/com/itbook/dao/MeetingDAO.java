package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.Meeting.MeetingVO;
import util.DBManager;

/**
 * @author �젙�썝
 */
public class MeetingDAO {

	private static MeetingDAO instance;
	
	public static MeetingDAO getInstance() {
		if (instance == null) {
			instance = new MeetingDAO();
		}
		return instance;
	} 
	
	// �룆�꽌紐⑥엫議고쉶 
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
				
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setHeadCount(rs.getInt("headCount"));
				
				//MeetingVO瑜� �떞�뒗 list�뿉 mVo瑜� 異붽�
				list.add(mVo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//由ы꽩媛믪씠 �뾾�뒗 printStackTrace() 硫붿냼�뱶瑜� �샇異쒗븯硫� 硫붿냼�뱶媛� �궡遺��쟻�쑝濡� 媛��옣 �옄�꽭�븳 �삁�쇅 �젙蹂대�� �솕硫댁뿉 異쒕젰�븳�떎.
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//�룆�꽌紐⑥엫 �깮�꽦
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
			
			//update荑쇰━ �떎�뻾
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
	 * �룆�꽌紐⑥엫 寃뚯떆�뙋 �옄�룞�깮�꽦
	 * 紐⑥엫�깮�꽦�븷 �븣 �옄�룞�쑝濡� 寃뚯떆�뙋�룄 留뚮뱾�뼱吏�
	 */
	
}
