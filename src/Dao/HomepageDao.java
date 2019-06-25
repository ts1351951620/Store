package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.CarBean;
import Bean.HomepageBean;
import Util.JDBCUtils;

public class HomepageDao {
//查询message表中的所有值，并返回结果集
	public ArrayList<HomepageBean> findAll(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<HomepageBean> list=new ArrayList<HomepageBean>();
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="select * from message";
			rs=stmt.executeQuery(sql1);
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
	//给message表中插入数据，成功返回true，失败返回false
	public boolean insert (HomepageBean message){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
			try {
				conn=JDBCUtils.getConnection();
				String sql1="insert message values(?,?,?,?,?)";
				PreparedStatement stmt1=conn.prepareStatement(sql1);
				stmt1.setString(1,message.getMname());
				stmt1.setInt(2,message.getSid());
				stmt1.setDouble(3,message.getNum());
				stmt1.setDouble(4,message.getPrice());
				stmt1.setString(5,message.getDescribe());
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
	//根据mname(商品名)，删除数据，成功返回true，失败返回false
	public boolean delete(String mname) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="delete from message where mname=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1, mname);
			int num=ste2.executeUpdate();
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
}
