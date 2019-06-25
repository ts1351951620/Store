package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteHistoryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>");
		response.getWriter().write("var x; var r=confirm('ÊÇ·ñÇå¿Õ¹ºÂò¼ÇÂ¼£¿');");
		response.getWriter().write("if(r==true){location.href='/Bootstrap/suredeletehistory'}");
		response.getWriter().write("else{window.location='/Bootstrap/jsp/History.jsp'}");
		response.getWriter().write("</script>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
