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

//梨� 寃뚯떆�뙋
public class BookDAO {
	private BookDAO() {

	}

	// �떛湲��넠 �뙣�꽩
	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {
		return instance;
	}
	
	
	
	
	// �씠�떖�쓽 梨� 由ъ뒪�듃. (�씪諛섑쉶�썝)
		public List<BookBoardVO> selectTodayBookList() {
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
				DBManager.close(conn, stmt, rs); // �삁�쟾�뿉�뒗 �떎 �띁吏�留� �씠�젣 �뵒鍮꾨ℓ�꼫吏�瑜� �넻�빐�꽌 �븳以꾨줈 ��.
			}
			return list;
		}
		
		
		
	// �씠�떖�쓽 梨� 由ъ뒪�듃 愿�由ъ옄
	public List<BookBoardVO> selectAdminTodayBookList() {
		String sql = "select b.bookNum,b.bookTitle,bb.bookBrdNum,bb.bookBrdTitle,b.writer,b.publisher,bb.memNum "
				 	+"from itbook.book_board bb,itbook.book b where bb.bookNum = b.bookNum order by bb.bookBrdNum desc";
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
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs); // �삁�쟾�뿉�뒗 �떎 �띁吏�留� �씠�젣 �뵒鍮꾨ℓ�꼫吏�瑜� �넻�빐�꽌 �븳以꾨줈 ��.
		}
		return list;
	}
	//�씠�떖�쓽 梨� �벑濡�(愿�由ъ옄)
	public void insertAdminTodayBookRegister(BookBoardVO bVo) {
		//sql�� �떎�뻾o
		String sql = "insert into itbook.book_board(bookBrdTitle,bookBrdContent,imgPath,memNum,bookNum) values (?,?,?,?,?);";
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBookBrdTitle());
			pstmt.setString(2, bVo.getBookBrdContent());
			pstmt.setString(3, bVo.getImgPath());
			pstmt.setString(4, bVo.getMemNum());
			pstmt.setString(5, bVo.getBookNum());
			
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		
	public void updateAdminTodayBook(BookBoardVO bVo) {
		String sql = "update itbook.book_board set bookTitle=?,writer=?,publisher=?,memNum=? where bookNum=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getBookTitle());
			pstmt.setString(2, bVo.getWriter());
			pstmt.setString(3, bVo.getPublisher());
			
			pstmt.setString(4, bVo.getMemNum());
			pstmt.setString(5, bVo.getBookNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	
	//�씠�떖�쓽 梨낆뿉�꽌 寃��깋�븷 �븣 �븘�슂�븳 遺�遺�
public ArrayList<BookVO> getBookList(HashMap<String, Object> listOpt) {
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String opt = (String)listOpt.get("opt"); // 寃��깋�샃�뀡(�젣紐�, �궡�슜, 湲��벖�씠 �벑...)
		String condition = (String)listOpt.get("condition"); //寃��깋�궡�슜
		
		
		try {
			conn = DBManager.getConnection();
			StringBuffer sql = new StringBuffer();
			
			 if(opt.equals("0")) // �젣紐⑹쑝濡� 寃��깋
	            {
	                sql.append("select * from itbook.book where bookTitle like ? ");
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, condition+"%");
	                sql.delete(0, sql.toString().length());
	            }else if(opt.equals("1")){ //�궎�썙�뱶濡� 寃��깋
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
				//梨� 由ъ뒪�듃
				BookVO bVo = new BookVO();
				
				bVo.setBookNum(rs.getString("bookNum"));
				bVo.setBookTitle(rs.getString("bookTitle"));
				bVo.setBookKeyword1(rs.getString("bookKeyword1"));
				bVo.setBookKeyword2(rs.getString("bookKeyword2"));
				bVo.setBookKeyword3(rs.getString("bookKeyword3"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setPublisher(rs.getString("publisher"));
				
				bookList.add(bVo);
			}
				
			} catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }
	        
			DBManager.close(conn, pstmt, rs);
			return bookList;
	    }
	
	// 梨� 由ъ뒪�듃 蹂댁뿬二쇨린
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
//			DBManager.close(conn, stmt, rs); // �삁�쟾�뿉�뒗 �떎 �띁吏�留� �씠�젣 �뵒鍮꾨ℓ�꼫吏�瑜� �넻�빐�꽌 �븳以꾨줈 ��.
//		}
//		return list;
//	}

	
	
	// 梨� �벑濡�
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

	// 紐⑤뱺 �궗�슜�옄媛� 梨낅━�뒪�듃�솕硫댁뿉�꽌 梨낅쾲�샇瑜� �겢由��븯硫� �닔�젙 �럹�씠吏�濡� �씠�룞.
	public BookVO selectOneBookNum(String bookNum) {

		String sql = "select bookNum,bookTitle,bookKeyword1,bookKeyword2,bookKeyword3,writer,publisher from itbook.book where bookNum = ?";

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
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	// 梨� �닔�젙.
	public void updateBook(BookVO bVo) {
		String sql = "update itbook.book set bookTitle=?,bookKeyword1=?,bookKeyword2=?,bookKeyword3=?,writer=?,publisher=?,memNum=? where bookNum=?";

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
			pstmt.setString(8, bVo.getBookNum());
			
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



	//梨� 由ъ뒪�듃 珥� 寃뚯떆湲� �닔 蹂닿린
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
	
	
	
	
	//梨� 由ъ뒪�듃 �럹�씠吏� 泥섎━
	public ArrayList<BookVO> selectBookPage(Paging paging) {
        
        String sql = "select bookNum,bookTitle,bookKeyword1,bookKeyword2,bookKeyword3,writer,publisher from itbook.book order by bookNum desc limit ?, 10";

         ArrayList<BookVO> list = new ArrayList<BookVO>();
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;

         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            //
            pstmt.setInt(1, ((paging.getPageNum() - 1) * paging.getPerPage()));
            
            //+1濡� �릺�뼱�엳�쑝硫� �벑濡앺븷�븣 諛붾줈 �븞蹂댁엫.
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
				
				list.add(bVo);
            }
         } catch (Exception e) {
            e.printStackTrace();
         }  finally {
 			DBManager.close(conn, pstmt, rs);
 		}
         return list;
      }	
	

//adminBookList
public ArrayList<BookVO> bookList() {
	String sql = "SELECT * FROM ITBOOK.BOOK";
	
	ArrayList<BookVO> list = new ArrayList<BookVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
	while(rs.next()) {
		BookVO bVO = new BookVO();
		
		bVO.setBookNum(rs.getString("bookNum"));
		bVO.setBookTitle(rs.getString("bookTitle"));
		bVO.setWriter(rs.getString("writer"));
		bVO.setPublisher(rs.getString("publisher"));
		bVO.setPublishDate(rs.getDate("publisherDate"));
		bVO.setMemNum(rs.getString("memNum"));
		list.add(bVO);
	}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
	return list;
}
}