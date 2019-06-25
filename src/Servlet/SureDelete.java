package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AddCartDao;
import Util.JDBCUtils;

public class SureDelete extends HttpServlet {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			conn=JDBCUtils.getConnection();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			HttpSession session=request.getSession();
			int mid=(Integer) session.getAttribute("mid");
			System.out.println(mid);
			AddCartDao deleteDao=new AddCartDao();
			deleteDao.delete(mid);
			deleteDao.delete2(mid);
			response.sendRedirect("/Bootstrap/jsp/Cart.jsp");
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
