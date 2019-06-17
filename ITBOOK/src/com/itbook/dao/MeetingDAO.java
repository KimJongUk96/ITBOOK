package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.Paging;
import com.itbook.vo.Meeting.MeetingVO;
import com.itbook.vo.Meeting.MetBoardVO;

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

	// ����紐⑥�� VO ����
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
				+ "         ,headCount"
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
				mVo.setMetImg(rs.getString("metImg"));
				mVo.setHeadCount(rs.getInt("headCount"));

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

	// ����紐⑥�� ��泥���湲� : ����紐⑥��紐�, ����紐⑥����媛�, ������紐� ����!
	public boolean insertMeeting(MeetingVO mVo) {

		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			StringBuffer sql = new StringBuffer();

			sql.append("insert into itbook.meeting(metName,metGreeting,metIntro,represent,metPlace,keyword,metImg)");
			sql.append("values (?,?,?,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, mVo.getMetName());
			pstmt.setString(2, mVo.getMetGreeting());
			pstmt.setString(3, mVo.getMetIntro());
			pstmt.setString(4, mVo.getRepresent());
			pstmt.setString(5, mVo.getMetPlace());
			pstmt.setString(6, mVo.getKeyword());
			pstmt.setString(7, mVo.getMetImg());

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

	// 愿�由ъ�� 紐⑥�����댁� 珥�寃���湲� �� 蹂닿린
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

	// ����紐⑥�� 蹂� 寃����� 媛��몄�ㅺ린
	// +理�洹� 寃���臾� 5媛��ы�⑤�� 寃����� ���곌린
	public List<MetBoardVO> selectFiveMetBoard(String metNum) {

		List<MetBoardVO> list = new ArrayList<MetBoardVO>();

		String sql = "select * from itbook.met_board where metNum=? order by regDate desc limit 5";

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
				mbVo.setMetBrdContent(rs.getString("metBrdContent"));
				mbVo.setMetNum(rs.getString("metNum"));
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

	// ���댁�泥�由ы�� ��泥대え��寃���湲�
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

	// ����紐⑥�� ���쇰� �곌껐
	// ����紐⑥�� 硫��� �� ���몃�댁�� 蹂닿린 : 湲�踰��몃� 李얠���⑤��. �ㅽ�⑦��硫� return null
	public MeetingVO selectOneMeetingByNum(String metNum) {

		String sql = "SELECT metNum" + "			, metName" + "			, metIntro" + "			, metGreeting"
				+ "			, represent" + "			, metPlace" + "			, keyword" + "			, metDate"
				+ "			, headCount" + " FROM itbook.meeting" + " WHERE metNum = ?";

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

	// ����紐⑥�� ����
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

	// 紐⑥����泥� 由ъ�ㅽ��(愿�由ъ�� ��硫�)
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

				list.add(mVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 珥�寃���湲� �� 蹂닿린
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

	// ����紐⑥�� �뱀��
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

	// ����紐⑥�� 嫄곗�� 諛� ����
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
					+ "WHERE metNum=?"
					+ "AND membe";

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