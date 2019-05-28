package com.itbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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



}
