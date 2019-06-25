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
	//��֤��ͼƬ���
	Random random=new Random();//����һ���������������
	private int height=40;//���ÿ�
	private int width=80;//���ó�
	private String randString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//����������ַ���
	private int linesize=10;//����������
	private int stringNum=4;//��������ַ�����
	//�������
	private Font getFont(){
		return new Font("Fixedsys",Font.CENTER_BASELINE,18);
	}
	//�����ɫ�����ñ����������
	private Color getRandColor(int i){
		/*if(fc>255)
			fc=255;
		if(bc>255)
			bc=255;*/
		int r=random.nextInt(i);//random.nextInt(i)�����[0,i)֮������һ����
		int g=random.nextInt(i);
		int b=random.nextInt(i);
		return new Color(r,g,b);
	}
	//�������ͼƬ
	protected void getRandcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();//HttpSession������Ϊһ�ζԻ�����������رգ������ֵ�Ͳ�����ʧ
		//BufferedImage���Ǿ��л�������Image�࣬Image������������ͼ����Ϣ����
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();//����image�����ϵ�Graphics���󣬸ö��������ͼ���Ͻ��и��ֻ��Ʋ���
		g.fillRect(0,0,width,height);//����������
		g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
		g.setColor(getRandColor(255));//�����ɫ
		//���Ƹ�����
		for(int i=1;i<=linesize;i++){
			drawLine(g);
			
		}
		//�������stringNum���ַ�
		String randomString="";
		for(int i=1;i<=stringNum;i++){
			randomString=drowString(g,randomString,i);
		}
		session.setAttribute("key", randomString);
		System.out.println(randomString);
		g.dispose();//�ͷſռ�
		ImageIO.write(image, "JPEG", response.getOutputStream());//���ͼƬ
	}
	//������������ַ���
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(getRandColor(255));
		String rand=String.valueOf(getRandomString(random.nextInt(randString.length())));//����numΪrandomString�ַ����ȵ�����ֵ
		randomString+=rand;//��ÿһ������������ַ���ӵ�randomString�ַ������ڻ�ȡ���������4λ�ַ���
		g.translate(random.nextInt(6), random.nextInt(6));//����x��y����Ϊ�µ�����ԭ��
		g.drawString(rand, 13*i,16);//�ַ������Ļ���λ�ڣ�13*i��16����
		return randomString;
	}
	//���Ƹ�����
	private void drawLine(Graphics g){
		int x=random.nextInt(width);
		int y=random.nextInt(height);
		int x1=random.nextInt(12);
		int y1=random.nextInt(12);
		g.drawLine(x, y, x1, y1);
	}
	//��ȡ������ַ�
	public String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));//����numָ���±���ַ�ֵ
	}
	
	
	/*protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage buffImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g=buffImg.createGraphics();
		//����һ�������������
		Random random=new Random();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		//�������壬�����С����ͼƬ�߶�����
		Font font=new Font("Times New Roman",Font.PLAIN,18);
		//��������
		g.setFont(font);
		//���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width-1, height-1);
		//�������160��������
		g.setColor(Color.GRAY);
		for(int i=0;i<160;i++){
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x1, y1);
			//randomCode���ڱ��������������֤��
			StringBuffer randomCode=new StringBuffer();
			int red=0,green=0,blue=0;
			//���������λ���ֵ���֤��
			for(int i1=0;i1<4;i1++){
				//�õ������������֤������
				String strRand=String.valueOf(random.nextInt(10));
				//�����������ɫ������������ɫֵ
				red=random.nextInt(110);
				green=random.nextInt(50);
				blue=random.nextInt(50);
				//�������������ɫ����֤����Ƶ�ͼ����
				g.setColor(new Color(red,green,blue));
				g.drawString(strRand, 13*i+6, 16);
				randomCode.append(strRand);
				//����λ������֤�뱣�浽session��
				HttpSession session=request.getSession();
				session.setAttribute("randomCode",randomCode.toString());
				//��ֹͼ�񻺴�
				response.setHeader("Pragma","no-cache");
				response.setHeader("Cache-Control", "no-cache");
				response.setDateHeader("Expires", 0);
				response.setContentType("image/jpeg");
				//��ͼ�������servlet�������
				ServletOutputStream sos=response.getOutputStream();
				ImageIO.write(buffImg, "jpeg", sos);
				sos.close();
			}
			
		}
	}*/
	

}
