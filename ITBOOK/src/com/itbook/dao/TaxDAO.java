package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itbook.vo.FeePaymentVO;
import com.itbook.vo.Paging;
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
		
	// 연말정산 영수증 내역보기
		public ArrayList<TaxVO> adminSelectTax(Paging paging) {
			String sql = "select * from itbook.tax order by taxNum desc limit ?,10";
			ArrayList<TaxVO> list = new ArrayList<TaxVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					TaxVO tVo = new TaxVO();
					
					tVo.setTaxNum(rs.getString("taxNum"));
					tVo.setTaxName(rs.getString("taxName"));
					tVo.setTaxPhone(rs.getString("taxPhone"));
					tVo.setTaxAdr1(rs.getString("taxAdr1"));
					tVo.setTaxAdr2(rs.getString("taxAdr2"));
					tVo.setTaxAdr3(rs.getString("taxAdr3"));
					tVo.setTaxEmail(rs.getString("taxEmail"));
					tVo.setTaxMsg(rs.getString("taxMsg"));
					list.add(tVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
			}
			return list;
		}
		
		public Paging selectTaxRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM itbook.tax";
		      
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
	}
