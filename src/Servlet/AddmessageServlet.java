package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.HomepageBean;
import Dao.HomepageDao;

public class AddmessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String mname=request.getParameter("mname");
		int sid=Integer.parseInt(request.getParameter("sid"));
		int num=Integer.parseInt(request.getParameter("num"));
		Double price=Double.parseDouble(request.getParameter("price"));
		String describe=request.getParameter("describe");
		HomepageDao messageDao=new HomepageDao();
		HomepageBean message=new HomepageBean();
		message.setMname(mname);
		message.setSid(sid);
		message.setNum(num);
		message.setPrice(price);
		message.setDescribe(describe);
		Boolean b=messageDao.insert(message);
		if(b==true){
			response.getWriter().write("<script>alert('添加成功');window.location.href='/Bootstrap/jsp/Manger.jsp'</script>");
		}else {
			response.getWriter().write("<script>alert('添加失败');window.location.href='/Bootstrap/jsp/Manger.jsp'</script>");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
