package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itbook.vo.donation.TaxVO;

import util.DBManager;

/**
 * 
 * 연말정산 영수증 신청 할 수 있는 클래스(싱글톤)
 * 
 * @author 김정민
 *
 */

public class TaxDAO {

	private static TaxDAO instance = new TaxDAO();

	public static TaxDAO getInstance() {

		return instance;

	}

	// 연말정산 영수증 신청
		public void insertTax(TaxVO tVo) {
		String sql = "insert into tax (taxName, taxEmail, taxPhone, taxAdr1, taxAdr2, taxAdr3, taxMsg)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getTaxName());
			pstmt.setString(2, tVo.getTaxEmail());
			pstmt.setString(3, tVo.getTaxPhone());
			pstmt.setString(4, tVo.getTaxAdr1());
			pstmt.setString(5, tVo.getTaxAdr2());
			pstmt.setString(6, tVo.getTaxAdr3());
			pstmt.setString(7, tVo.getTaxMsg());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
