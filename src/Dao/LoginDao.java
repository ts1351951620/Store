package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.LoginBean;
import Bean.RegisterBean;
import Util.JDBCUtils;

public class LoginDao {

	public LoginBean find(String uid,String password){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql1="select * from us where uid=? and password=?";
			PreparedStatement ste=conn.prepareStatement(sql1);
			ste.setString(1,uid);
			ste.setString(2,password);
			rs=ste.executeQuery(); 
			if(rs.next()){
				LoginBean user=new LoginBean();
				user.setUid(rs.getString("uid"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs,stmt,conn);
		}
		return null;
	}

}
