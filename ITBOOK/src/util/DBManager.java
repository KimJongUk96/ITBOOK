package util;

import java.sql.*;


/**
 * JDBC �곌껐怨� �댁��瑜� �쎄� 吏�����湲� ������ 
 * getConnection(), close() �깆�� 硫�����瑜� 吏������� �대����
 * 
 * @author ��誘�
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
			System.out.println("DBManager : " + conn);

			return conn;
			
		} catch(SQLException ex) {
			System.out.println("SQLException" + ex);
		}
		
		catch(Exception e) {
			System.out.println("Exception" + e);}
	
			return null;
		}
	 /**
	    * DQL(select)�� ������ �� 由ъ���� �댁��瑜� ���� 硫�����
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
	    * DML(insert, update, delete)�� ������ �� 由ъ���� �댁��瑜� ���� 硫�����
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