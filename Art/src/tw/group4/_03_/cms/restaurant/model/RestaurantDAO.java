package tw.group4._03_.cms.restaurant.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("restaurantDAO")
public class RestaurantDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public RestaurantDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public RestaurantBean insert(RestaurantBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public RestaurantBean selectByNo(int restaurantNo) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(RestaurantBean.class, restaurantNo);
	}

	public List<RestaurantBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<RestaurantBean> query = session.createQuery("From RestaurantBean", RestaurantBean.class);
		List<RestaurantBean> list = query.list();
		return list;
	}

	public List<RestaurantBean> selectByDateTime(String dateTime) {
		Session session = sessionFacory.getCurrentSession();
		Query<RestaurantBean> query = session.createQuery("From RestaurantBean rb where rb.dateTime = '" + dateTime + "' ",
				RestaurantBean.class);
		List<RestaurantBean> list = query.list();
		return list;
	}

	public List<RestaurantBean> selectByYearMonth(int year, int month) {
		Session session = sessionFacory.getCurrentSession();
		Query<RestaurantBean> query = session.createQuery(
				"From RestaurantBean rb where rb.year =" + year + "  and rb.month =" + month + "order by rb.day ASC" + " ", RestaurantBean.class);
		List<RestaurantBean> list = query.list();
		return list;
	}

	public List<RestaurantBean> selectByYearMonthDay(int year, int month, int day) {
		Session session = sessionFacory.getCurrentSession();
		Query<RestaurantBean> query = session.createQuery(
				"From RestaurantBean rb where rb.year = " + year + "  and rb.month = " + month + " and rb.day = " + day + "order by rb.day ASC" + " ",
				RestaurantBean.class);
		List<RestaurantBean> list = query.list();
		return list;
	}

	public RestaurantBean update( 
			int restaurantNo, 
			String dateTime,
			int year, 
			int month, 
			int day, 
			
			int h09,
			int h10, 
			int h11, 
			int h12, 
			int h13,
			
			int h14,
			int h15,
			int h16,
			int h17,
			int h18,
			
			int h19,
			int h20,
			int h21,
			int maximum, 
			int open
			) {

		Session session = sessionFacory.getCurrentSession();
		RestaurantBean result = session.get(RestaurantBean.class, restaurantNo);
		if (result != null) {
			result.setDateTime(dateTime);
			result.setYear(year);
			result.setMonth(month);
			result.setDay(day);

			result.setH09(h09);
			result.setH10(h10);
			result.setH11(h11);
			result.setH12(h12);
			result.setH13(h13);
			
			result.setH14(h14);
			result.setH15(h15);
			result.setH16(h16);
			result.setH17(h17);
			result.setH18(h18);
			
			result.setH19(h19);
			result.setH20(h20);
			result.setH21(h21);
			result.setMaximum(maximum);
			result.setOpen(open);
		}
		return result;
	}

	public boolean delete(int restaurantNo) {
		Session session = sessionFacory.getCurrentSession();
		RestaurantBean result = session.get(RestaurantBean.class, restaurantNo);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
	public boolean deleteByDateTime(String dateTime) {
		Session session = sessionFacory.getCurrentSession();
		Query<RestaurantBean> query = session.createQuery("From RestaurantBean where dateTime = '" + dateTime + "' ",
				RestaurantBean.class);
		RestaurantBean result = query.list().get(0);
		
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
}
