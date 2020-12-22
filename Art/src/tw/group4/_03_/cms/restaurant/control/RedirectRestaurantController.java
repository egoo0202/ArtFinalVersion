package tw.group4._03_.cms.restaurant.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.group4._03_.cms.restaurant.model.RestaurantBean;
import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4.util.Hibernate;

@Controller
public class RedirectRestaurantController {

	@Autowired
	public RestaurantService rs;

	@RequestMapping(path = "/03/cms/restaurant/restaurantManagement", method = RequestMethod.GET)
	public String restaurantManagement(Model m) {
		
		return "03/cms_restaurant/restaurant_management";
	}
	
	@Hibernate
	@PostMapping(value = "/03/cms/restaurant/searchByYearMonth.ctrl", produces = { "application/json; charset=UTF-8" })
	public @ResponseBody List<RestaurantBean> searchByYearMonth(
			@RequestParam(name = "year") String year,
			@RequestParam(name = "month") String month) {

		System.out.println(year+"/"+month);
		List<RestaurantBean> restaurantList = rs.selectByYearMonth(Integer.parseInt(year), Integer.parseInt(month));
		return restaurantList;
	}

}
