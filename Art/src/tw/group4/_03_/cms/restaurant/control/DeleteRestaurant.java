package tw.group4._03_.cms.restaurant.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4.util.Hibernate;

@Controller
public class DeleteRestaurant {

	@Autowired
	public RestaurantService rs;
	
	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/deleteRestaurant.ctrl", method = RequestMethod.POST)
	public String deleteRestaurant(@RequestParam(name = "year") String year,
			@RequestParam(name = "newMonth") String newMonth, HttpServletRequest request, Model m) {

		try {
			String[] restaurantNo = request.getParameterValues("restaurantNo");
			
			for(String no : restaurantNo) {
				int intNo = Integer.parseInt(no);
				rs.delete(intNo);
			}
			
			String restaurantDeleteMsg = year + "年 " + newMonth + "月營業時間表";
			m.addAttribute("restaurantDeleteMsg", restaurantDeleteMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String restaurantErrorMsg = year + "年 " + newMonth + "月營業時間表刪除失敗，請重試";
			m.addAttribute("restaurantErrorMsg", restaurantErrorMsg); // 回傳錯誤訊息
		}
		return "03/cms_restaurant/delete_return";
	}

}
