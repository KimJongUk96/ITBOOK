package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itbook.vo.Meeting.MetCommentVO;

import util.DBManager;

public class MetCommentDAO {
	
	private static MetCommentDAO instance = new MetCommentDAO();

	public static MetCommentDAO getInstance() {

		return instance;
	}
	
	// 댓글 등록
    public boolean insertComment(MetCommentVO comment)
    {
        boolean result = false;
        
        Connection conn = null;
		PreparedStatement pstmt = null;
        
        try {
            conn = DBManager.getConnection();
 
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO met_comment");
            sql.append(" (metBrdNum, memNum, metComtParent, metComtContent");
            sql.append(" , metComtDate)");
            sql.append(" VALUES(?,?,?,?,sysdate())");
    
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, comment.getMetBrdNum());
            pstmt.setString(2, comment.getMemNum());
            pstmt.setString(3, comment.getMetComtParent());
            pstmt.setString(4, comment.getMetComtContent());
            
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
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        DBManager.close(conn, pstmt);
        return result;    
    } // end boardInsert();    
    
// // 댓글 목록 가져오기
//    public ArrayList<MetCommentVO> getCommentList(String metBrdNum)
//    {
//        ArrayList<MetCommentVO> list = new ArrayList<MetCommentVO>();
//        Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//        
//        try {
//            conn = DBManager.getConnection();
//            
//            /* 댓글의 페이지 처리를 하고싶다면 이 쿼리를 사용하면 된다.
//             * SELECT * FROM
//             *            (SELECT  ROWNUM AS rnum,
//             *                   data.*
//             *             FROM
//             *                   (SELECT LEVEL,
//             *                           COMMENT_NUM,
//             *                             COMMENT_BOARD,
//             *                           COMMENT_ID,
//             *                           COMMENT_DATE,
//             *                           COMMENT_PARENT,
//             *                           COMMENT_CONTENT
//             *                    FROM BOARD_COMMENT
//             *                    WHERE COMMENT_BOARD = ?
//             *                   START WITH COMMENT_PARENT = 0
//             *                   CONNECT BY PRIOR COMMENT_NUM = COMMENT_PARENT) 
//             *              data)
//             *    WHERE rnum>=? and rnum<=? ;
//             */
//            
//            StringBuffer sql = new StringBuffer();
//            sql.append("    SELECT LEVEL, COMMENT_NUM, COMMENT_BOARD,");
//            sql.append("            COMMENT_ID, COMMENT_DATE,");
//            sql.append("            COMMENT_PARENT, COMMENT_CONTENT");
//            sql.append("    FROM BOARD_COMMENT");
//            sql.append("    WHERE COMMENT_BOARD = ?");
//            sql.append("    START WITH COMMENT_PARENT = 0");
//            sql.append("    CONNECT BY PRIOR COMMENT_NUM = COMMENT_PARENT");         
//            
//            pstmt = conn.prepareStatement(sql.toString());
//            pstmt.setInt(1, metBrdNum);
//            
//            rs = pstmt.executeQuery();
//            while(rs.next())
//            {
//                CommentBean comment = new CommentBean();
//                comment.setComment_level(rs.getInt("LEVEL"));
//                comment.setComment_num(rs.getInt("COMMENT_NUM"));
//                comment.setComment_board(rs.getInt("COMMENT_BOARD"));
//                comment.setComment_id(rs.getString("COMMENT_ID"));
//                comment.setComment_date(rs.getDate("COMMENT_DATE"));
//                comment.setComment_parent(rs.getInt("COMMENT_PARENT"));
//                comment.setComment_content(rs.getString("COMMENT_CONTENT"));
//                list.add(comment);
//            }
//                
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
//        
//        close();
//        return list;
//    } // end getCommentList



}
