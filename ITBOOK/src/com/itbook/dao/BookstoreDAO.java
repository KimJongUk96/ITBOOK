package com.itbook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
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
}
