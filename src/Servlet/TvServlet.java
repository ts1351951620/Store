package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.CarBean;
import Bean.HomepageBean;
import Dao.AddCartDao;
import Dao.ClassifyDao;
import Dao.HomepageDao;
import Util.JDBCUtils;
public class TvServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.getConnection();
			ClassifyDao tv=new ClassifyDao();
			ArrayList<HomepageBean> tvlist=tv.findSid(3);
			HttpSession session=request.getSession();
			for(int i=0;i<tvlist.size();i++){
				/*messagelist.get(i).getMid();*/
				String[] num=new String[100];
				num[i]=request.getParameter(Integer.toString(i+1));
				/*System.out.println(num[i]);*/
				if (!num[i].equals("0")) {
					AddCartDao carDao=new AddCartDao();
					String uid=session.getAttribute("uid")+"";
					CarBean car=new CarBean();
					car.setMid(tvlist.get(i).getMid());
					car.setMname(tvlist.get(i).getMname());
					car.setPrice(tvlist.get(i).getPrice());
					car.setNum(Integer.parseInt(num[i]));
					car.setUid(uid);
					car.setMoney(Integer.parseInt(num[i])*tvlist.get(i).getPrice());
					carDao.insert(car);
					carDao.insert2(car);
				}
			}
			response.sendRedirect("/Bootstrap/jsp/Cart.jsp");
		}
			/*if(messagelist==null||messagelist.size()<1){
				System.out.println("无数据");
			}else{ 
				for(HomepageBean message:messagelist){
					int i=message.getMid();
					String[] num=new String[100];
					num[i]=request.getParameter(Integer.toString(i));//下拉框
					System.out.println(num[i]);
					if (!num[i].equals("0")) {
						AddCartDao carDao=new AddCartDao();
						String uid=session.getAttribute("uid")+"";
						CarBean car=new CarBean();
						car.setMid(message.getMid());
						car.setMname(message.getMname());
						car.setPrice(message.getPrice());
						car.setNum(Integer.parseInt(num[i]));
						car.setUid(uid);
						car.setMoney(Integer.parseInt(num[i])*message.getPrice());
						carDao.insert(car);
					}
				}
				response.sendRedirect("/Bootstrap/jsp/Cart.jsp");
			}
		}*/catch (ClassNotFoundException e) {
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
