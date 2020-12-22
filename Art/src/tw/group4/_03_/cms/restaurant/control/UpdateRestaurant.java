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
import tw.group4.util.Hibernate;

@Controller
public class UpdateRestaurant {

	@Autowired
	public RestaurantService rs;

	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/updateRestaurantConfirm.ctrl", method = RequestMethod.POST)
	public String updateRestaurantConfirm(@RequestParam(name = "newMonth") String newMonth, HttpServletRequest request,
			Model m) {
		try {
			List<RestaurantBean> restaurantList = new ArrayList<RestaurantBean>();

			String[] restaurantNo = request.getParameterValues("restaurantNo");
			// #回傳該月行事曆資料
			for (String no : restaurantNo) {
				int intNo = Integer.parseInt(no);
				RestaurantBean restaurantBean = rs.selectByNo(intNo);
				restaurantList.add(restaurantBean);
			}

			m.addAttribute("newMonth", newMonth);
			m.addAttribute("restaurantList", restaurantList);
			m.addAttribute("year", restaurantList.get(0).getYear());
			m.addAttribute("month", restaurantList.get(0).getMonth());

		} catch (Exception e) {
			e.printStackTrace();
			String restaurantUpdateMsg = "系統錯誤，請回到上一頁重試";
			m.addAttribute("restaurantUpdateMsg", restaurantUpdateMsg); // 回傳錯誤訊息
		}
		return "03/cms_restaurant/update_confirm";
	}

	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/updateRestaurant.ctrl", method = RequestMethod.POST)
	public String updateRestaurant(@RequestParam(name = "newMonth") String newMonth, HttpServletRequest request, Model m) {

		String[] restaurantNo = request.getParameterValues("restaurantNo");

		String[] oh09 = request.getParameterValues("oh09");
		String[] oh10 = request.getParameterValues("oh10");
		String[] oh11 = request.getParameterValues("oh11");
		String[] oh12 = request.getParameterValues("oh12");
		String[] oh13 = request.getParameterValues("oh13");

		String[] oh14 = request.getParameterValues("oh14");
		String[] oh15 = request.getParameterValues("oh15");
		String[] oh16 = request.getParameterValues("oh16");
		String[] oh17 = request.getParameterValues("oh17");
		String[] oh18 = request.getParameterValues("oh18");

		String[] oh19 = request.getParameterValues("oh19");
		String[] oh20 = request.getParameterValues("oh20");
		String[] oh21 = request.getParameterValues("oh21");
		String[] maximum = request.getParameterValues("maximum");
		String[] open = request.getParameterValues("open");

		try {
			// 得到年份
			RestaurantBean rb = rs.selectByNo(Integer.parseInt(restaurantNo[0]));
			int year = rb.getYear();					
					
			for (int i = 0; i < restaurantNo.length; i++) {

				int h09;
				int h10;
				int h11;
				int h12;
				int h13;
				int h14;
				int h15;
				int h16;
				int h17;
				int h18;
				int h19;
				int h20;
				int h21;

				// #處理營業時段
				// h09
				if (CustomizedTypeConversion.customizedParseInt(oh09[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h09 = Integer.parseInt(maximum[i]);
				} else {
					h09 = -1;
				}
				// h10
				if (CustomizedTypeConversion.customizedParseInt(oh10[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h10 = Integer.parseInt(maximum[i]);
				} else {
					h10 = -1;
				}
				// h11
				if (CustomizedTypeConversion.customizedParseInt(oh11[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h11 = Integer.parseInt(maximum[i]);
				} else {
					h11 = -1;
				}
				// h12
				if (CustomizedTypeConversion.customizedParseInt(oh12[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h12 = Integer.parseInt(maximum[i]);
				} else {
					h12 = -1;
				}
				// h13
				if (CustomizedTypeConversion.customizedParseInt(oh13[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h13 = Integer.parseInt(maximum[i]);
				} else {
					h13 = -1;
				}
				// h14
				if (CustomizedTypeConversion.customizedParseInt(oh14[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h14 = Integer.parseInt(maximum[i]);
				} else {
					h14 = -1;
				}
				// h15
				if (CustomizedTypeConversion.customizedParseInt(oh15[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h15 = Integer.parseInt(maximum[i]);
				} else {
					h15 = -1;
				}
				// h16
				if (CustomizedTypeConversion.customizedParseInt(oh16[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h16 = Integer.parseInt(maximum[i]);
				} else {
					h16 = -1;
				}
				// h17
				if (CustomizedTypeConversion.customizedParseInt(oh17[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h17 = Integer.parseInt(maximum[i]);
				} else {
					h17 = -1;
				}
				// h18
				if (CustomizedTypeConversion.customizedParseInt(oh18[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h18 = Integer.parseInt(maximum[i]);
				} else {
					h18 = -1;
				}
				// h19
				if (CustomizedTypeConversion.customizedParseInt(oh19[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h19 = Integer.parseInt(maximum[i]);
				} else {
					h19 = -1;
				}
				// h20
				if (CustomizedTypeConversion.customizedParseInt(oh20[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h20 = Integer.parseInt(maximum[i]);
				} else {
					h20 = -1;
				}
				// h21
				if (CustomizedTypeConversion.customizedParseInt(oh21[i]) == 1 && Integer.parseInt(open[i]) == 1) {
					h21 = Integer.parseInt(maximum[i]);
				} else {
					h21 = -1;
				}
				
				// 獲取該月某天的營業時間表;
				RestaurantBean restaurant = rs.selectByNo(Integer.parseInt(restaurantNo[i]));
				
				rs.update(Integer.parseInt(restaurantNo[i]), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), h09, h10, h11, h12, h13, h14, h15, h16,
						h17, h18, h19, h20, h21, Integer.parseInt(maximum[i]), Integer.parseInt(open[i]));
				
				System.out.println(restaurant.getMonth()+"月"+ restaurant.getDay()+"日");
			}
			
			String restaurantUpdateMsg = year + "年 " + newMonth + "月營業時間表";
			m.addAttribute("restaurantUpdateMsg", restaurantUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
			
			String restaurantErrorMsg = newMonth + "月營業時間表修改失敗";
			m.addAttribute("restaurantErrorMsg", restaurantErrorMsg); // 回傳錯誤訊息
		}
		return "03/cms_restaurant/update_return";
	}

}
