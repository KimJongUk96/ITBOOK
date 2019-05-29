package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itbook.vo.BookVO;
import com.itbook.vo.Paging;
import com.itbook.vo.Book.BookBoardVO;

import util.DBManager;

//책 게시판
public class BookDAO {
	private BookDAO() {

	}

	// 싱글톤 패턴
	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {
		return instance;
	}
	
	
	//파일 업로드
	
	// 이달의 책 리스트. (일반회원)
		public List<BookBoardVO> selectTodayBookList() {
			//String sql = "select b.bookNum,bb.bookBrdNum,b.bookTitle,bb.bookBrdTitle,bb.bookBrdContent,b.writer,b.publisher,bb.imgPath,bb.bookBrdDate "
				//		+ "from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc";
			
			String sql = "select b.bookNum,bb.bookBrdNum,b.bookTitle,bb.bookBrdTitle,bb.bookBrdContent,b.writer,b.publisher,bb.imgPath,bb.bookBrdDate "
					+ "from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc";
		
			
			
			List<BookBoardVO> list = new ArrayList<BookBoardVO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					BookBoardVO bVo = new BookBoardVO();
					
					bVo.setBookNum(rs.getString("bookNum"));
					bVo.setBookBrdNum(rs.getString("bookBrdNum"));
					bVo.setBookTitle(rs.getString("bookTitle"));
					bVo.setBookBrdTitle(rs.getString("bookBrdTitle"));
					bVo.setBookBrdContent(rs.getString("bookBrdContent"));
					bVo.setWriter(rs.getString("writer"));
					bVo.setPublisher(rs.getString("publisher"));
				/* bVo.setMemNum(rs.getInt("memNum")); */
					bVo.setImgPath(rs.getString("imgPath"));
					bVo.setBookBrdDate(rs.getDate("bookBrdDate"));
					
					list.add(bVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, stmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
			}
			return list;
		}
		
		
		//이달의 책 게시글수
		public Paging selectTodayBookRowCount(Paging paging) {
			int cnt = 0;
			String sql = "SELECT COUNT(*) CNT"
		            + "     FROM itbook.book_board";
		      
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
		
		
		//이달의 책 페이징(회원)
		public ArrayList<BookBoardVO> selecTodayBookPage(Paging paging) {
	        
	        String sql = "select b.bookNum,bb.bookBrdNum,b.bookTitle,bb.bookBrdTitle,bb.bookBrdContent,b.writer,b.publisher,bb.imgPath,bb.bookBrdDate "
	        		+"from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc limit ?,9";

	         ArrayList<BookBoardVO> list = new ArrayList<BookBoardVO>();
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;

	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            
	            //
	            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
	            
	            rs = pstmt.executeQuery();
	            
	            
	            while (rs.next()) {
	              BookBoardVO bVo = new BookBoardVO();
	               
	              	bVo.setBookNum(rs.getString("bookNum"));
					bVo.setBookBrdNum(rs.getString("bookBrdNum"));
					bVo.setBookTitle(rs.getString("bookTitle"));
					bVo.setBookBrdTitle(rs.getString("bookBrdTitle"));
					bVo.setBookBrdContent(rs.getString("bookBrdContent"));
					bVo.setWriter(rs.getString("writer"));
					bVo.setPublisher(rs.getString("publisher"));
				/* bVo.setMemNum(rs.getInt("memNum")); */
					bVo.setImgPath(rs.getString("imgPath"));
					bVo.setBookBrdDate(rs.getDate("bookBrdDate"));
					
					list.add(bVo);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }  finally {
	 			DBManager.close(conn, pstmt, rs);
	 		}
	         return list;
	      }
		
		
			//이달의 책 리스트페이징(관리자)
			public ArrayList<BookBoardVO> selectAdminTodayBookListPaging(Paging paging) {
	        String sql = "select b.bookNum,b.bookTitle,bb.bookBrdNum,bb.bookBrdTitle,bb.imgPath,b.writer,b.publisher,bb.memNum "
				 	+"from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc limit ?,10";
	        
	         ArrayList<BookBoardVO> list = new ArrayList<BookBoardVO>();
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;

	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            
	            //
	            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
	            
	            rs = pstmt.executeQuery();
	            
	            
	            while (rs.next()) {
	              BookBoardVO bVo = new BookBoardVO();
	               
	             	bVo.setBookNum(rs.getString("bookNum"));
					bVo.setBookBrdNum(rs.getString("bookBrdNum"));
					bVo.setBookTitle(rs.getString("bookTitle"));
					bVo.setBookBrdTitle(rs.getString("bookBrdTitle"));
					bVo.setImgPath(rs.getString("imgPath"));
					bVo.setWriter(rs.getString("writer"));
					bVo.setPublisher(rs.getString("publisher"));
					bVo.setMemNum(rs.getString("memNum"));
					
					list.add(bVo);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }  finally {
	 			DBManager.close(conn, pstmt, rs);
	 		}
	         return list;
	      }
		
	// 이달의 책 리스트 관리자
//	public List<BookBoardVO> selectAdminTodayBookList() {
//		String sql = "select b.bookNum,b.bookTitle,bb.bookBrdNum,bb.bookBrdTitle,bb.imgPath,b.writer,b.publisher,bb.memNum "
//				 	+"from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc";
//		List<BookBoardVO> list = new ArrayList<BookBoardVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				BookBoardVO bVo = new BookBoardVO();
//				
//				bVo.setBookNum(rs.getString("bookNum"));
//				bVo.setBookBrdNum(rs.getString("bookBrdNum"));
//				bVo.setBookTitle(rs.getString("bookTitle"));
//				bVo.setBookBrdTitle(rs.getString("bookBrdTitle"));
//				bVo.setImgPath(rs.getString("imgPath"));
//				bVo.setWriter(rs.getString("writer"));
//				bVo.setPublisher(rs.getString("publisher"));
//				bVo.setMemNum(rs.getString("memNum"));
//				
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, stmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
//		}
//		return list;
//	}
	
	
	
	//이달의 책 등록(관리자)
//	public void insertAdminTodayBookRegister(BookBoardVO bVo) {
//		//sql은 실행o
//		String sql = "insert into itbook.book_board(bookBrdTitle,bookBrdContent,bookTitle,writer,publisher,imgPath,memNum,bookNum) values (?,?,?,?,?,?,?,?);";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, bVo.getBookBrdTitle());
//			pstmt.setString(2, bVo.getBookBrdContent());
//			pstmt.setString(3, bVo.getBookTitle());
//			pstmt.setString(4, bVo.getWriter());
//			pstmt.setString(5, bVo.getPublisher());
//			pstmt.setString(6, bVo.getImgPath());
//			pstmt.setString(7, bVo.getMemNum());
//			pstmt.setString(8, bVo.getBookNum());
//			
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt);
//		}
//	}
	
