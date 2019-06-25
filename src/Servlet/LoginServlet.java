package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.LoginBean;
import Dao.LoginDao;
import Util.JDBCUtils;

public class LoginServlet extends HttpServlet {
	private Statement stmt=null;
	private ResultSet rs=null;
	ResultSet rs0=null;
	ResultSet rs1=null;
	Connection conn=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			conn=JDBCUtils.getConnection();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			LoginBean login1=new LoginBean();
			String uid=request.getParameter("uid");
			String password=request.getParameter("password");
			login1.setUid(uid);
			login1.setPassword(password);
			HttpSession session=request.getSession();
			String randomCode=(String)session.getAttribute("key");
			String random=request.getParameter("random");
			session.setAttribute("uid", login1.getUid());
			System.out.println(uid+"..."+password);
			stmt=conn.createStatement();
			LoginBean login2=new LoginBean();
			LoginDao loginDao=new LoginDao();
			login2=loginDao.find(uid, password);
			System.out.println(login2);
			if (uid.equals("ts") && password.equals("123456") && randomCode.equals(random)) {
				response.sendRedirect("/Bootstrap/jsp/Manger.jsp");
			}else {
				if (login2!=null && randomCode.equals(random)) {
					/*request.getRequestDispatcher("/Bootstrap/jsp/Register.jsp").forward(request,response);//ת����ַ���䣬jsp����ʽ��ı�
	*/				response.sendRedirect("/Bootstrap/jsp/Homepage.jsp");//�ض��򣬵�ַ�ı�
				}else if (login2==null) {
					response.getWriter().write("<script>alert('�˺Ż�����������������µ�¼');window.location.href='/Bootstrap/jsp/Login.jsp'</script>");
				}else if (!randomCode.equals(random)) {
					response.getWriter().write("<script>alert('��֤�����󣬵�¼ʧ��');window.location.href='/Bootstrap/jsp/Login.jsp'</script>");
				}
			}
			/*if (login2!=null && randomCode.equals(random)) {
				request.getRequestDispatcher("/Bootstrap/jsp/Register.jsp").forward(request,response);//ת����ַ���䣬jsp����ʽ��ı�
				response.sendRedirect("/Bootstrap/jsp/Homepage.jsp");//�ض��򣬵�ַ�ı�
			}else if (login2==null) {
				response.getWriter().write("<script>alert('�˺Ż�����������������µ�¼');window.location.href='/Bootstrap/jsp/Login.jsp'</script>");
			}else if (!randomCode.equals(random)) {
				response.getWriter().write("<script>alert('��֤�����󣬵�¼ʧ��');window.location.href='/Bootstrap/jsp/Login.jsp'</script>");
			}*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs,stmt,conn);
		}
}
		
		
		
		
		
		
		/*PrintWriter out=response.getWriter();
		if(randomCode.equals(random)){
			out.print("��֤��ƥ��");
		}else if(random==""){
			response.sendRedirect("/Bootstrap/html/Login.html");
		}else{
			out.print("��֤�벻ƥ��");
		}
		out.close();*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
