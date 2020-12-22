package tw.group4._03_.cms.restaurant.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.restaurant.model.RestaurantBean;
import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4.util.Hibernate;

@Controller
public class SearchRestaurant {

	@Autowired
	public RestaurantService rs;

	@Hibernate
	@RequestMapping(path = "/03/cms/restaurant/searchByDateTime.ctrl", method = RequestMethod.POST)
	public String searchByDateTime(@RequestParam(name = "dateTime") String dateTime, Model m) {

		System.out.println(dateTime);
		List<RestaurantBean> restaurantList = rs.selectByDateTime(dateTime);

		if (restaurantList.size() > 0) {
			RestaurantBean restaurant = restaurantList.get(0);
			int year = restaurant.getYear();
			int month = restaurant.getMonth();
			int day = restaurant.getDay();

			m.addAttribute("restaurantList", restaurantList);
			m.addAttribute("year", year);
			m.addAttribute("month", month);
			m.addAttribute("day", day);
		}

		return "03/cms_restaurant/search_single";
	}

}
