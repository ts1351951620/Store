package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.JDBCUtils;
import Bean.RegisterBean;

public class RegisterDao {
	public boolean insert (RegisterBean user){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
			try {
				conn=JDBCUtils.getConnection();
				String sql1="insert us values(?,?,?,?)";
				PreparedStatement stmt1=conn.prepareStatement(sql1);
				stmt1.setString(1,user.getUid());
				stmt1.setString(2,user.getPassword());
				stmt1.setString(3,user.getUname());
				stmt1.setString(4,user.getTel());
				int num=stmt1.executeUpdate();
				if(num>0){
					return true;
				}
				return false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs,stmt,conn);
			}
			return false;
	}
	public RegisterBean find(String id){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql1="select * from us where uid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1,id);
			rs=ste2.executeQuery();
			if(rs.next()){
				RegisterBean user=new RegisterBean();
				user.setUid(rs.getString("uid"));
				user.setPassword(rs.getString("password"));
				user.setUname(rs.getString("uname"));
				user.setTel(rs.getString("tel"));
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
	
