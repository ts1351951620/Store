package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PiPeiServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();
		String randomCode=(String)session.getAttribute("key");
		String random=request.getParameter("random");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(randomCode.equals(random)){
			out.print("验证码匹配");
		}else if(random==""){
			response.sendRedirect("/Bootstrap/html/Login.html");
		}else{
			out.print("验证码不匹配");
		}
		out.close();
	}

}
