package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>");
		response.getWriter().write("var x; var r=confirm('»∑»œΩ·À„£ø');");
		response.getWriter().write("if(r==true){location.href='/Bootstrap/sureclear'}");
		response.getWriter().write("else{window.location='/Bootstrap/jsp/Cart.jsp'}");
		response.getWriter().write("</script>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