	//첨부파일
	public boolean insertAdminTodayBookRegister(BookBoardVO bVo) {
		
		
		boolean result = false;
		
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBManager.getConnection();
			conn.setAutoCommit( false );
			
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into itbook.book_board(bookBrdTitle,bookBrdContent,bookTitle,writer,publisher,imgPath,memNum,bookNum)");
			sql.append("values (?,?,?,?,?,?,?,?)");
			

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, bVo.getBookBrdTitle());
			pstmt.setString(2, bVo.getBookBrdContent());
			pstmt.setString(3, bVo.getBookTitle());
			pstmt.setString(4, bVo.getWriter());
			pstmt.setString(5, bVo.getPublisher());
			pstmt.setString(6, bVo.getImgPath());
			pstmt.setString(7, bVo.getMemNum());
			pstmt.setString(8, bVo.getBookNum());
			
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
	
	}
		
	
	public void updateAdminTodayBook(BookBoardVO bVo) {
		String sql = "update itbook.book_board set bookBrdTitle=?,bookTitle=?,writer=?,publisher=?,bookBrdContent=? where bookBrdNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBookBrdTitle());
			pstmt.setString(2, bVo.getBookTitle());
			pstmt.setString(3, bVo.getWriter());
			pstmt.setString(4, bVo.getPublisher());
			pstmt.setString(5, bVo.getBookBrdContent());
			pstmt.setString(6, bVo.getBookBrdNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	//이달의 책 상세보기
	public BookBoardVO selectOneBookBrdNum(String bookBrdNum) {

		String sql = "select bookBrdNum,bookBrdTitle,bookBrdContent,writer,publisher,bookTitle from itbook.book_board where bookBrdNum = ?";

		BookBoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookBrdNum);

			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BookBoardVO();

				bVo.setBookBrdNum(rs.getString("bookBrdNum"));
				bVo.setBookBrdTitle(rs.getString("bookBrdTitle"));
				bVo.setBookBrdContent(rs.getString("bookBrdContent"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				bVo.setBookTitle(rs.getString("bookTitle"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	
	//이달의 책에서 검색할 때 필요한 부분
public ArrayList<BookVO> getBookList(HashMap<String, Object> listOpt) {
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등...)
		String condition = (String)listOpt.get("condition"); //검색내용
		
		
		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();
			
			 if(opt.equals("0")) // 제목으로 검색
	            {
	                sql.append("select * from itbook.book where bookTitle like ? ");
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, condition+"%");
	                sql.delete(0, sql.toString().length());
	            }else if(opt.equals("1")){ //키워드로 검색
	                sql.append("select * from itbook.book where bookKeyword1 Like ? or bookKeyword2 Like ? or bookKeyword3 Like ? ");
	                System.out.println("=============" + opt);
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, condition+"%");
	                pstmt.setString(2, condition+"%");
	                pstmt.setString(3, condition+"%");
	                sql.delete(0, sql.toString().length());
	            }
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				//책 리스트
				BookVO bVo = new BookVO();
				
				bVo.setBookNum(rs.getString("bookNum"));
				bVo.setBookTitle(rs.getString("bookTitle"));
				bVo.setBookKeyword1(rs.getString("bookKeyword1"));
				bVo.setBookKeyword2(rs.getString("bookKeyword2"));
				bVo.setBookKeyword3(rs.getString("bookKeyword3"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				bVo.setMemNum(rs.getString("memNum"));
				bookList.add(bVo);
			}
				
			} catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	        
			DBManager.close(conn, pstmt, rs);
			return bookList;
	    }
		//이달의 책 삭제
		public void deleteTodayBook(String bookBrdNum) {
			String sql = "delete from itbook.book_board where bookBrdNum=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bookBrdNum);
				pstmt.executeUpdate();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}

	// 책 리스트 보여주기
//	public List<BookVO> selectBookList() {
//		String sql = "select bookNum,bookTitle,bookKeyword1,bookKeyword2,bookKeyword3,writer,publisher from itbook.book order by bookNum";
//		List<BookVO> list = new ArrayList<BookVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//				BookVO bVo = new BookVO();
//
//				bVo.setBookNum(rs.getInt("bookNum"));
//				bVo.setBookTitle(rs.getString("bookTitle"));
//				bVo.setBookKeyword1(rs.getString("bookKeyword1"));
//				bVo.setBookKeyword2(rs.getString("bookKeyword2"));
//				bVo.setBookKeyword3(rs.getString("bookKeyword3"));
//				bVo.setWriter(rs.getString("writer"));
//				bVo.setPublisher(rs.getString("publisher"));
//
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, stmt, rs); // 예전에는 다 썼지만 이제 디비매너지를 통해서 한줄로 씀.
//		}
//		return list;
//	}

	
	
	// 책 등록
	public void insertBookRegister(BookVO bVo) {

		String sql = "insert into itbook.book(bookTitle,bookKeyword1,bookKeyword2,bookKeyword3,writer,publisher,memNum) values (?,?,?,?,?,?,?);";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBookTitle());
			pstmt.setString(2, bVo.getBookKeyword1());
			pstmt.setString(3, bVo.getBookKeyword2());
			pstmt.setString(4, bVo.getBookKeyword3());
			pstmt.setString(5, bVo.getWriter());
			pstmt.setString(6, bVo.getPublisher());
			pstmt.setString(7, bVo.getMemNum());
			
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 모든 사용자가 책리스트화면에서 책번호를 클릭하면 수정 페이지로 이동.
	public BookVO selectOneBookNum(String bookNum) {

		String sql = "select bookNum,bookTitle,bookKeyword1,bookKeyword2,bookKeyword3,writer,publisher,memNum from itbook.book where bookNum = ?";

		BookVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookNum);

			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bVo = new BookVO();

				bVo.setBookNum(rs.getString("bookNum"));
				bVo.setBookTitle(rs.getString("bookTitle"));
				bVo.setBookKeyword1(rs.getString("bookKeyword1"));
				bVo.setBookKeyword2(rs.getString("bookKeyword2"));
				bVo.setBookKeyword3(rs.getString("bookKeyword3"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				bVo.setMemNum(rs.getString("memNum"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	// 책 수정.
	public void updateBook(BookVO bVo) {
		String sql = "update itbook.book set bookTitle=?,bookKeyword1=?,bookKeyword2=?,bookKeyword3=?,writer=?,publisher=? where bookNum=?";

		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBookTitle());
			pstmt.setString(2, bVo.getBookKeyword1());
			pstmt.setString(3, bVo.getBookKeyword2());
			pstmt.setString(4, bVo.getBookKeyword3());
			pstmt.setString(5, bVo.getWriter());
			pstmt.setString(6, bVo.getPublisher());
			pstmt.setString(7, bVo.getBookNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	
	public void deleteBook(String bookNum) {
		String sql = "delete from itbook.book where bookNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	//관리자 책 리스트 삭제
	public void bookDelete(BookVO bVO) {
		String sql = "delete from itbook.book where bookNum=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVO.getBookNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}



	//책 리스트 총 게시글 수 보기
	public Paging selectBookRowCount(Paging paging) {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT"
	            + "     FROM itbook.book";
	      
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
	
	
	
	
	//책 리스트 페이징 처리
	public ArrayList<BookVO> selectBookPage(Paging paging) {
        
        String sql = "select b.bookNum,b.bookTitle,b.bookKeyword1,b.bookKeyword2,b.bookKeyword3,b.writer,b.publisher,m.memName,m.memNum " + 
        		"from itbook.book b,itbook.member m " + 
        		"where b.memNum = m.memNum order by bookNum desc limit ?, 10";

         ArrayList<BookVO> list = new ArrayList<BookVO>();
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            //
            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
            
            //+1로 되어있으면 등록할때 바로 안보임.
//            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()) + 1);
//            pstmt.setInt(1, ((paging.getLastPage())));
            
            rs = pstmt.executeQuery();
            
            
            while (rs.next()) {
              BookVO bVo = new BookVO();
               
               	bVo.setBookNum(rs.getString("bookNum"));
               	bVo.setBookTitle(rs.getString("bookTitle"));
				bVo.setBookKeyword1(rs.getString("bookKeyword1"));
				bVo.setBookKeyword2(rs.getString("bookKeyword2"));
				bVo.setBookKeyword3(rs.getString("bookKeyword3"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				bVo.setMemName(rs.getString("memName"));
				
				bVo.setMemNum(rs.getString("memNum"));
				
				list.add(bVo);
            }
         } catch (Exception e) {
            e.printStackTrace();
         }  finally {
 			DBManager.close(conn, pstmt, rs);
 		}
         return list;
      }


	
	}