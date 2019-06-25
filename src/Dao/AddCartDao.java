package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Bean.CarBean;
import Bean.RegisterBean;
import Util.JDBCUtils;

public class AddCartDao {
	//给表car中插入值
	public boolean insert (CarBean car){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
			try {
				conn=JDBCUtils.getConnection();
				String sql1="insert car values(?,?,?,?,?,?)";
				PreparedStatement stmt1=conn.prepareStatement(sql1);
				stmt1.setInt(1,car.getMid());
				stmt1.setString(2,car.getMname());
				stmt1.setString(3,car.getUid());
				stmt1.setDouble(4,car.getPrice());
				stmt1.setDouble(5,car.getNum());
				stmt1.setDouble(6,car.getMoney());
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
	//给car2表中插入数据
	public boolean insert2 (CarBean car){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
			try {
				conn=JDBCUtils.getConnection();
				String sql1="insert car2 values(?,?,?,?,?,?)";
				PreparedStatement stmt1=conn.prepareStatement(sql1);
				stmt1.setInt(1,car.getMid());
				stmt1.setString(2,car.getMname());
				stmt1.setString(3,car.getUid());
				stmt1.setDouble(4,car.getPrice());
				stmt1.setDouble(5,car.getNum());
				stmt1.setDouble(6,car.getMoney());
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
	//根据uid查询表car2中的值
	public ArrayList<CarBean> findUid2(String uid){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<CarBean> list=new ArrayList<CarBean>();
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="select * from car2 where uid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1, uid);
			rs=ste2.executeQuery();
			while (rs.next()) {
				CarBean car=new CarBean();
				car.setMid(rs.getInt(1));
				car.setMname(rs.getString(2));
				car.setUid(rs.getString(3));
				car.setPrice(rs.getDouble(4));
				car.setNum(rs.getInt(5));
				car.setMoney(rs.getDouble(6));
				list.add(car);
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
	
	//根据mid删除表car2中的值，成功返回true，失败返回false
	public boolean delete2(int mid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="delete from car2 where mid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setInt(1, mid);
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
	
	
	//根据购买数量查找表car中的值，查询成功返回true，失败返回false
	public CarBean find(int num){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql1="select * from car where num!=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setInt(1,num);
			rs=ste2.executeQuery();
			if(rs.next()){
				CarBean car=new CarBean();
				car.setMid(rs.getInt("mid"));
				car.setMname(rs.getString("Mname"));
				car.setUid(rs.getString("Uid"));
				car.setPrice(rs.getDouble("price"));
				car.setNum(rs.getInt("num"));
				car.setMoney(rs.getDouble("money"));
				return car;
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
	
	//根据mid删除表car中的值，成功返回true，失败返回false
	public boolean delete(int mid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="delete from car where mid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setInt(1, mid);
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
	//根据uid(用户账户)删除购物车car中的数据
	public boolean uidDelete(String uid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="delete from car where uid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1, uid);
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
	//根据uid(用户账户)删除car2中的数据
		public boolean uidDelete2(String uid) {
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try {
				conn=JDBCUtils.getConnection();
				stmt=conn.createStatement();
				String sql1="delete from car2 where uid=?";
				PreparedStatement ste2=conn.prepareStatement(sql1);
				ste2.setString(1, uid);
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
	//查询表car中的所有值，用list记录查询到的值
	public ArrayList<CarBean> findAll(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<CarBean> list=new ArrayList<CarBean>();
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="select * from car";
			rs=stmt.executeQuery(sql1);
			while (rs.next()) {
				CarBean car=new CarBean();
				car.setMid(rs.getInt(1));
				car.setMname(rs.getString(2));
				car.setUid(rs.getString(3));
				car.setPrice(rs.getDouble(4));
				car.setNum(rs.getInt(5));
				car.setMoney(rs.getDouble(6));
				list.add(car);
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
	
	//根据uid查询表中价格之和（查询总价）
	public Double findMoney(String uid){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			String sql1="select sum(money) from car where uid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1, uid);
			rs=ste2.executeQuery();
			if(rs.next()){
				CarBean car=new CarBean();
				car.setAllmoney(rs.getDouble(1));
				return car.getAllmoney();
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
	
	//根据uid查询car中的数据，返回查询结果集
	public ArrayList<CarBean> findUid(String uid){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<CarBean> list=new ArrayList<CarBean>();
		try {
			conn=JDBCUtils.getConnection();
			stmt=conn.createStatement();
			String sql1="select * from car where uid=?";
			PreparedStatement ste2=conn.prepareStatement(sql1);
			ste2.setString(1, uid);
			rs=ste2.executeQuery();
			while (rs.next()) {
				CarBean car=new CarBean();
				car.setMid(rs.getInt(1));
				car.setMname(rs.getString(2));
				car.setUid(rs.getString(3));
				car.setPrice(rs.getDouble(4));
				car.setNum(rs.getInt(5));
				car.setMoney(rs.getDouble(6));
				list.add(car);
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
