package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	/*public ImageServlet(){
		super();
	}
	public void destroy(){
		super.destroy();
	}*/
	//private static final long serialVersionUID=1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");//������������ͼƬ
		response.setHeader("Pragma", "No-cache");//����ͷ��Ӧ��Ϣ�������������Ҫ���������
		//response.setHeader("Cache-Control","no-cache");
		//response.setDateHeader("Expire",0);
		RandomCodeServlet random=new RandomCodeServlet();
		random.getRandcode(request, response);//���ͼƬ�ķ���
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
