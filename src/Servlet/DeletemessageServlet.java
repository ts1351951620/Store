package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HomepageDao;

public class DeletemessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mname=request.getParameter("mname");
		HomepageDao messageDao=new HomepageDao();
		boolean b=messageDao.delete(mname);
		if (b==true) {
			response.getWriter().write("<script>alert('É¾³ý³É¹¦');window.location.href='/Bootstrap/jsp/Deletemessage.jsp'</script>");
		}else {
			response.getWriter().write("<script>alert('É¾³ýÊ§°Ü');window.location.href='/Bootstrap/jsp/Deletemessage.jsp'</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
