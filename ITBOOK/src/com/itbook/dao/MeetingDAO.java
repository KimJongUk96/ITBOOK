package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.MemberVO;
import com.itbook.vo.Paging;
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
	
	// 독서모임 VO 속성
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
				/* + "         ,metGreeting" */
				+ "         ,metIntro"
				+ "         ,represent"
				/* + "         ,keword" */
				+ "         ,metDate"
				+ "         ,headCount"
				+ "	  FROM itbook.meeting"
				+ "	  WHERE approval = 'T'"
				+ "   ORDER BY metDate DESC";
		
		List<MeetingVO> list = new ArrayList<MeetingVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				MeetingVO mVo = new MeetingVO();
				
				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				/* mVo.setMetGreeting(rs.getString("metGreeting")); */
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setRepresent(rs.getString("represent"));
				/* mVo.setKeyword(rs.getString("keyword")); */
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setHeadCount(rs.getInt("headCount"));
				
				//MeetingVO에 저장된 데이터 리스트에 추가
				list.add(mVo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//독서모임 신청하기 : 독서모임명, 독서모임소개, 대표자명 입력!
	public List<MeetingVO> insertMeeting(MeetingVO mVo) {
		
		String sql = "INSERT INTO itbook.meeting ("
				+ "    metName"
				+ "   ,metGreeting"
				+ "   ,metIntro"
				+ "   ,represent"
				+ "	  ,metPlace"
				+ "	  ,keyword)"
				+ "values (?"
				+ "       , ?"
				+ "       , ?"
				+ "       , ?"
				+ "		  , ?"
				+ "       , ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetGreeting());
			pstmt.setString(3, mVo.getMetIntro());
			pstmt.setString(4, mVo.getRepresent());
			pstmt.setString(5, mVo.getMetPlace());
			pstmt.setString(6, mVo.getKeyword());
			
			//sql문 update 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	//독서모임 홈으로 연결
	//독서모임 메인 홈 상세내용 보기 : 글번호로 찾아온다. 실패하면 return null
	public MeetingVO selectOneMeetingByNum(String metNum){
		
		String sql = "SELECT metNum"
				+ "			, metName"
				+ "			, metIntro"
				+ "			, metGreeting"
				+ "			, represent"
				+ "			, metPlace"	
				+ "			, keyword"
				+ "			, metDate"
				+ "			, headCount"
				+ " FROM itbook.meeting"
				+ " WHERE metNum = ?";
		
		MeetingVO mVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			
			mVo = new MeetingVO();
			
			mVo.setMetNum(rs.getString("metNum"));
			mVo.setMetName(rs.getString("metName"));
			mVo.setMetIntro(rs.getString("metIntro"));
			mVo.setMetGreeting(rs.getString("metGreeting"));
			mVo.setRepresent(rs.getString("represent"));
			mVo.setMetPlace(rs.getString("metPlace"));
			mVo.setKeyword(rs.getString("keyword"));
			mVo.setMetDate(rs.getDate("metDate"));
			mVo.setHeadCount(rs.getInt("headCount"));
	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}
	
	
	//독서모임 수정
	public void updateMeeting(String metNum) {
		
		String sql = "UPDATE itbook.meeting"
				+ " SET metIntro= ?"
				+ ",	metGreeting= ?"
				+ ",	metPlace=?"
				+ ",	keyword=?"
				+ " WHERE metNum = ?";
	}
	
	// 모임신청 리스트(관리자 화면)
	public ArrayList<MeetingVO> meetingList(Paging paging) {
		String sql = "SELECT*FROM ITBOOK.MEETING order by metNum desc limit ?, 10";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MeetingVO> list = new ArrayList<MeetingVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			MeetingVO mVo = new MeetingVO();
			mVo.setMetNum(rs.getString("metNum"));
			mVo.setMetName(rs.getString("metName"));
			mVo.setMetIntro(rs.getString("metIntro"));
			mVo.setMetPlace(rs.getString("metPlace"));
			mVo.setMetDate(rs.getDate("metDate"));
			mVo.setRepresent(rs.getString("represent"));
		    mVo.setMetGreeting(rs.getString("metGreeting"));
		    mVo.setKeyword(rs.getString("keyword"));
			mVo.setHeadCount(rs.getInt("headCount"));
			mVo.setApproval(rs.getString("approval"));
			
			list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	 	//총게시글 수 보기
		public Paging meetingRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM itbook.meeting";
		      
		         Connection conn = null;
		         PreparedStatement stmt = null;
		         ResultSet rs = null;
		         
		         try
		         {
		            conn = DBManager.getConnection();
		            stmt = conn.prepareStatement(sql);
		            
		            rs = stmt.executeQuery();
		            
		            while (rs.next())
		            {
		               cnt = rs.getInt("CNT");
		               paging.setNumOfRow(cnt);;
		            }
		            
		         }
		         catch (Exception e)
		         {
		            e.printStackTrace();
		         }finally {
		 			DBManager.close(conn, stmt);
		 		}
		         return paging;
		   }
		
		//독서모임 승인
		public void acceptMeeting(MeetingVO mVO) {
			String sql = "Update itbook.meeting set metDate = sysdate(), approval = 'T'  where metNum = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mVO.getMetNum());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//독서모임 거절 및 삭제
		public void deleteMeeting(MeetingVO mVO) {
			String sql = "Delete From itbook.meeting Where metNum = ?";
			
			Connection conn =  null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mVO.getMetNum());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
}