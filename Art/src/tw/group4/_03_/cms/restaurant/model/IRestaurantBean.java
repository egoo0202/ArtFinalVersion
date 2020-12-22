package tw.group4._03_.cms.restaurant.model;

import java.util.List;

public interface IRestaurantBean {

	public RestaurantBean insert(RestaurantBean bean);

	public RestaurantBean selectByNo(int restaurantNo);

	public List<RestaurantBean> selectAll();

	public List<RestaurantBean> selectByDateTime(String dateTime);

	public List<RestaurantBean> selectByYearMonth(int year, int month);

	// 5 #======================================

	public List<RestaurantBean> selectByYearMonthDay(int year, int month, int day);

	public RestaurantBean update(
			int restaurantNo, String dateTime, int year, int month, int day, 
			int h09, int h10, int h11, int h12, int h13, 
			int h14, int h15, int h16, int h17, int h18, 
			int h19, int h20, int h21, int maximum, int open);

	public boolean delete(int restaurantNo);
	
	public boolean deleteByDateTime(String dateTime);
	
	// 10 #======================================

}
