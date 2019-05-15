package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import util.DBManager;

import com.itbook.vo.Notice.NoticeVO;


/**
 * 
 * 공지사항 등록, 수정, 삭제, 조회를 할 수 있는 클래스
 * 
 * @author 김정민
 *
 */
public class NoticeDAO {

	private static NoticeDAO instance = new NoticeDAO();
	
	public static NoticeDAO getInstance() {
		
		return instance;
	}

  
    // 시퀀스를 가져온다.
    public int getSeq()
    {
        int result = 1;
        
        Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        
        try {
            conn = DBManager.getConnection();
            
            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT noticeNum FROM notice");
            
            pstmt = conn.prepareStatement(sql.toString());
            // 쿼리 실행
            rs = pstmt.executeQuery();
            
            if(rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        DBManager.close(conn, pstmt); 
        return result;
    } // end getSeq



	//공지사항 게시물 등록
	public void insertNotice(NoticeVO nVo) {
		String sql = "insert into itbook.notice("
				+ "noticeTitle, noticeContent, noticeCount, noticeDate) "
				+ "values(?, ?, ?, sysdate())";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setInt(3, nVo.getNoticeCount());
			
			
			pstmt.executeUpdate();
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	//게시글 리스트(페이징 처리)
		public ArrayList<NoticeVO> getNoticeList(HashMap<String, Object> listOpt) {
			
			ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등...)
			String condition = (String)listOpt.get("condition"); //검색내용
			int start = (Integer)listOpt.get("start"); // 현재 페이지번호
			
			
			try {
				conn = DBManager.getConnection();
				StringBuffer sql = new StringBuffer();
				
				// 글목록 전체를 보여줄 때
				if(opt == null)
				{
					sql.append("select * from notice where noticeNum >= ? and noticeNum <= ?");
					
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, start);
	                pstmt.setInt(2, start+9);

					
					// StringBuffer를 비운다.
					sql.delete(0, sql.toString().length());
				}
				
				 else if(opt.equals("0")) // 제목으로 검색
		            {
		                sql.append("select * from notice where noticeTitle like ? ");
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		               
		                
		                sql.delete(0, sql.toString().length());
		            }
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					NoticeVO nVo = new NoticeVO();
					
					nVo.setNoticeNum(rs.getString("noticeNum"));
					nVo.setNoticeTitle(rs.getString("noticeTitle"));
					nVo.setNoticeContent(rs.getString("noticeContent"));
					nVo.setNoticeDate(rs.getDate("noticeDate"));
					nVo.setNoticeCount(rs.getInt("noticeCount"));
					
					list.add(nVo);
				}
					
				} catch (Exception e) {
		            throw new RuntimeException(e.getMessage());
		        }
		        
				DBManager.close(conn, pstmt, rs);
				return list;
		    } // end getBoardList
		
		 // 글의 개수를 가져오는 메서드
	    public int getNoticeListCount(HashMap<String, Object> listOpt)
	    {
	    	
	    	Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
	        int result = 0;
	        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
	        String condition = (String)listOpt.get("condition"); // 검색내용
	        
	        try {
	            conn = DBManager.getConnection();
	            StringBuffer sql = new StringBuffer();
	            
	            if(opt == null)    // 전체글의 개수
	            {
	                sql.append("select count(*) from notice");
	                pstmt = conn.prepareStatement(sql.toString());
	                
	                // StringBuffer를 비운다.
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("0")) // 제목으로 검색한 글의 개수
	            {
	                sql.append("select count(*) from notice where noticeTitle like ?");
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, '%'+condition+'%');
	                
	                sql.delete(0, sql.toString().length());
	            }
	            rs = pstmt.executeQuery();
	            if(rs.next())    result = rs.getInt(1);
	            
	        } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	        
	        DBManager.close(conn, pstmt, rs);
	        return result;
	    } // end getBoardListCount



	
