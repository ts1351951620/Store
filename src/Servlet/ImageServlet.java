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
		response.setContentType("image/jpeg");//告诉浏览器输出图片
		response.setHeader("Pragma", "No-cache");//设置头响应信息，告诉浏览器不要缓存此内容
		//response.setHeader("Cache-Control","no-cache");
		//response.setDateHeader("Expire",0);
		RandomCodeServlet random=new RandomCodeServlet();
		random.getRandcode(request, response);//输出图片的方法
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
