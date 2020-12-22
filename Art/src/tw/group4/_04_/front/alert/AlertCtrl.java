package tw.group4._04_.front.alert;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tw.group4._14_.back.Alerts;
import tw.group4._14_.back.dao.AlertsService;
import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class AlertCtrl {

	@Autowired
	public AlertsService altService;

	@Autowired
	public ServletContext ctx;



	// 跳轉到給使用者填寫申訴內容的表單的 ctrl
	@RequestMapping(path = "/04/WriteIssueForm") // TODO 還沒有設ISSUE，跟處理的路徑
	public String WriteIssueForm(Model m, HttpSession session, @RequestParam(name = "issueId") String issueId) {

		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
			// TODO 記得設定登入完後跳轉回來
		}

		Alerts al = new Alerts();
		al.setMemberId(mb.getId());
		al.setMemberName(mb.getName());
		al.setIssueId(Integer.parseInt(issueId));
		m.addAttribute("al", al);
		return "04/front_Orderlist/IssueForm";
	}

	// Alert 轉接站，藉判斷 issue 跳轉至適合的處理頁面 (ShowCustomerIssue.jsp 中的 [ 前往處理 ] 按鈕會導向此
	// ctrl)
	@Hibernate
	@RequestMapping(path = "/04/AlertsDispatcher")
	public String AlertsDispatcher(@RequestParam(name = "issue") String issue,
			@RequestParam(name = "issueId") String issueId) {

		if ("得藝洋行商品退換貨".equals(issue)) {

			// 由於是退換貨，此處直接跳轉至後台管理商品頁面的該項訂單
			return "redirect:/14/MbOrderListSelect.ctrl?orderListID=" + issueId;

		} else if ("得藝良票退票".equals(issue)) {

			return "redirect:/04/Cms/SearchOneOrder.ctrl?orderid="+issueId;
		}

		return "14/14_NewIndex";
	}

//	// 商品退貨 Alert 生成
	@Hibernate
	@RequestMapping(path = "/04/ShopAPAlerts")
	public String AlertsShopAP(HttpSession session, @RequestParam(name = "issueId") String issueId,
			@RequestParam(name = "issue", required = false) String issue,
			@RequestParam(name = "description") String description) {

		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
			// TODO 記得設定登入完後跳轉回來
		}

//			String link = "/Art/14/MbOrderListSelect.ctrl?orderListID="+issueId;
		String link = "";
		String icon = "fas fa-ticket-alt text-white"; // 設定 alters 的 icon 樣式
		String type = "icon-circle bg-success"; // 設定 icon 樣式背景色
		String contentAC = "會員" + mb.getRealName() + "送來申請退票的請求"; // 設定在 alerts 顯示的一行字訊息

		int id = Integer.parseInt(issueId);

		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 設定 alerts 訊息時間
		Date today = new Date();
		String time = sdFormat.format(today);

		Alerts al = new Alerts(mb.getId(), mb.getRealName(), link, icon, time, type, issue, id, contentAC, description,
				1);

		altService.insert(al);
		link = ctx.getContextPath() + "/14/ShowCustomerIssue?alertNo=" + al.getAleartNo(); // 設定 alerts 導向之通知中心路徑
		al.setLink(link);
		altService.update(al);

		return "/index/index";
	}
//
//	// 計算各入口點擊次數
//	@Hibernate
//	@RequestMapping(path = "/14/barChart", produces = "application/text; charset=utf-8")
//	@ResponseBody
//	public String barChart() {
//		
//		ArrayList<Integer> arrayList = new ArrayList<Integer>();
//		int action = 10;
//		int shop = 5;
//		int restaurant = 18;
//		int map = 8;
//		int course = 13;
//		int artist = 28;
//		
//		arrayList.add(action);
//		arrayList.add(shop);
//		arrayList.add(restaurant);
//		arrayList.add(map);
//		arrayList.add(course);
//		arrayList.add(artist);
//		
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(arrayList);
//
//		return json;
//	}

}