//	//게시글 리스트
//	public ArrayList<NoticeVO> getNoticeList(HashMap<String, Object> listOpt) {
//		
//		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등...)
//		String condition = (String)listOpt.get("condition"); //검색내용
//		
//		
//		try {
//			conn = DBManager.getConnection();
//			StringBuffer sql = new StringBuffer();
//			
//			// 글목록 전체를 보여줄 때
//			if(opt == null)
//			{
//				sql.append("select * from notice order by noticeNum desc;");
//				
//				pstmt = conn.prepareStatement(sql.toString());
//				
//
//				
//				// StringBuffer를 비운다.
//				sql.delete(0, sql.toString().length());
//			}
//			
//			 else if(opt.equals("0")) // 제목으로 검색
//	            {
//	                sql.append("select * from notice where noticeTitle like ? ");
//	                
//	                pstmt = conn.prepareStatement(sql.toString());
//	                pstmt.setString(1, "%"+condition+"%");
//	               
//	                
//	                sql.delete(0, sql.toString().length());
//	            }
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				NoticeVO nVo = new NoticeVO();
//				
//				nVo.setNoticeNum(rs.getInt("noticeNum"));
//				nVo.setNoticeTitle(rs.getString("noticeTitle"));
//				nVo.setNoticeContent(rs.getString("noticeContent"));
//				nVo.setNoticeDate(rs.getDate("noticeDate"));
//				nVo.setNoticeCount(rs.getInt("noticeCount"));
//				
//				list.add(nVo);
//			}
//				
//			} catch (Exception e) {
//	            throw new RuntimeException(e.getMessage());
//	        }
//	        
//			DBManager.close(conn, pstmt, rs);
//			return list;
//	    } // end getBoardList

	
	
	//게시글 리스트(백업)
//		public ArrayList<NoticeVO> noticeList() {
//			
//			ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
//			
//			Connection conn = null;
//			Statement pstmt = null;
//			ResultSet rs = null;
//			
//			String sql = "SELECT * FROM notice";
//		
//			try {
//				
//				conn = DBManager.getConnection();
//				pstmt = conn.createStatement();
//				rs = pstmt.executeQuery(sql);
//				
//				while (rs.next()) {
//					
//					NoticeVO nVo = new NoticeVO();
//					
//					nVo.setNoticeNum(rs.getInt("noticeNum"));
//					nVo.setNoticeTitle(rs.getString("noticeTitle"));
//					nVo.setNoticeContent(rs.getString("noticeContent"));
//					nVo.setNoticeDate(rs.getDate("noticeDate"));
//					nVo.setNoticeCount(rs.getInt("noticeCount"));
//					
//					list.add(nVo);
//				}
//				
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager.close(conn, pstmt, rs);
//			}
//			
//			return list;
//		
//		
//		}
	
	//조회수 증가
	public void updateReadCount(String noticeNum) {
		
		String sql = "update notice set noticeCount = noticeCount+1 where noticeNum=?";
		
		Connection conn = null;
		PreparedStatement  pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, noticeNum);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	//게시글 상세보기
	public NoticeVO selectOneNoticeByNum(String noticeNum) {
		String sql = "select * from notice where noticeNum=? order by noticeNum asc";
		
		NoticeVO nVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				nVo=new NoticeVO();
				nVo.setNoticeNum(rs.getString("noticeNum"));
				nVo.setNoticeTitle(rs.getString("noticeTitle"));
				nVo.setNoticeDate(rs.getDate("noticeDate"));
				nVo.setNoticeContent(rs.getString("noticeContent"));
				nVo.setNoticeCount(rs.getInt("noticeCount"));
				
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
				DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}
	
	//공지사항 게시물 수정
	public void updateNotice(NoticeVO nVo) {
		String sql = "update notice set noticeTitle=?, noticeContent=? where noticeNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getNoticeNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//공지사항 수정 
	
	public void deleteNotice(String noticeNum) {
		String sql = "delete from notice where noticeNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, noticeNum);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}












































