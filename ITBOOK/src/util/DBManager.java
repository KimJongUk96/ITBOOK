package util;

import java.sql.*;


/**
 * JDBC 연결과 해제를 쉽게 진행하기 위하여 
 * getConnection(), close() 등의 메소드를 지원하는 클래스
 * 
 * @author 정민
 *
 */

public class DBManager {

	public static void main(String[] args) throws Exception {
		
		DBManager.getConnection();
		
		
	}
	
	public static Connection getConnection() throws Exception{
		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://globalitbook.mysql.database.azure.com:3306/itbook?useSSL=true&requireSSL=false";
			String username = "myadmin@globalitbook";
			String password = "rlawjdals94!";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB접속 : " + conn);

			return conn;
			
		} catch(SQLException ex) {
			System.out.println("SQLException" + ex);
		}
		
		catch(Exception e) {
			System.out.println("Exception" + e);}
	
			return null;
		}
	 /**
	    * DQL(select)을 수행한 후 리소스 해제를 위한 메소드
	    * 
	    * @param conn
	    * @param stmt
	    * @param rs
	    */
	   public static void close(Connection conn, Statement stmt, ResultSet rs){
	      try{
	         rs.close();
	         stmt.close();
	         conn.close();
	      } catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	   
	   /**
	    * DML(insert, update, delete)을 수행한 후 리소스 해제를 위한 메소드
	    * 
	    * @param conn
	    * @param stmt
	    */
	   public static void close(Connection conn, Statement stmt){
	      try{
	         stmt.close();
	         conn.close();
	      } catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	
}