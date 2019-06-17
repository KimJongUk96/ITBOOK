package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.itbook.vo.FeePaymentVO;
import com.itbook.vo.Paging;
import com.itbook.vo.Bookstore.BookstoreVO;

import util.DBManager;

public class feePaymentDAO {

		private feePaymentDAO() {
			
		}
		
		private static feePaymentDAO instance = new feePaymentDAO();
		
		//싱글톤 패턴
		public static feePaymentDAO getInstance() {
			
			return instance;
		}
		
		//후원 등록하기
		public void insertfeePayment(FeePaymentVO fVo) {
			String sql = "insert into itbook.fee_payment(payName,payEmail,payMobileNumber,payZipcode,"
					+ "payAttach,payPosition,payMessage,payBank,payFee,bankName,paySponsor,payBankNum) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, fVo.getPayName());//후원이름
				pstmt.setString(2, fVo.getPayEmail());//후원이메일
				pstmt.setString(3, fVo.getPayMobileNumber());//후원자 전화번호
				pstmt.setString(4, fVo.getPayZipcode());//우편번호
				pstmt.setString(5, fVo.getPayAttach());//소속
				pstmt.setString(6, fVo.getPayPosition());//직급
				pstmt.setString(7, fVo.getPayMessage());//메세지
				pstmt.setString(8, fVo.getPayBank());//은행
				pstmt.setString(9, fVo.getPayFee());//후원금액
				pstmt.setString(10, fVo.getBankName());//예금주
				pstmt.setString(11, fVo.getPaySponsor());//후원방식
				pstmt.setString(12, fVo.getPayBankNum());//계좌번호
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public Paging selectfeePayRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM itbook.fee_payment";
		      
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
		//후원 리스트 보기(관리자)
		public ArrayList<FeePaymentVO> adminSelectfeePayment(Paging paging) {
			String sql = "select * from itbook.fee_payment order by payNum desc limit ?,10";
			ArrayList<FeePaymentVO> list = new ArrayList<FeePaymentVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					FeePaymentVO fVo = new FeePaymentVO();
					
					fVo.setPayNum(rs.getString("payNum"));
					fVo.setPayName(rs.getString("payName"));
					fVo.setPayEmail(rs.getString("payEmail"));
					fVo.setPayMobileNumber(rs.getString("payMobileNumber"));
					fVo.setPayZipcode(rs.getString("payZipcode"));
					fVo.setPayAttach(rs.getString("payAttach"));
					fVo.setPayPosition(rs.getString("payPosition"));
					fVo.setPayMessage(rs.getString("payMessage"));
					fVo.setPayBank(rs.getString("payBank"));
					fVo.setBankName(rs.getString("bankName"));
					fVo.setPayFee(rs.getString("payFee"));
					fVo.setPaySponsor(rs.getString("paySponsor"));
					fVo.setPayBankNum(rs.getString("payBankNum"));
					
					list.add(fVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
			}
			return list;
		}
	}
