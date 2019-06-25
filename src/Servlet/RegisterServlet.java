package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;

import Bean.RegisterBean;
import Dao.RegisterDao;
import Util.JDBCUtils;

public class RegisterServlet extends HttpServlet {
	Connection conn=null;
	Statement st;
	ResultSet rs;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			RegisterBean user1=new RegisterBean();
			RegisterDao userDao=new RegisterDao();
			conn=JDBCUtils.getConnection();
			String uid=request.getParameter("uid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String tel=request.getParameter("tel");
			
			RegisterBean user2=userDao.find(uid);
			if (user2==null) {
				user1.setUid(uid);
				user1.setPassword(password);
				user1.setUname(name);
				user1.setTel(tel);
				userDao.insert(user1);
				response.getWriter().write("<script >alert('注册成功');window.location.href='/Bootstrap/jsp/Login.jsp'</script>");
			}else{
				response.getWriter().write("<script >alert('账号重复，请重新注册');window.location.href='/Bootstrap/jsp/Register.jsp'</script>");
			}
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
