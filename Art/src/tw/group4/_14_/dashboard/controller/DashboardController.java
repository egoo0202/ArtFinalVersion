package tw.group4._14_.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tw.group4._14_.back.dao.AlertsService;
import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4.util.Hibernate;

@Controller
public class DashboardController {

	@Autowired
	public DashboardService dbService;

	@Autowired
	public AlertsService altService;
	
	// 獲取售票總金額
	@Hibernate
	@RequestMapping(path = "/14/showsumTicketTotal", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String showsumTicketTotal() {

//		Long sumTicketTotal = dbService.sumTicketTotal();

		String value = String.valueOf(dbService.sumTicketTotal());
		
		if ("null".equals(value)) {
			value = "0";
		}

		return value;
	}
	
	// 獲取註冊會員總人數
		@Hibernate
		@RequestMapping(path = "/14/showSumMember", produces = "application/text; charset=utf-8")
		@ResponseBody
		public String showSumMember() {

			Long sumMember = dbService.sumMember();

			String value = String.valueOf(sumMember);

			return value;
		}
		
	// 獲取餐廳預約總筆數
		@Hibernate
		@RequestMapping(path = "/14/showResturantOrder", produces = "application/text; charset=utf-8")
		@ResponseBody
		public String showResturantOrder() {

			Long sum = dbService.sumRestaurantOrder();

			String value = String.valueOf(sum);

			return value;
		}
	

	// 計算各入口點擊次數
	@Hibernate
	@RequestMapping(path = "/14/barChart", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String barChart() {
		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String action = String.valueOf(dbService.sumTicketClick());
//		String action = "10";
		if ("null".equals(action)) {
			action = "0";
		}
		String shop = String.valueOf(dbService.sumShopClick());
//		String shop = "20";
		if ("null".equals(shop)) {
			shop = "0";
		}
		
		String restaurant = String.valueOf(dbService.sumRestaurantClick());
//		String restaurant = "5";
		if ("null".equals(restaurant)) {
			restaurant = "0";
		}
		
		String map = String.valueOf(dbService.sumMapClick());
		if ("null".equals(map)) {
			map = "0";
		}
		
		String near = String.valueOf(dbService.sumNearbyClick());
		if ("null".equals(near)) {
			near = "0";
		}
		
		String course = String.valueOf(dbService.sumCourseClick());
//		String course = "11";
		if ("null".equals(course)) {
			course = "0";
		}
		
		String artist = String.valueOf(dbService.sumArtistClick());
//		String artist = "12";
		if ("null".equals(artist)) {
			artist = "0";
		}

		arrayList.add(action);
		arrayList.add(shop);
		arrayList.add(restaurant);
		arrayList.add(near);
		arrayList.add(map);
		arrayList.add(course);
		arrayList.add(artist);

		Gson gson = new Gson();
		String json = gson.toJson(arrayList);

		return json;
	}

	// 計算各收費管道營收
	@Hibernate
	@RequestMapping(path = "/14/pieChart", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String pieChart() {

		Long sumAPshopTotal = altService.sumTotal();
		
		ArrayList<String> arrayList = new ArrayList<String>();
//		String action = "1000";
		String shop = String.valueOf(sumAPshopTotal);
//		String restaurant = "180";
//		String course = "130";
//		String artist = "280";

		String adTotal = String.valueOf(dbService.sumRestaurantAdTotal());
		if ("null".equals(adTotal)) {
			adTotal = "0";
		}
		
		String chTotal = String.valueOf(dbService.sumRestaurantChTotal());
		if ("null".equals(chTotal)) {
			chTotal = "0";
		}
		
		int adult = Integer.parseInt(String.valueOf(adTotal));
		int child = Integer.parseInt(String.valueOf(chTotal));
		
		arrayList.add(String.valueOf(dbService.sumTicketTotal()));
		arrayList.add(shop);
		arrayList.add(String.valueOf(dbService.sumCourseTotal()));
		arrayList.add(String.valueOf(dbService.sumArtistTotal()));
		arrayList.add(Integer.toString((adult*650+child*350)));

		Gson gson = new Gson();
		String json = gson.toJson(arrayList);

		return json;
	}

}
