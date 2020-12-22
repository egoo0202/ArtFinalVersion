package tw.group4._35_.login.controller;

import java.util.Base64;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4._35_.util.GlobalService;
import tw.group4.util.Hibernate;

@Controller
public class LogIn {

	@Autowired
	ServletContext ctx;

	@Autowired
	WebsiteMemberService wmService;

	@GetMapping("/35/loginEntry")
	public String loginEntry(Model m) {
		WebsiteMember member = new WebsiteMember();
		m.addAttribute("member", member);
		return "35/login/login";
	}

	@Hibernate
	@PostMapping("/35/loginCheck.ctrl")
	public String loginCheck(@RequestParam(name = "rememberMe", required = false) String rememberMe,
			@ModelAttribute WebsiteMember member, BindingResult result, Model m, ServletRequest request,
			ServletResponse response) {

		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
//		這邊設立一個未加密密碼字串
//		以免混淆塞入資料庫的已加密密碼，和放進cookie用不同方法加密之密碼
		String unencryptedPassword = member.getPassword();

		if (member.getName() == null || member.getName().length() == 0) {
			errors.put("user", "帳號不可為空");
		}

		if (member.getPassword() == null || member.getPassword().length() == 0) {
			errors.put("pwd", "密碼不可為空");
		}

//		如果輸入值任一為空就返回原先頁面
//		因為綁定form表單，所以要傳回member物件
		if (errors != null && !errors.isEmpty()) {
			m.addAttribute("member", member);
			return "35/login/login";
		}

		// 將密碼加密兩次，以便與存放在表格內的密碼比對
		String password = GlobalService.getMD5Endocing(GlobalService.encryptString(member.getPassword()));
		member.setPassword(password);
//		加密完更新密碼再往下丟比對
		boolean status = wmService.checkLogin(member);

		if (!status) {
//			驗證失敗，傳到失敗頁的會員資料和資訊
//			因為綁定form表單，所以要傳回member物件
			m.addAttribute("member", member);
			m.addAttribute("authError", "請確認你的帳號密碼是否正確");

			return "35/login/login";
		} else {
//			會員驗證成功，session放入會員資訊，最後會多一頁跳轉方便過濾器刷新身份
			WebsiteMember memberFullInfo = wmService.getMemberFullInfo(member);
			HttpServletRequest httpReq = (HttpServletRequest) request;
			HttpSession session = httpReq.getSession();
//			會員資料放進session
			session.setAttribute("member", memberFullInfo);
//			圖片byteArray透過Base64轉字串，輸出到html
			byte[] memberPicByteArray = wmService.getMemberPicByteArray(member);
			String encodedString = Base64.getEncoder().encodeToString(memberPicByteArray);
			session.setAttribute("memberPic", encodedString);

			// 接著建立cookie，搭配FindCookieFilter方便下次登入流程
			// 若勾選RememberMe**************************************
			Cookie cookieName = null;
			Cookie cookiePassword = null;
			Cookie cookieRememberMe = null;
			// cookie rm存放瀏覽器送來之RememberMe的選項，如果使用者對RememberMe打勾，rm的值就是yes，就不是null
			if (rememberMe != null) {
				cookieName = new Cookie("name", member.getName());
				cookieName.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
				cookieName.setPath(ctx.getContextPath());

				// 用util內定義公式加密密碼，再存放於cookie內
				String passwordEncoded = GlobalService.encryptString(unencryptedPassword);
				cookiePassword = new Cookie("password", passwordEncoded);
				cookiePassword.setMaxAge(7 * 24 * 60 * 60);
				cookiePassword.setPath(ctx.getContextPath());

				cookieRememberMe = new Cookie("rm", "true");
				cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
				cookieRememberMe.setPath(ctx.getContextPath());
				// 若使用者沒對 RememberMe 打勾，需要執行以下方法刪除cookie
			} else {
				cookieName = new Cookie("name", member.getName());
				cookieName.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
				cookieName.setPath(ctx.getContextPath());

				String passwordEncoded = GlobalService.encryptString(unencryptedPassword);
				cookiePassword = new Cookie("password", passwordEncoded);
				cookiePassword.setMaxAge(0);
				cookiePassword.setPath(ctx.getContextPath());

				cookieRememberMe = new Cookie("rm", "true");
				cookieRememberMe.setMaxAge(0);
				cookieRememberMe.setPath(ctx.getContextPath());
			}
			HttpServletResponse httpRes = (HttpServletResponse) response;
			httpRes.addCookie(cookieName);
			httpRes.addCookie(cookiePassword);
			httpRes.addCookie(cookieRememberMe);
			// ********************************************

			return "redirect:/35/loginSuccess";
		}
	}

}
