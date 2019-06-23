package util;

import java.sql.*;

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
			System.out.println("DBManager : " + conn);

			return conn;
			
		} catch(SQLException ex) {
			System.out.println("SQLException" + ex);
		}
		
		catch(Exception e) {
			System.out.println("Exception" + e);}
	
			return null;
		}
	
	   public static void close(Connection conn, Statement stmt, ResultSet rs){
	      try{
	         rs.close();
	         stmt.close();
	         conn.close();
	      } catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	   
	  
	   public static void close(Connection conn, Statement stmt){
	      try{
	         stmt.close();
	         conn.close();
	      } catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	
}