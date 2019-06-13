package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.itbook.vo.FeePaymentVO;

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
			PreparedStatement stmt = null;
			try {
				conn = DBManager.getConnection();
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, fVo.getPayName());//후원이름
				stmt.setString(2, fVo.getPayEmail());//후원이메일
				stmt.setString(3, fVo.getPayMobileNumber());//후원자 전화번호
				stmt.setString(4, fVo.getPayZipcode());//우편번호
				stmt.setString(5, fVo.getPayAttach());//소속
				stmt.setString(6, fVo.getPayPosition());//직급
				stmt.setString(7, fVo.getPayMessage());//메세지
				stmt.setString(8, fVo.getPayBank());//은행
				stmt.setString(9, fVo.getPayFee());//후원금액
				stmt.setString(10, fVo.getBankName());//예금주
				stmt.setString(11, fVo.getPaySponsor());//후원방식
				stmt.setString(12, fVo.getPayBankNum());//계좌번호
				
				stmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, stmt);
			}
		}
	}
