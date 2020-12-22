package tw.group4.util;

import java.util.Objects;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._35_.login.model.WebsiteMember;

@Controller
public class TilesReturnHomeController {

	@FrontAngleOfView
	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public String returnHome(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (Objects.nonNull(session.getAttribute("member"))) {
//			會員
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");

			if ((member.getMemberType()).equals("adminBackstage")) {
//				返回後台首頁頁面
				return "index/backIndex";
			} else {
//				返回前台首頁頁面
				return "index/index";
			}
		} else {
//			訪客
//			返回前台首頁頁面
			return "index/index";
		}
	}

	@FrontAngleOfView
	@RequestMapping(path = { "/**/index.html" }, method = RequestMethod.GET)
	public String returnIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (Objects.nonNull(session.getAttribute("member"))) {
//			會員
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");

			if ((member.getMemberType()).equals("adminBackstage")) {
//				返回後台首頁頁面
				return "index/backIndex";
			} else {
//				返回前台首頁頁面
				return "index/index";
			}
		} else {
//			訪客
//			返回前台首頁頁面
			return "index/index";
		}
	}

	@BackAngleOfView
	@GetMapping("/35/returnHomePageF")
	public String returnHomePageF(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (Objects.nonNull(session.getAttribute("member"))) {
//			會員
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");

			if ((member.getMemberType()).equals("adminBackstage")) {
//				返回後台首頁頁面
				return "index/backIndex";
			} else {
//				返回前台首頁頁面
				return "index/index";
			}
		} else {
//			訪客
//			返回前台首頁頁面
			return "index/index";
		}
	}

//  以下方法是控管進出會員專區和進出後台的身分狀態改變
	@RequestMapping(path = { "/userEnterMemberArea" }, method = RequestMethod.GET)
	public String userEnterMemberArea(ServletRequest request, Model m) {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		如果沒偵測到session內存在member屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute("member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，session已清空，請重新登入");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute("member")會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		member.setMemberType("userMemberArea");
		session.setAttribute("member", member);

//    	redirect是為了讓AOP可以重送請求，更新使用者身份
		return "redirect:/";
	}

	@RequestMapping(path = { "/userLeaveMemberArea" }, method = RequestMethod.GET)
	public String userLeaveMemberArea(ServletRequest request, Model m) {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		如果沒偵測到session內存在member屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute("member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，session已清空，請重新登入");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute("member")會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		member.setMemberType("user");
		session.setAttribute("member", member);

//    	redirect是為了讓AOP可以重送請求，更新使用者身份
		return "redirect:/";
	}

	@RequestMapping(path = { "/adminEnterMemberArea" }, method = RequestMethod.GET)
	public String adminEnterMemberArea(ServletRequest request, Model m) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		如果沒偵測到session內存在member屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute("member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，session已清空，請重新登入");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute("member")會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		member.setMemberType("adminMemberArea");
		session.setAttribute("member", member);

//    	redirect是為了讓AOP可以重送請求，更新使用者身份
		return "redirect:/";
	}

	@RequestMapping(path = { "/adminLeaveMemberArea", "/adminLeaveBackstage" }, method = RequestMethod.GET)
	public String adminLeaveMemberArea(ServletRequest request, Model m) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		如果沒偵測到session內存在member屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute("member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，session已清空，請重新登入");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute("member")會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		member.setMemberType("admin");
		session.setAttribute("member", member);

//    	redirect是為了讓AOP可以重送請求，更新使用者身份
		return "redirect:/";
	}

	@RequestMapping(path = { "/adminEnterBackstage" }, method = RequestMethod.GET)
	public String adminEnterBackstage(ServletRequest request, Model m) {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
//		如果沒偵測到session內存在member屬性，Model新增丟失session訊息，並導向首頁
		if (Objects.isNull(session.getAttribute("member"))) {
			m.addAttribute("sessionLost", "因server重啟等原因，session已清空，請重新登入");
			return "index/index";
		}
//		若是session內屬性值丟失，session.getAttribute("member")會NullPointerException
//		透過前述判斷式return首頁避免此窘狀
//		jsp預設session會自動創造，只是裡面會是空的，沒有任何屬性
//		httpReq.getSession()即可取得jsp自動創造的session

//		把既有的session內member抓出來，更新memberType
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		member.setMemberType("adminBackstage");
		session.setAttribute("member", member);

//    	redirect是為了讓AOP可以重送請求，更新使用者身份
		return "redirect:/35/returnHomePageF";
	}

}
