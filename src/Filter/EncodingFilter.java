package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter{
	private String encode;
	public void init(FilterConfig arg0) throws ServletException {
		encode=arg0.getInitParameter("Encoding");
	}
	

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("¹ýÂË×Ö·û");
		arg0.setCharacterEncoding(encode);
		arg1.setContentType("text/html;charset="+encode);
		arg2.doFilter(arg0, arg1);
	}
	public void destroy() {
		
	}
	

}
