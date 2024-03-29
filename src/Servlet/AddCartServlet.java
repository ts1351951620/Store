package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Bean.CarBean;
import Bean.HomepageBean;
import Dao.AddCartDao;
import Dao.HomepageDao;
import Util.JDBCUtils;

public class AddCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			HomepageDao homepageDao=new HomepageDao();
			HttpSession session=request.getSession();
			ArrayList<HomepageBean> messagelist=homepageDao.findAll();
			for(int i=0;i<messagelist.size();i++){
				/*messagelist.get(i).getMid();*/
				String[] num=new String[100];
				num[i]=request.getParameter(Integer.toString(i+1));
				/*System.out.println(num[i]);*/
				if (!num[i].equals("0")) {
					AddCartDao carDao=new AddCartDao();
					String uid=session.getAttribute("uid")+"";
					CarBean car=new CarBean();
					car.setMid(messagelist.get(i).getMid());
					car.setMname(messagelist.get(i).getMname());
					car.setPrice(messagelist.get(i).getPrice());
					car.setNum(Integer.parseInt(num[i]));
					car.setUid(uid);
					car.setMoney(Integer.parseInt(num[i])*messagelist.get(i).getPrice());
					carDao.insert(car);
					carDao.insert2(car);
				}
			}
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
	public void destroy() {
		
	}

}
