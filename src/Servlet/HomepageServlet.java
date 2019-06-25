package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.HomepageBean;
import Util.JDBCUtils;


@SuppressWarnings("serial")
public class HomepageServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			st=conn.createStatement();
			String sql1="select * from message";
			rs=st.executeQuery(sql1);
			List<HomepageBean> list=new ArrayList<HomepageBean>();
			while(rs.next()){
				HomepageBean message=new HomepageBean();
				message.setMid(rs.getInt(1));
				message.setMname(rs.getString(2));
				message.setSid(rs.getInt(3));
				message.setNum(rs.getInt(4));
				message.setPrice(rs.getDouble(5));
				message.setDescribe(rs.getString(6));
				System.out.println(rs.getInt(1));
				list.add(message);
			}
			request.setAttribute("list", list);
			response.sendRedirect("/Bootstrap/jsp/Message.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs,st,conn);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
