package tw.group4.util;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tw.group4._35_.login.model.WebsiteMember;

@Aspect
@Component
@Order(1)
public class AOPNeedLoginMethods {

//	尋找對應執行程式的方法之1:
//  設定所有DAO的class名稱到needLoginMethods變數
//  class名稱*(..)，指的是裡面帶任意參數的方法們
//	private static final String needLoginMethods = "execution(* tw.group4._35_.geo.controller.RandomRecom.randomRecom(..))"
//			+ " || execution(* tw.group4._35_.routePlanning.controller.RoutePlanningEntry.routePlanningEntry(..))";
//	
//	@Pointcut(needLoginMethods)
//	public void needLoginInvocation() {
//
//	}

//	尋找對應執行程式的方法之2，用已定義之註解

	private String contextPath;
	private String requestURI;

//	方法執行前
//	@Before("needLoginInvocation()")，這是舊的方法1，下面是較好用的方法2
	@Before("@annotation(NeedLogin)")
	public void before() throws IOException, ServletException {
//		用RequestContextHolder獲取request/response
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		HttpSession session = request.getSession();
//		如果伺服器重啟後首次送出請求，或是非首次，但是session逾期
//		就會忽略跳過此AOP，因為前一棒AOP已經導向特定頁面
		if (AOPCheckSessionAndIdentity.requestCounter > 1 && Objects.nonNull(session.getAttribute("sessionTimeoutToken"))) {

			boolean isRequestedSessionIdValid = false;

			if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse resp = (HttpServletResponse) response;
				contextPath = req.getContextPath();
				requestURI = req.getRequestURI();

				isRequestedSessionIdValid = req.isRequestedSessionIdValid();

				if (checkLogin(req)) {
					// 需要登入，但已經登入
					// do nothing 直接去執行後續
				} else {
					// 需要登入，尚未登入
					// 下段程式碼會送回登入畫面，在這之前先做前置動作: 取得session
//					HttpSession session = req.getSession();

					if (!isRequestedSessionIdValid) {
						// 如果session is not valid，把timeOut屬性放到session中
						session.setAttribute("timeOut", "使用逾時，請重新登入");
					} else {
						// "requestURI"是執行這個AOP前，發送請求要前往的網址，把他放到session中
						// 稍後如果登入成功，系統可以從session中撈出"requestURI"，自動轉入原本要執行的程式
						session.setAttribute("requestURI", requestURI);
						System.out.println("經AOPNeedLoginMethods判斷，原始請求網址為: " + requestURI + "已存進session");
					}

					// 跳轉登入頁面，並retrun結束這個AOP的執行
					resp.sendRedirect(contextPath + "/35/loginEntry");
					return;
				}
			} else {
				throw new ServletException("Request/Response 型態錯誤(極不可能發生)");
			}
		}

//	    獲取當前執行的方法名稱
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println("-------");

	}

////	方法執行後，不論正常與否皆執行此	  
//	@After("@annotation(NeedLogin)")
//	public void after(JoinPoint joinPoint) {
//		
//		System.out.println("after");
////	    獲取當前執行的方法名稱
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println("-------");
//
//	}

////	方法拋出例外就執行此，與	@AfterReturning呈現二選一  
//	@AfterThrowing("@annotation(NeedLogin)")
//	public void afterThrowing(JoinPoint joinPoint) {
//
////	    獲取當前執行的方法名稱
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println("-------");
//
//	}

	// 判斷Session物件內是否含有識別字串為member的屬性物件，如果有，表示已經登入，否則尚未登入
	public boolean checkLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();

		WebsiteMember loginToken = (WebsiteMember) session.getAttribute("member");
		if (loginToken == null) {
			return false;
		} else {
			return true;
		}
	}

}
