package tw.group4._35_.login.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.group4._35_.util.GlobalService;

@WebFilter("/35/loginEntry")
public class FindCookieFilter implements Filter {
	
	String requestURI;
	
	public FindCookieFilter() {

	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("FindCookieFilter Begin");
		
		// 容器會在遠方客戶端提出請求、要求容器執行/35/loginEntry前，先執行本程式
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			// **********Remember Me****************
			String cookieName = "";
			String name = "";
			String password = "";
			String rememberMe = "";
			// 取出瀏覽器送來的Cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {   						// 如果含有Cookie
				for (int i = 0; i < cookies.length; i++) {	// 檢視每個Cookie
					cookieName = cookies[i].getName();
					if (cookieName.equals("name")) {
						//找到name這個Cookie
						name = cookies[i].getValue();
					} else if (cookieName.equals("password")) {
						//找到password這個Cookie						
						String tmpPwd  = cookies[i].getValue();
						// 將密碼解密
						//這邊加密方式和資料庫加密方式不同以免資安危機
						if (tmpPwd!= null){
							password = 	GlobalService.decryptString(GlobalService.KEY, tmpPwd);
						}
					} 
					else if (cookieName.equals("rm")) {
						//找到rm這個Cookie(rm: rememberMe)
						rememberMe = cookies[i].getValue();
					}
				}
			} else {
				// 找不到Cookie，沒有關係，就讓使用者輸入資料即可。
			}
			// 將這三項資料存入request物件   ${rememberMe}
			request.setAttribute("rememberMe", rememberMe);   //  ${requestScope.rememberMe}
			request.setAttribute("name", name);   // ${name}
			request.setAttribute("password", password);   // ${password}
		}
		
//		System.out.println("FindCookieFilter End");
		
		chain.doFilter(request, response);   // 請容器執行下一棒程式
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void destroy() {
	}
}
