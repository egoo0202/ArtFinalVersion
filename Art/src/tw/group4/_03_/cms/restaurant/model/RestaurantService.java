package tw.group4._03_.cms.restaurant.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("restaurantService")
public class RestaurantService implements IRestaurantBean {

	@Autowired
	private RestaurantDAO restaurantDAO;
	
	@Override
	public RestaurantBean insert(RestaurantBean bean) {
		return restaurantDAO.insert(bean);
	}

	@Override
	public RestaurantBean selectByNo(int restaurantNo) {
		return restaurantDAO.selectByNo(restaurantNo);
	}

	@Override
	public List<RestaurantBean> selectAll() {
		return restaurantDAO.selectAll();
	}

	@Override
	public List<RestaurantBean> selectByDateTime(String dateTime) {
		return restaurantDAO.selectByDateTime(dateTime);
	}

	@Override
	public List<RestaurantBean> selectByYearMonth(int year, int month) {
		return restaurantDAO.selectByYearMonth(year, month);
	}

	@Override
	public List<RestaurantBean> selectByYearMonthDay(int year, int month, int day) {
		return restaurantDAO.selectByYearMonthDay(year, month, day);
	}

	@Override
	public RestaurantBean update(int restaurantNo, String dateTime, int year, int month, int day, int h09, int h10,
			int h11, int h12, int h13, int h14, int h15, int h16, int h17, int h18, int h19, int h20, int h21,
			int maximum, int open) {
		return restaurantDAO.update(restaurantNo, dateTime, year, month, day, h09, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19, h20, h21, maximum, open);
	}

	@Override
	public boolean delete(int restaurantNo) {
		return restaurantDAO.delete(restaurantNo);
	}

	@Override
	public boolean deleteByDateTime(String dateTime) {
		return restaurantDAO.deleteByDateTime(dateTime);
	}


}
