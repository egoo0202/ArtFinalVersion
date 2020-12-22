package tw.group4._35_.login.controller;

import java.util.Objects;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.group4._35_.login.model.WebsiteMember;

@Controller
public class LogOut {

//	@ModelAttribute("thankU")代表在Model新增一個屬性
//	但是給值還是要透過m.addattribute，用@ModelAttribute傳進來的變數給值，效用只會在該方法內
	@GetMapping("/35/logoutProcess")
	public String logoutProcess(Model m, ServletRequest request) {

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
		
		String thankU = null;
		thankU = ((WebsiteMember) session.getAttribute("member")).getName() + "明天擱再來！";
//		移除session單一屬性
//		session.removeAttribute(); 
//		移除整個session
		session.invalidate();
		
//		建立新的session，因為要要區分登出與逾期清空session的差別
//		所以馬上把session內的"sessionTimeoutToken"加回來
		HttpSession sessionNew = httpReq.getSession();	
		sessionNew.setAttribute("sessionTimeoutToken", "valid");
		
		m.addAttribute("thankU", thankU);

		return "redirect:/35/logoutRedirect";
	}
	
}
