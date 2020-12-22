package tw.group4._14_.back.controller;

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
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class AlertsController {

	@Autowired
	public AlertsService altService;

	@Autowired
	public ServletContext ctx;

	// 獲取前五筆最新訊息，顯示在後台小鈴鐺
	@Hibernate
	@RequestMapping(path = "/14/showAltartCenter.ctrl", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String showAltartCenter() {

		List<Alerts> list = altService.selectPartAlerts();

		Gson gson = new Gson();

		String json = gson.toJson(list);

		return json;
	}

	// 獲取所有訊息轉往 AlertsCenterCRUD.jsp (此為後台左側 memu 的跳轉 ctrl)
	@Hibernate
	@RequestMapping(path = "/14/showAltartCenterCRUD")
	public String showAltartCenterCRUD(Model m) {

		List<Alerts> list = altService.selectAllAlerts();
		m.addAttribute("list", list);

		return "14/alertCenter/AlertsCenterCRUD";
	}

	// 計算洋行營收 (這東西跟 alerts 沒有關係不用管他)
	@Hibernate
	@RequestMapping(path = "/14/sum.ctrl", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String showSum() {

		Long sumTotal = altService.sumTotal();

		String sumString = String.valueOf(sumTotal);
		
		if ("null".equals(sumString)) {
			sumString = "0";
		}


		return sumString;
	}
	
	// 計算洋行營收 (這東西跟 alerts 沒有關係不用管他)
	@Hibernate
	@RequestMapping(path = "/14/actionSum.ctrl", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String actionSum() {

		Long sumTotal = altService.sumTotal();

		String sumString = String.valueOf(sumTotal);

		return sumString;
	}
	

	// 計算總未讀 alerts 數量
	@Hibernate
	@RequestMapping(path = "/14/UnReadSum", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String showUnReadSum() {
		Long sumAlertsUnRead = altService.sumAlertsUnRead();

		String sumAlertsUnReadString = String.valueOf(sumAlertsUnRead);
		
		if (sumAlertsUnReadString == "null") {
			sumAlertsUnReadString = "0";
		}

		return sumAlertsUnReadString;
	}

	// 列出使用者申訴內容 (AlertsCenterCRUD.jsp 中跳轉到每項申訴頁面 (ShowCustomerIssue.jsp) 的跳轉 ctrl)
	@Hibernate
	@RequestMapping(path = "/14/ShowCustomerIssue")
	public String ShowCustomerIssue(Model m, @RequestParam(name = "alertNo") int alertNo) {
		Alerts alert = altService.select(alertNo);
		alert.setStatus(0);
		Alerts insert = altService.insert(alert);
		m.addAttribute("alert", insert);

		return "14/alertCenter/ShowCustomerIssue";

	}

	// 跳轉到給使用者填寫申訴內容的表單的 ctrl
	@RequestMapping(path = "/14/WriteIssueForm") // TODO 還沒有設ISSUE，跟處理的路徑
	public String WriteIssueForm(Model m, HttpSession session, @RequestParam(name = "issueId") int issueId) {

		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
			// TODO 記得設定登入完後跳轉回來
		}

		Alerts al = new Alerts();
		al.setMemberId(mb.getId());
		al.setMemberName(mb.getName());
		al.setIssueId(issueId);
		m.addAttribute("al", al);
		return "14/alertCenter/IssueForm";
	}

	// Alert 轉接站，藉判斷 issue 跳轉至適合的處理頁面 (ShowCustomerIssue.jsp 中的 [ 前往處理 ] 按鈕會導向此
	// ctrl)
	@Hibernate
	@RequestMapping(path = "/14/AlertsDispatcher")
	public String AlertsDispatcher(@RequestParam(name = "issue") String issue,
			@RequestParam(name = "issueId") String issueId) {

		if ("得藝洋行商品退換貨".equals(issue)) {

			// 由於是退換貨，此處直接跳轉至後台管理商品頁面的該項訂單
			return "redirect:/14/MbOrderListSelect.ctrl?orderListID=" + issueId;

		} else if ("得藝良票退票".equals(issue)) {

			return "redirect:/04/Cms/SearchOneOrder.ctrl?orderid="+issueId;
			
		} else if ("留言檢舉".equals(issue)) {

			return "redirect:/14/ShowAllMessageBoardList.ctrl";
		}

		return "14/14_NewIndex";
	}

	// 商品退貨 Alert 生成
	@Hibernate
	@RequestMapping(path = "/14/ShopAPAlerts")
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
		String icon = "fas fa-file-alt text-white"; // 設定 alters 的 icon 樣式
		String type = "icon-circle bg-primary"; // 設定 icon 樣式背景色
		String contentAC = "會員" + mb.getRealName() + "送來退換貨的請求"; // 設定在 alerts 顯示的一行字訊息

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

		return "14/14_NewIndex";
	}

	
}
