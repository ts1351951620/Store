package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Bean.HomepageBean;
import Util.JDBCUtils;

public class ClassifyDao {

	public ArrayList<HomepageBean> findSid(int sid){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<HomepageBean> list=new ArrayList<HomepageBean>();
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="select * from message where sid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setInt(1,sid);
			rs=ste2.executeQuery();
			while (rs.next()) {
				HomepageBean message=new HomepageBean();
				message.setMid(rs.getInt(1));
				message.setMname(rs.getString(2));
				message.setSid(rs.getInt(3));
				message.setNum(rs.getInt(4));
				message.setPrice(rs.getDouble(5));
				message.setDescribe(rs.getString(6));
				list.add(message);
			}
			return list;
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
