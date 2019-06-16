package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itbook.vo.Paging;
import com.itbook.vo.Bookstore.BookstoreVO;
import com.itbook.vo.library.LibraryVO;

import util.DBManager;

public class LibraryDAO {
	private LibraryDAO() {

	}

	private static LibraryDAO instance = new LibraryDAO();

	// 싱글톤 패턴
	public static LibraryDAO getInstance() {

		return instance;
	}

	//관리자 리스트
	public ArrayList<LibraryVO> adminSelecLibraryList(Paging paging) {
		String sql = "select * from itbook.library order by libraryNum desc limit ?,10";
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				LibraryVO lVo = new LibraryVO();
				
				lVo.setLibraryNum(rs.getString("libraryNum"));
				lVo.setLibraryTitle(rs.getString("libraryTitle"));
				lVo.setLibraryContent(rs.getString("libraryContent"));
				lVo.setLibraryUrl(rs.getString("libraryUrl"));
				
				list.add(lVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
		}
		return list;
	}
	
	// 도서관 등록
	public void insertLibrary(LibraryVO lVo) {
		String sql = "insert into itbook.library(libraryTitle,libraryContent,libraryUrl,memNum) values(?,?,?,?)";

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, lVo.getLibraryTitle());
			stmt.setString(2, lVo.getLibraryContent());
			stmt.setString(3, lVo.getLibraryUrl());
			stmt.setString(4, lVo.getMemNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}

	// 도서관 수정
	public void updateLibrary(LibraryVO lVo) {
		String sql = "update itbook.library set libraryTitle=?, libraryContent=?, libraryUrl=? where libraryNum=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, lVo.getLibraryTitle());
			stmt.setString(2, lVo.getLibraryContent());
			stmt.setString(3, lVo.getLibraryUrl());
			stmt.setString(4, lVo.getLibraryNum());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}

	// 도서관 삭제
	public void deleteLibrary(String libraryNum) {
		String sql = "delete from itbook.library where libraryNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, libraryNum);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	// 도서관 상세보기
	public LibraryVO selectOneLibraryNum(String LibraryNum) {
		String sql = "select * from itbook.library where libraryNum = ?";

		LibraryVO lVo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, LibraryNum);

			rs = stmt.executeQuery();

			if (rs.next()) {
				lVo = new LibraryVO();

				lVo.setLibraryNum(rs.getString("libraryNum"));
				lVo.setLibraryTitle(rs.getString("libraryTitle"));
				lVo.setLibraryUrl(rs.getString("libraryUrl"));
				lVo.setLibraryContent(rs.getString("libraryContent"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return lVo;
	}


	//페이징
	public Paging selectLibraryRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT"
            + "     FROM itbook.library";
      
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

	// 도서관 리스트
	public ArrayList<LibraryVO> selectLibraryList(Paging paging) {
		String sql = "select * from itbook.library order by libraryNum desc limit ?,9";
		ArrayList<LibraryVO> list = new ArrayList<LibraryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				LibraryVO lVo = new LibraryVO();
				
				lVo.setLibraryNum(rs.getString("libraryNum"));
				lVo.setLibraryTitle(rs.getString("libraryTitle"));
				lVo.setLibraryContent(rs.getString("libraryContent"));
				lVo.setLibraryUrl(rs.getString("libraryUrl"));
				
				list.add(lVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
		}
		return list;
	}
}
