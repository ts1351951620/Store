package Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomCodeServlet {
	//验证码图片宽度
	Random random=new Random();//建立一个随机数的生成器
	private int height=40;//设置宽
	private int width=80;//设置长
	private String randString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串
	private int linesize=10;//干扰线数量
	private int stringNum=4;//随机产生字符数量
	//获得字体
	private Font getFont(){
		return new Font("Fixedsys",Font.CENTER_BASELINE,18);
	}
	//获得颜色，设置背景的随机数
	private Color getRandColor(int i){
		/*if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;*/
		int r=random.nextInt(i);//random.nextInt(i)随机在[0,i)之间生成一个数
		int g=random.nextInt(i);
		int b=random.nextInt(i);
		return new Color(r,g,b);
	}
	//随机生成图片
	protected void getRandcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();//HttpSession作用域为一次对话，浏览器不关闭，保存的值就不会消失
		//BufferedImage类是具有缓冲区的Image类，Image类是属于描述图像信息的类
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();//产生image对象上的Graphics对象，该对象可以在图像上进行各种绘制操作
		g.fillRect(0,0,width,height);//设置填充矩形
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
		g.setColor(getRandColor(255));//随机颜色
		//绘制干扰线
		for(int i=1;i<=linesize;i++){
			drawLine(g);
			
		}
		//随机产生stringNum个字符
		String randomString="";
		for(int i=1;i<=stringNum;i++){
			randomString=drowString(g,randomString,i);
		}
		session.setAttribute("key", randomString);
		System.out.println(randomString);
		g.dispose();//释放空间
		ImageIO.write(image, "JPEG", response.getOutputStream());//输出图片
	}
	//绘制随机产生字符串
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(getRandColor(255));
		String rand=String.valueOf(getRandomString(random.nextInt(randString.length())));//参数num为randomString字符长度的任意值
		randomString+=rand;//将每一次随机产生的字符添加到randomString字符后，用于获取随机产生的4位字符串
		g.translate(random.nextInt(6), random.nextInt(6));//将（x，y）作为新的坐标原点
		g.drawString(rand, 13*i,16);//字符最左侧的基线位于（13*i，16）处
		return randomString;
	}
	//绘制干扰线
	private void drawLine(Graphics g){
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int x1=random.nextInt(12);
		int y1=random.nextInt(12);
		g.drawLine(x, y, x1, y1);
	}
	//获取随机的字符
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));//返回num指定下标的字符值
	}
	
	
	/*protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage buffImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=buffImg.createGraphics();
		//创建一个随机数生成器
		Random random=new Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		//创建字体，字体大小根据图片高度来定
		Font font=new Font("Times New Roman",Font.PLAIN,18);
		//设置字体
		g.setFont(font);
		//画边框
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		//随机产生160条干扰线
		g.setColor(Color.GRAY);
		for(int i=0;i<160;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x1, y1);
			//randomCode用于保存随机产生的验证码
			StringBuffer randomCode=new StringBuffer();
			int red=0,green=0,blue=0;
			//随机产生四位数字的验证码
			for(int i1=0;i1<4;i1++){
				//得到随机产生的验证码数字
				String strRand=String.valueOf(random.nextInt(10));
				//产生随机的颜色分量来构造颜色值
				red=random.nextInt(110);
				green=random.nextInt(50);
				blue=random.nextInt(50);
				//用随机产生的颜色将验证码绘制到图像中
				g.setColor(new Color(red,green,blue));
				g.drawString(strRand, 13*i+6, 16);
				randomCode.append(strRand);
				//将四位数的验证码保存到session中
				HttpSession session=request.getSession();
				session.setAttribute("randomCode",randomCode.toString());
				//禁止图像缓存
				response.setHeader("Pragma","no-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setContentType("image/jpeg");
				//将图像输出到servlet输出流中
				ServletOutputStream sos=response.getOutputStream();
				ImageIO.write(buffImg, "jpeg", sos);
				sos.close();
			}
			
		}
	}*/
	

}
