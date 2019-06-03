package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

import com.itbook.vo.BookVO;
import com.itbook.vo.Bookstore.BookstoreVO;


import util.DBManager;

public class BookstoreDAO {
	private BookstoreDAO() {
		
	}
	
	private static BookstoreDAO instance = new BookstoreDAO();
	
	//싱글톤 패턴
	public static BookstoreDAO getInstance() {
		
		return instance;
	}
	
	
	//책방리스트
	public List<BookstoreVO> selectBookstoreList() {
		String sql = "select * from itbook.bookstore";
		List<BookstoreVO> list = new ArrayList<BookstoreVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				BookstoreVO bsVo = new BookstoreVO();
				
				bsVo.setBookstoreNum(rs.getString("bookstoreNum"));
				bsVo.setBookstoreTitle(rs.getString("bookstoreTitle"));
				bsVo.setBookstoreContent(rs.getString("bookstoreContent"));
				bsVo.setBookstoreUrl(rs.getString("bookstoreUrl"));
				
				list.add(bsVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
		}
		return list;
	}


	public void insertBookstore(BookstoreVO bsVo) {
		String sql = "insert into itbook.bookstore(bookstoreTitle,bookstoreContent,bookstoreUrl,memNum) values(?,?,?,?)";
	
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bsVo.getBookstoreTitle());
			stmt.setString(2, bsVo.getBookstoreContent());
			stmt.setString(3, bsVo.getBookstoreUrl());
			stmt.setString(4, bsVo.getMemNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}
	
	public void updateBookstore(BookstoreVO bsVo) {
		String sql = "update itbook.bookstore set bookstoreTitle=?, bookstoreContent=?, bookstoreUrl=? where bookstoreNum=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bsVo.getBookstoreTitle());
			stmt.setString(2, bsVo.getBookstoreContent());
			stmt.setString(3, bsVo.getBookstoreUrl());
			stmt.setString(4, bsVo.getBookstoreNum());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
	}


	public void deleteBookstore(String bookstoreNum) {
		String sql = "delete from itbook.bookstore where bookstoreNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookstoreNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	//상세보기
	public BookstoreVO selectOneBookstoreNum(String bookstoreNum) {
		String sql = "select * from itbook.bookstore where bookstoreNum = ?";

		BookstoreVO bsVo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, bookstoreNum);

			
			rs = stmt.executeQuery();

			if (rs.next()) {
				bsVo = new BookstoreVO();

				bsVo.setBookstoreNum(rs.getString("bookstoreNum"));
				bsVo.setBookstoreTitle(rs.getString("bookstoreTitle"));
				bsVo.setBookstoreUrl(rs.getString("bookstoreUrl"));
				bsVo.setBookstoreContent(rs.getString("bookstoreContent"));
				
				//멤버넘은?
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return bsVo;
	}
}
