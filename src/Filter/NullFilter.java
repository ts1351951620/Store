package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class NullFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		/*HttpServletResponse response=(HttpServletResponse) arg1;*/
		HttpSession session=request.getSession();
		String uid=String.valueOf(session.getAttribute("uid"));
		System.out.println(uid);
		if(uid==null){
			System.out.println("无用户");
		}else{
			System.out.println("有用户");
		}
		
		arg2.doFilter(arg0, arg1);
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
