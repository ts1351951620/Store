package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("")
public class JDBCUtils {

		public static Connection getConnection() throws ClassNotFoundException, SQLException{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;DatabaseName=buy";
			String username="sa";
			String password="123456";
			/*JDBCBean jdbc=new JDBCBean();
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/UserLogin";
			String username="root";
			String password="ts19990522";*/
			Connection conn=DriverManager.getConnection(url,username,password);
			return conn;
		}
		public static void release(Statement stmt,Connection conn){
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				stmt=null;
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				conn=null;
			}
		}
		public static void release(ResultSet rs,Statement stmt,Connection conn){
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				rs=null;
			}
			release(stmt, conn);
		}


}
