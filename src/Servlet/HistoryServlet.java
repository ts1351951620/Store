package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CarBean;
import Dao.AddCartDao;
@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid=String.valueOf(request.getSession().getAttribute("uid"));
		AddCartDao cartDao=new AddCartDao();
   		List<CarBean> car1=cartDao.findUid2(uid);
   		request.setAttribute("uid", uid);
   		request.setAttribute("car1", car1);
   		request.getRequestDispatcher("/jsp/History.jsp").forward(request, response);
	}

}
