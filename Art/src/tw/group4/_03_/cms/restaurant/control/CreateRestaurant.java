package tw.group4._03_.cms.restaurant.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.restaurant.model.RestaurantBean;
import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4._03_.cms.util.CustomizedTypeConversion;
import tw.group4._03_.cms.util.GetDate;
import tw.group4.util.Hibernate;

@Controller
public class CreateRestaurant {

	@Autowired
	public RestaurantService rs;

	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/createRestaurantConfirm.ctrl", method = RequestMethod.POST)
	public String createRestaurantConfirm(@RequestParam(name = "year") String year,
			@RequestParam(name = "month") String month, Model m) {
		try {
			int intYear = Integer.parseInt(year);
			int intMonth = Integer.parseInt(month);

			// # 獲得當月的日期 #
			GetDate getDate = new GetDate();
			List<Integer> dayList = new ArrayList<Integer>();
			for (int i = 1; i <= getDate.getDaysByYearMonth(intYear, intMonth); i++) {
				dayList.add(i);
			}

			// 修改頁面顯示的月份資料
			if (month.equals("01")) {
				int newMonth = 1;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("02")) {
				int newMonth = 2;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("03")) {
				int newMonth = 3;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("04")) {
				int newMonth = 4;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("05")) {
				int newMonth = 5;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("06")) {
				int newMonth = 6;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("07")) {
				int newMonth = 7;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("08")) {
				int newMonth = 8;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("09")) {
				int newMonth = 9;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("10")) {
				int newMonth = 10;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("11")) {
				int newMonth = 11;
				m.addAttribute("newMonth", newMonth);
			} else if (month.equals("12")) {
				int newMonth = 12;
				m.addAttribute("newMonth", newMonth);
			} else {
				int newMonth = 1;
				m.addAttribute("newMonth", newMonth);
			}
			
			m.addAttribute("dayList", dayList);
			m.addAttribute("year", year);
			m.addAttribute("month", month);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "03/cms_restaurant/create_confirm";
	}

	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/createRestaurant.ctrl", method = RequestMethod.POST)
	public String createRestaurant(@RequestParam(name = "year") String year, @RequestParam(name = "month") String month, 
			@RequestParam(name = "newMonth") String newMonth,
			HttpServletRequest request, Model m) {
		// 處理傳過來的陣列資料
		String[] day = request.getParameterValues("day");
		String[] open = request.getParameterValues("open");
		String[] maximum = request.getParameterValues("maximum");

		String[] h09 = request.getParameterValues("h09");
		String[] h10 = request.getParameterValues("h10");
		String[] h11 = request.getParameterValues("h11");
		String[] h12 = request.getParameterValues("h12");
		String[] h13 = request.getParameterValues("h13");

		String[] h14 = request.getParameterValues("h14");
		String[] h15 = request.getParameterValues("h15");
		String[] h16 = request.getParameterValues("h16");
		String[] h17 = request.getParameterValues("h17");
		String[] h18 = request.getParameterValues("h18");

		String[] h19 = request.getParameterValues("h19");
		String[] h20 = request.getParameterValues("h20");
		String[] h21 = request.getParameterValues("h21");

		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);
		// # 獲得該月的日期天數 #
		GetDate getDate = new GetDate();

		try {
			for (int i = 0; i < getDate.getDaysByYearMonth(intYear, intMonth); i++) {

				RestaurantBean restaurant = new RestaurantBean();
				restaurant.setYear(Integer.parseInt(year));
				restaurant.setMonth(Integer.parseInt(month));
				restaurant.setDay(Integer.parseInt(day[i]));
				restaurant.setOpen(Integer.parseInt(open[i]));
				restaurant.setMaximum(Integer.parseInt(maximum[i]));

				switch (Integer.parseInt(day[i])) {
				case 1:
					String day01 = year + "-" + month + "-01";
					restaurant.setDateTime(day01);
					break;
				case 2:
					String day02 = year + "-" + month + "-02";
					restaurant.setDateTime(day02);
					break;
				case 3:
					String day03 = year + "-" + month + "-03";
					restaurant.setDateTime(day03);
					break;
				case 4:
					String day04 = year + "-" + month + "-04";
					restaurant.setDateTime(day04);
					break;
				case 5:
					String day05 = year + "-" + month + "-05";
					restaurant.setDateTime(day05);
					break;
				case 6:
					String day06 = year + "-" + month + "-06";
					restaurant.setDateTime(day06);
					break;
				case 7:
					String day07 = year + "-" + month + "-07";
					restaurant.setDateTime(day07);
					break;
				case 8:
					String day08 = year + "-" + month + "-08";
					restaurant.setDateTime(day08);
					break;
				case 9:
					String day09 = year + "-" + month + "-09";
					restaurant.setDateTime(day09);
					break;
				case 10:
					String day10 = year + "-" + month + "-10";
					restaurant.setDateTime(day10);
					break;
				case 11:
					String day11 = year + "-" + month + "-11";
					restaurant.setDateTime(day11);
					break;
				case 12:
					String day12 = year + "-" + month + "-12";
					restaurant.setDateTime(day12);
					break;
				case 13:
					String day13 = year + "-" + month + "-13";
					restaurant.setDateTime(day13);
					break;
				case 14:
					String day14 = year + "-" + month + "-14";
					restaurant.setDateTime(day14);
					break;
				case 15:
					String day15 = year + "-" + month + "-15";
					restaurant.setDateTime(day15);
					break;
				case 16:
					String day16 = year + "-" + month + "-16";
					restaurant.setDateTime(day16);
					break;
				case 17:
					String day17 = year + "-" + month + "-17";
					restaurant.setDateTime(day17);
					break;
				case 18:
					String day18 = year + "-" + month + "-18";
					restaurant.setDateTime(day18);
					break;
				case 19:
					String day19 = year + "-" + month + "-19";
					restaurant.setDateTime(day19);
					break;
				case 20:
					String day20 = year + "-" + month + "-20";
					restaurant.setDateTime(day20);
					break;
				case 21:
					String day21 = year + "-" + month + "-21";
					restaurant.setDateTime(day21);
					break;
				case 22:
					String day22 = year + "-" + month + "-22";
					restaurant.setDateTime(day22);
					break;
				case 23:
					String day23 = year + "-" + month + "-23";
					restaurant.setDateTime(day23);
					break;
				case 24:
					String day24 = year + "-" + month + "-24";
					restaurant.setDateTime(day24);
					break;
				case 25:
					String day25 = year + "-" + month + "-25";
					restaurant.setDateTime(day25);
					break;
				case 26:
					String day26 = year + "-" + month + "-26";
					restaurant.setDateTime(day26);
					break;
				case 27:
					String day27 = year + "-" + month + "-27";
					restaurant.setDateTime(day27);
					break;
				case 28:
					String day28 = year + "-" + month + "-28";
					restaurant.setDateTime(day28);
					break;
				case 29:
					String day29 = year + "-" + month + "-29";
					restaurant.setDateTime(day29);
					break;
				case 30:
					String day30 = year + "-" + month + "-30";
					restaurant.setDateTime(day30);
					break;
				case 31:
					String day31 = year + "-" + month + "-31";
					restaurant.setDateTime(day31);
					break;
				default:
					System.out.println("行事曆日期switch錯誤");
					break;
				}

//				// 假設switch錯誤時的備用 if判斷式
//				// 將得到的該月天數轉換成 input type="date"
//				// 輸出格式 YYYY/MM/DD
//				if(Integer.parseInt(day[i]) == 1) { 
//		        	String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//			    }else if (Integer.parseInt(day[i]) ==) {
//			    	String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//		        	
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (Integer.parseInt(day[i]) ==) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else if (condition) {
//					String dateTime = year+"-"+month+"-01";
//		        	restaurant.setDateTime(dateTime);
//				}else {
//					
//				}

				// #處理營業時段
				// h09
				if (CustomizedTypeConversion.customizedParseInt(h09[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH09(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH09(-1);
				}

				// h10
				if (CustomizedTypeConversion.customizedParseInt(h10[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH10(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH10(-1);
				}

				// h11
				if (CustomizedTypeConversion.customizedParseInt(h11[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH11(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH11(-1);
				}

				// h12
				if (CustomizedTypeConversion.customizedParseInt(h12[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH12(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH12(-1);
				}

				// h13
				if (CustomizedTypeConversion.customizedParseInt(h13[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH13(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH13(-1);
				}

				// h14
				if (CustomizedTypeConversion.customizedParseInt(h14[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH14(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH14(-1);
				}

				// h15
				if (CustomizedTypeConversion.customizedParseInt(h15[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH15(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH15(-1);
				}

				// h16
				if (CustomizedTypeConversion.customizedParseInt(h16[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH16(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH16(-1);
				}

				// h17
				if (CustomizedTypeConversion.customizedParseInt(h17[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH17(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH17(-1);
				}

				// h18
				if (CustomizedTypeConversion.customizedParseInt(h18[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH18(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH18(-1);
				}

				// h19
				if (CustomizedTypeConversion.customizedParseInt(h19[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH19(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH19(-1);
				}

				// h20
				if (CustomizedTypeConversion.customizedParseInt(h20[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH20(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH20(-1);
				}

				// h21
				if (CustomizedTypeConversion.customizedParseInt(h21[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					restaurant.setH21(Integer.parseInt(maximum[i]));
				} else {
					restaurant.setH21(-1);
				}

				rs.insert(restaurant);
			}
			String restaurantCreateMsg = year + "年 " + newMonth + "月營業時間表";
			m.addAttribute("restaurantCreateMsg", restaurantCreateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String restaurantErrorMsg = year + "年 " + newMonth + "月營業時間表建立失敗，請重試";
			m.addAttribute("restaurantErrorMsg", restaurantErrorMsg); // 回傳錯誤訊息
		}
		return "03/cms_restaurant/create_return";
	}

}
