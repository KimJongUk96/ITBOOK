package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import util.DBManager;

import com.itbook.vo.BookVO;
import com.itbook.vo.Paging;
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
	public boolean insertNotice(NoticeVO nVo) {
		
		
		boolean result = false;
		
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			conn.setAutoCommit( false );
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into notice(noticeTitle, noticeContent, noticeFile, noticeCount, noticeDate)");
			sql.append("values( ?, ?, ?, ?, sysdate())");
			

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getNoticeFile());
			pstmt.setInt(4, nVo.getNoticeCount());
			
			int flag = pstmt.executeUpdate();
			
            if(flag > 0){
               result = true;
               conn.commit(); 
            }

        } catch (Exception e) {
            
        	throw new RuntimeException(e.getMessage());
        }
			
			DBManager.close(conn, pstmt);
			return result;
	
	} // end noticeInsert();
	
	
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
					sql.append("select * from notice order by noticeNum desc limit ?, 10");
					
					
					
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, start);
					
					
					// StringBuffer를 비운다.
					sql.delete(0, sql.toString().length());
				}
				
				 else if(opt.equals("0")) // 제목으로 검색
		            {
		                sql.append("select * from notice where noticeTitle like ? "
		                		+ "order by noticeNum desc limit ?, 10");
		                
		                
		                pstmt = conn.prepareStatement(sql.toString());
		                pstmt.setString(1, "%"+condition+"%");
		                pstmt.setInt(2, start);
		               
		                
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
					nVo.setNoticeFile(rs.getString("noticeFile"));
					
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
				nVo.setNoticeFile(rs.getString("noticeFile"));
				
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
				DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}
	
	//공지사항 게시물 수정
	public boolean updateNotice(NoticeVO nVo) {
		
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			conn.setAutoCommit( false ); // 자동 커밋을 false로 한다.
			
			StringBuffer sql = new StringBuffer();
			sql.append("update notice set");
			sql.append(" noticeTitle=?");
			sql.append(" ,noticeContent=?");
			sql.append(" ,noticeFile=?");
			sql.append("where noticeNum=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getNoticeFile());
			pstmt.setString(4, nVo.getNoticeNum());
			
			
			int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }
			
		} catch (Exception e) {
			try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
		
		DBManager.close(conn, pstmt);
		return result;
	} // end updateNotice
	
	//공지사항 삭제 
	
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
	//관리자 공지사항 글 삭제
	public void noticeDelete(NoticeVO nVO) {
		String sql = "delete from notice where noticeNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nVO.getNoticeNum());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	//관리자화면 리스트 화면
			public Paging selectNoticeRowCount(Paging paging) {
				int cnt = 0;
				String sql = "SELECT COUNT(*) CNT"
			            + "     FROM itbook.notice";
			      
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
			
			//관리자 공지사항 페이징 처리
			public ArrayList<NoticeVO> selectNoticePage(Paging paging) {
		        
		        String sql = "select * from notice order by noticeNum desc limit ?, 10";

		         ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		         
		         Connection conn = null;
		         PreparedStatement pstmt = null;
		         ResultSet rs = null;

		         try {
		            conn = DBManager.getConnection();
		            pstmt = conn.prepareStatement(sql);
		            
		            //
		            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
		            
		            //+1로 되어있으면 등록할때 바로 안보임.
//		            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()) + 1);
//		            pstmt.setInt(1, ((paging.getLastPage())));
		            
		            rs = pstmt.executeQuery();
		            
		            
		            while (rs.next()) {
		            	NoticeVO nVo = new NoticeVO();
		               
		                nVo.setNoticeNum(rs.getString("noticeNum"));
		                nVo.setNoticeTitle(rs.getString("noticeTitle"));
		                nVo.setNoticeDate(rs.getDate("noticeDate"));
						nVo.setNoticeContent(rs.getString("noticeContent"));
						nVo.setNoticeCount(rs.getInt("noticeCount"));
						
						list.add(nVo);
		            }
		         } catch (Exception e) {
		            e.printStackTrace();
		         }  finally {
		 			DBManager.close(conn, pstmt, rs);
		 		}
		         return list;
		      }
	
	
	
}












































