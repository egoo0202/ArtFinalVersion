package tw.group4.util;

import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.ShoppingCartAP;
import tw.group4._35_.login.model.WebsiteMember;

@Aspect
@Component
@Order(0)
public class AOPCheckSessionAndIdentity {

	public static int requestCounter = 0;

	private String loginID;

	@Autowired
	ServletContext ctx;

//	在@Contoller之下的所有方法
	@Pointcut("@within(org.springframework.stereotype.Controller)")
	public void controllerClassAnnotation() {

	}

//	web.bind.annotation.*底下所有註釋的所有方法
//	這方法是錯誤示範，沒有成功
//	@Pointcut("within(@org.springframework.web.bind.annotation.* *)")
//	public void allWebBindAnnotation() {
//
//	}
	
//	網誌映射常用註釋，測試搭配@Within使用失敗
//	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
//		    "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
//		    "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
//		    "|| @annotation(org.springframework.web.bind.annotation.PatchMapping)" +
//		    "|| @annotation(org.springframework.web.bind.annotation.PutMapping)" +
//		    "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)"
//		)
//	public void mappingAnnotations() {
//		
//	}
	
//	有@ResponseBody註釋的所有方法
	@Pointcut("@annotation(org.springframework.web.bind.annotation.ResponseBody)")
	public void responseBodyAnnotation() {
		
	}
	
//	有@ResponseBody註釋的所有方法
	@Pointcut("@annotation(org.springframework.messaging.handler.annotation.MessageMapping)")
	public void messageMappingAnnotation() {
		
	}
	
//	在@Contoller之下，有映射用註釋的所有方法；但排除@ResponseBody和@MessageMapping註釋的方法	
	@Around("controllerClassAnnotation() && !responseBodyAnnotation() && !messageMappingAnnotation()")
	public Object returnUrlValueAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("<<<------------@Around Advice 前面開始分隔線------------>>>");
//		重要：這邊是執行目標程式"前"，要做的事
//		用RequestContextHolder獲取request/response
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		System.out.println("Client端點擊的路徑: "+request.getRequestURI());
//		再用HttpServletRequest取得session
		HttpSession session = request.getSession();
//		在過濾器什麼都還沒做之前，取得sessionTimeoutToken的值
//		如果逾時的話值會為空
		String initialSessionTimeoutToken = (String) session.getAttribute("sessionTimeoutToken");

		String memberType = setSessionAndLoginID(session);

//		到這邊session和login相關設定完成，先印出來
		System.out.println("使用者身份: " + memberType + "\n視角(loginID): " + loginID);

//		最後要確認兩件事1.伺服器重啟導向首頁，2.session清空後的應對措施
//		1.伺服器重啟後首次送出網址請求，用HttpServletResponse.sendRedirect重新導向首頁
//		2.HttpServletRequest.getContextPath()可以取得ＷebApp根目錄"/Art", ie. "/WebApp名稱"
//		3.取得ＷebApp根目錄網址路徑的第二種方式
//		  String appContext = request.getContextPath();
//		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext;
//		先初始化要回傳的值value
		if (requestCounter == 1) {
//			requestCounter==1代表伺服器重啟首次進入網站，不論從哪個網址進入，強制導至首頁
			response.sendRedirect(request.getContextPath() + "/");
			System.out.println("requestCounter==1代表伺服器重啟首次進入網站，不論從哪個網址進入，強制導至首頁");
		} else if (requestCounter > 1 && Objects.isNull(initialSessionTimeoutToken)) {
//			requestCounter!=1代表非首次進入網站，照理來說應該要有sessionTimeoutToken
//			如果session沒有先前設定的值"valid"也就是說session逾期被清空了，會強制導至sessionTimeout訊息頁面
//			Spring Security在這方面有更簡單做法
			response.sendRedirect(request.getContextPath() + "/35/sessionTimeout");
			System.out.println("requestCounter!=1代表非首次進入網站，照理來說應該要有sessionTimeoutToken\n"
					+ "如果session沒有先前設定的值\"valid\"也就是說session逾期被清空了，會強制導至sessionTimeout訊息頁面");
		}
		System.out.println("<<<------------@Around Advice 前面結束分隔線------------>>>");
		
		System.out.println("|||-------------------目標方法開始執行------------------|||");
//		proceedingJoinPoint.proceed()這個動作代表要執行的目標方法
//		.proceed() invoke了目標方法
		Object targetMethodReturn = null;
		
		targetMethodReturn = proceedingJoinPoint.proceed();
		System.out.println("|||-------------------目標方法執行完畢------------------|||");
		
//		重要：這邊開始是執行目標方法"後"，要做的事
		System.out.println(">>>------------@Around Advice 後面開始分隔線------------<<<");
		Object returnValue = null;
		
		System.out.println("目標方法原始return值: " + targetMethodReturn);
//		如果是目標方法是void方法，回傳值為null，那就不要執行以下動作
		if(targetMethodReturn != null) {	
			if (targetMethodReturn.toString().contains("redirect:")) {
				returnValue = targetMethodReturn;
			} else {
				returnValue = loginID + targetMethodReturn;
			}
		}

		System.out.println("目標方法實際return值: " + returnValue);
		System.out.println(">>>------------@Around Advice 後面結束分隔線------------<<<");
		System.out.println("\n\n");

		return returnValue;
	}

	public String setSessionAndLoginID(HttpSession session) {

//		計算伺服器重啟後發送請求次數，來判斷伺服器是否剛重啟
		requestCounter++;
		System.out.println("Client端發送請求次數: " + requestCounter);

//		如果session中sessionTimeoutToken為空，就是創一個放"valid"
		String sessionTimeoutToken = (String) session.getAttribute("sessionTimeoutToken");
		if (sessionTimeoutToken == null) {
			session.setAttribute("sessionTimeoutToken", "valid");
		}

//		如果session中carList為空，就創一個，設定導覽列中要顯示的購物車品項數量
		ShoppingCartAP carList = (ShoppingCartAP) session.getAttribute("carList");
		if (carList == null) {
			carList = new ShoppingCartAP();
			Map<String, ARTProduct> cartAP = carList.getCartAP();
			int size = cartAP.size();
			session.setAttribute("carSize", size);
		}

//		如果session中shoppingcartnum為空，就創一個，設定導覽列中要顯示的購物車品項數量
		Integer shoppingcartnum = (Integer) session.getAttribute("shoppingcartnum");
		if (shoppingcartnum == null) {
			session.setAttribute("shoppingcartnum", 0);
		}

//		初始化memberType變數
		String memberType = null;
//		如果session內有member屬性，也就是登入狀態，session內有memberType的值
//		取出memberType的值，再switch case設定loginID的值
		if (Objects.nonNull(session.getAttribute("member"))) {
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			System.out.println("session內有member屬性\nmember帳號: "+member.getName());
			memberType = member.getMemberType();

			switch (memberType) {
			case ("user"):
				loginID = "b/";
				break;
			case ("admin"):
				loginID = "c/";
				break;
			case ("userMemberArea"):
				loginID = "d/";
				break;
			case ("adminMemberArea"):
				loginID = "e/";
				break;
			case ("adminBackstage"):
				loginID = "f/";
				break;
//			例外狀況：session有member屬性卻不是上述的memberType值，強制重設為訪客視角
			default:
				loginID = "a/";
				break;
			}

//		其餘沒登入狀態，i.e.session內沒有member屬性，給予訪客視角
		} else {
			System.out.println("session內沒有member屬性");
			memberType = "visitor";
			loginID = "a/";

		}
		return memberType;
//		
	}
}
