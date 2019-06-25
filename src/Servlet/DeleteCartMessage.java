package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCartMessage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int mid=Integer.parseInt(request.getQueryString());
			HttpSession session=request.getSession();
			session.setAttribute("mid", mid);
			response.getWriter().write("<script>");
			response.getWriter().write("var x; var r=confirm('ÊÇ·ñÉ¾³ý');");
			response.getWriter().write("if(r==true){location.href='/Bootstrap/suredelete'}");
			response.getWriter().write("else{window.location='/Bootstrap/jsp/Cart.jsp'}");
			response.getWriter().write("</script>");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
