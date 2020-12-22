//package tw.group4.util;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.Objects;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import tw.group4._14_.back.ARTProduct;
//import tw.group4._14_.front.model.ShoppingCartAP;
//import tw.group4._35_.login.model.WebsiteMember;
//
//public class IdentityFilter implements Filter {
//
//	public static int requestCounter = 0;
//	
//	public static String loginID = "a/";
//	
//	@Autowired
//	ServletContext ctx;
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
////		先取得session
//		HttpServletResponse httpRes = (HttpServletResponse) response;
//		HttpServletRequest httpReq = (HttpServletRequest) request;
//		HttpSession session = httpReq.getSession();
////		在過濾器什麼都還沒做之前，取得sessionTimeoutToken的值
////		如果逾時的話值會為空
//		String initialSessionTimeoutToken = (String)session.getAttribute("sessionTimeoutToken");
//		
//		String memberType = setSessionAndLoginID(session);
//		
////		到這邊session和login相關設定完成，先印出來
//		System.out.println("IdentityFilter End: 經過濾器判斷, 使用者身份: " + memberType + "; 視角(loginID): " + loginID);
//		System.out.println("------------------------------------------------------------------------------");
//		
////		最後要確認兩件事1.伺服器重啟導向首頁，2.session清空後的應對措施
////		1.伺服器重啟後首次送出網址請求，用HttpServletResponse.sendRedirect重新導向首頁
////		2.HttpServletRequest.getContextPath()可以取得ＷebApp根目錄"/Art", ie. "/WebApp名稱"
////		3.取得ＷebApp根目錄網址路徑的第二種方式
////		  String appContext = request.getContextPath();
////		  String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext;
//		if(requestCounter==1) {
////			requestCounter==1代表伺服器重啟首次進入網站，不論從哪個網址進入，強制導至首頁
//			httpRes.sendRedirect(httpReq.getContextPath()+"/");
//		}else if(requestCounter>1 && Objects.isNull(initialSessionTimeoutToken)) {
////			requestCounter!=1代表非首次進入網站，照理來說應該要有sessionTimeoutToken
////			如果session沒有先前設定的值"valid"也就是說session逾期被清空了，會強制導至sessionTimeout訊息頁面
////			Spring Security在這方面有更簡單做法
//			httpRes.sendRedirect(httpReq.getContextPath()+"/35/sessionTimeout");
//		}else {	
//			chain.doFilter(request, response);
//		}
//		
//	}
//	
//	public String setSessionAndLoginID(HttpSession session) {
//		
////		計算伺服器重啟後發送請求次數，來判斷伺服器是否剛重啟
//		requestCounter++;
//		System.out.println("客戶端發送請求次數："+requestCounter);
//		
////		如果session中sessionTimeoutToken為空，就是創一個放"valid"
//		String sessionTimeoutToken = (String)session.getAttribute("sessionTimeoutToken");
//		if(sessionTimeoutToken==null) {
//			session.setAttribute("sessionTimeoutToken", "valid");
//		}
//		
////		如果session中carList為空，就創一個，設定導覽列中要顯示的購物車品項數量
//		ShoppingCartAP carList = (ShoppingCartAP)session.getAttribute("carList");
//		if(carList==null) {
//			carList = new ShoppingCartAP();
//			Map<String, ARTProduct> cartAP = carList.getCartAP();
//			int size = cartAP.size();
//			session.setAttribute("carSize", size);
//		}
//		
////		如果session中shoppingcartnum為空，就創一個，設定導覽列中要顯示的購物車品項數量
//		Integer shoppingcartnum = (Integer) session.getAttribute("shoppingcartnum");
//		if(shoppingcartnum==null) {	
//			session.setAttribute("shoppingcartnum", 0);
//		}
//		
////		初始化memberType變數
//		String memberType = null;
////		如果session內有member屬性，也就是登入狀態，session內有memberType的值
////		取出memberType的值，再switch case設定loginID的值
//		if (Objects.nonNull(session.getAttribute("member"))) {
//			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
//			memberType = member.getMemberType();
//			
//			switch (memberType) {
//			case ("user"):
//				loginID = "b/";
//				break;
//			case ("admin"):
//				loginID = "c/";
//				break;
//			case ("userMemberArea"):
//				loginID = "d/";
//				break;
//			case ("adminMemberArea"):
//				loginID = "e/";
//				break;
//			case ("adminBackstage"):
//				loginID = "f/";
//				break;
////			例外狀況：session有member屬性卻不是上述的memberType值，強制重設為訪客視角
//			default:
//				loginID = "a/";
//				break;
//			}
//			
////		其餘沒登入狀態，i.e.session內沒有member屬性，給訪客視角
//		}else {
//			System.out.println("session內沒有member屬性");
//			memberType = "visitor";
//			loginID = "a/";
//			
//		}
//		return memberType;
////		
//	}
//
//}
