package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.MemListVO;
import com.itbook.vo.Paging;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;
import com.itbook.vo.main.MainDTO;

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

	// MeetingVO에서 값을 가져옴(DB등록된 모든 데이터 가져오기)
	/*
	 * private int metNum; private String metName; private String metIntro; private
	 * String represent; private Date metDate; private int headCount;
	 */
	public List<MeetingVO> selectAllMeetings() {

		String sql = "SELECT metNum"
				+ "         ,metName"
				+ "         ,metIntro"
				+ "         ,represent"
				+ "         ,metDate"
				+ "         ,(select count(*) from itbook.mem_list WHERE approval = 'T' and  metNum = itbook.meeting.metNum) as headCount"
				+ "			,location"
				+ "			,metPlace"
				+ "			,keyword"
				+ "         ,metImg"
				+ "     FROM itbook.meeting"
				+ "     WHERE approval = 'T'"
				+ "   ORDER BY metDate DESC";

		List<MeetingVO> list = new ArrayList<MeetingVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MeetingVO mVo = new MeetingVO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setHeadCount(rs.getInt("headCount"));
				mVo.setLocation(rs.getString("location"));
				mVo.setMetPlace(rs.getString("metPlace"));
				mVo.setKeyword(rs.getString("keyword"));
				mVo.setMetImg(rs.getString("metImg"));

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

	
	public List<MainDTO> selectMainMeetings() {

		String sql = "SELECT metNum"
				+ "         ,metName"
				+ "         ,metImg"
				+ "         ,metIntro"
				+ "         ,metPlace"
				+ "     FROM itbook.meeting"
				+ "     WHERE approval = 'T'"
				+ "   ORDER BY metDate DESC";

		List<MainDTO> list = new ArrayList<MainDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainDTO mVo = new MainDTO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetImg(rs.getString("metImg"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setMetPlace(rs.getString("metPlace"));
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
	
	
	// 독서모임 신청하기
	public boolean insertMeeting(MeetingVO mVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append("insert into itbook.meeting(metName,metGreeting,metIntro,represent,location,metPlace,keyword,metImg,memNum)");
			sql.append("values (?,?,?,?,?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetGreeting());
			pstmt.setString(3, mVo.getMetIntro());
			pstmt.setString(4, mVo.getRepresent());
			pstmt.setString(5, mVo.getLocation());
			pstmt.setString(6, mVo.getMetPlace());
			pstmt.setString(7, mVo.getKeyword());
			pstmt.setString(8, mVo.getMetImg());
			pstmt.setString(9, mVo.getMemNum());

			int flag = pstmt.executeUpdate();

			if (flag > 0) {
				result = true;
				conn.commit();
			}

		} catch (Exception e) {

			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt);
		return result;

	}

	// 독서모임 신청하면 관리자 화면에 페이징
	public Paging adminMeetingRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT"
					+"FROM itbook.meeting";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("CNT");
				paging.setNumOfRow(cnt);
				;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		return paging;
	}

	// 독서모임 홈에 5개의 공지사항 게시글 띄우기
	public List<MetBoardVO> selectFiveMetBoard(String metNum) {

		List<MetBoardVO> list = new ArrayList<MetBoardVO>();

		String sql = "Select m.metBrdNum, m.metBrdCategory, m.metBrdName, m.metNum, m.memNum, m.regDate, b.memName, b.memNum \n" + 
				"from met_board m, member b where m.memNum = b.memNum and m.metNum = ? order by m.regDate desc limit 5 ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MetBoardVO mbVo = new MetBoardVO();

				mbVo.setMetBrdNum(rs.getString("metBrdNum"));
				mbVo.setMetBrdName(rs.getString("metBrdName"));
				mbVo.setMetNum(rs.getString("metNum"));
				mbVo.setMetBrdCategory(rs.getString("metBrdCategory"));
				mbVo.setMemNum(rs.getString("memNum"));
				mbVo.setMemName(rs.getString("memName"));
				mbVo.setRegDate(rs.getDate("regDate"));
				
				list.add(mbVo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 독서모임 홈에 공지사항 게시판 모든 데이터 가져오기
	public ArrayList<MetBoardVO> selectAllMetBoard(String metNum, Paging paging) {

		ArrayList<MetBoardVO> list = new ArrayList<MetBoardVO>();

		String sql = "select m.metBrdNum"
					+"		,m.metBrdName"
					+"		,m.regDate"
					+"		,m.metBrdCategory"
					+"		,m.metBrdCount"
					+"		,m.metBrdContent"
					+"		,m.memNum"
					+"		,m.metNum"
					+"		,b.memName"
					+" from met_board m, member b"
					+" where m.memNum = b.memNum and m.metNum = ?"
					+" order by m.regDate desc limit ?, 10";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);
			pstmt.setInt(2, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MetBoardVO mbVo = new MetBoardVO();

				mbVo.setMetBrdNum(rs.getString("metBrdNum"));
				mbVo.setMetBrdName(rs.getString("metBrdName"));
				mbVo.setMetBrdContent(rs.getString("metBrdContent"));
				mbVo.setMetNum(rs.getString("metNum"));
				mbVo.setRegDate(rs.getDate("regDate"));
				mbVo.setMetBrdCategory(rs.getString("metBrdCategory"));
				mbVo.setMemNum(rs.getString("memNum"));
				mbVo.setMetBrdCount(rs.getInt("metBrdCount"));
				mbVo.setMemName(rs.getString("memName"));

				list.add(mbVo);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

	// 독서모임 홈에 선택한 모임 상세보기
	public MeetingVO selectOneMeetingByNum(String metNum) {

		String sql = "SELECT metNum"
				+ "			, metName"
				+ "			, metIntro"
				+ "			, metGreeting"
				+ "			, represent"
				+ "			, location"
				+ "			, metPlace"
				+ "			, keyword"
				+ "			, metDate"
				+ "			, metImg"
				+ "			, (select count(*) from itbook.mem_list WHERE approval = 'T' and  metNum = itbook.meeting.metNum) as headCount"
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

			if (rs.next()) {

				mVo = new MeetingVO();

				mVo.setMetNum(rs.getString("metNum"));
				mVo.setMetName(rs.getString("metName"));
				mVo.setMetIntro(rs.getString("metIntro"));
				mVo.setMetGreeting(rs.getString("metGreeting"));
				mVo.setRepresent(rs.getString("represent"));
				mVo.setLocation(rs.getString("location"));
				mVo.setMetPlace(rs.getString("metPlace"));
				mVo.setKeyword(rs.getString("keyword"));
				mVo.setMetDate(rs.getDate("metDate"));
				mVo.setMetImg(rs.getString("metImg"));
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

	// 독서모임 수정하기
	public boolean updateMeeting(MeetingVO mVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false); // ���� 而ㅻ��� false濡� ����.

			StringBuffer sql = new StringBuffer();
			sql.append("update itbook.meeting set");
			sql.append(" metName=?");
			sql.append(" ,metIntro=?");
			sql.append(" ,metGreeting=?");
			sql.append(" ,metPlace=?");
			sql.append(" ,keyword=?");
			sql.append(" ,metImg=?");
			sql.append("where metNum=?");

			System.out.println(sql.toString());

			System.out.println("���� : " + mVo);
			// update���� �⑥＜湲�.
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetIntro());
			pstmt.setString(3, mVo.getMetGreeting());
			pstmt.setString(4, mVo.getMetPlace());
			pstmt.setString(5, mVo.getKeyword());
			pstmt.setString(6, mVo.getMetImg());
			pstmt.setString(7, mVo.getMetNum());

			int flag = pstmt.executeUpdate();
			if (flag > 0) {
				result = true;
				conn.commit(); // ��猷��� 而ㅻ�
			}

		} catch (Exception e) {
			try {
				conn.rollback(); // �ㅻ��� 濡ㅻ갚
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}

		DBManager.close(conn, pstmt);
		return result;
	}

	// 독서모임 멤버쉽 회원 게시판 페이징 처리
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

			while (rs.next()) {
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
				mVo.setMemNum(rs.getString("memNum"));
				

				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 독서모임 홈에 공지사항 게시판 페이징 처리
	public Paging meetingRowCount(Paging paging, String metNum) {
		int cnt = 0;
		String sql = "select COUNT(*) CNT from itbook.met_board where metNum=? ";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, metNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt = rs.getInt("CNT");
				paging.setNumOfRow(cnt);
				;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return paging;
	}

	// 관리자 페이지에서 독서모임 승인하기
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
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void meetingManagerInsert(MemListVO mVo) {
		String sql = "insert into itbook.mem_list(memNum, metNum, memName, memId) select m.memNum,t.metNum,m.memName,m.memId from member m join meeting t on m.memNum = t.memNum where m.memNum = ? and t.metNum = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getMemNum());
			pstmt.setString(2, mVo.getMetNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void meetingManagerUpdate(MemListVO mVo) {
		String sql = "Update itbook.mem_list set approval = 'T' where memNum = ? and metNum = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemNum());
			pstmt.setString(2, mVo.getMetNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 독서모임 삭제하기
	public void deleteMeeting(MeetingVO mVO) {
		String sql = "Delete From itbook.meeting Where metNum = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVO.getMetNum());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//독서모임 승인 후 모임 회원 수 올리기
	public void countHeadCount(int headCount) {
		
		String sql = "UPDATE itbook.meeting"
					+ "SET headCount = headCount + 1"
					+ "WHERE metNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}