package tw.group4._03_.cms.reservation.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository("shopReservationDAO")
public class ShopReservationDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public ShopReservationDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public boolean checkReservationNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			return true;
		}
		return false;
	}
	
	public ShopReservationBean insert(ShopReservationBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public ShopReservationBean select(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(ShopReservationBean.class, reservationNo);

	}
	
	public List<ShopReservationBean> selectByNo(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where reservationNo = " + reservationNo + " ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByMemberId(int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where memberId = "+memberId+"",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByMemberName(String memberName) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where memberName '%"+ memberName + "%'",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectByDateTime(String dateTime) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where dateTime = " + dateTime + " ",
				ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}
	
	public List<ShopReservationBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean", ShopReservationBean.class);
		List<ShopReservationBean> list = query.list();
		return list;
	}

	public ShopReservationBean update(
			int reservationNo, 
			int memberId, 
			String memberName, 
			String customerName,
			String customerPhone,
			int adultsNum, 
			int childrenNum, 
			int amount, 
			String dateTime, 
			String time, 
			int payment,
			String note,
			int gender,
			String email,
			int purpose
			) {

		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);
		if (result != null) {
			result.setMemberId(memberId);
			result.setMemberName(memberName);
			result.setCustomerName(customerName);
			result.setCustomerPhone(customerPhone);
			
			result.setAdultsNum(adultsNum);
			result.setChildrenNum(childrenNum);
			result.setAmount(amount);
			result.setDateTime(dateTime);
			result.setTime(time);
			
			result.setPayment(payment);
			result.setNote(note);
			result.setGender(gender);
			result.setEmail(email);
			result.setPurpose(purpose);
		}
		return result;
	}

	public boolean delete(int reservationNo) {
		Session session = sessionFacory.getCurrentSession();
		ShopReservationBean result = session.get(ShopReservationBean.class, reservationNo);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	public boolean deleteByMemberIdAndDateAndTime(int memberId, String dateTime, String time) {
		Session session = sessionFacory.getCurrentSession();
		Query<ShopReservationBean> query = session.createQuery("From ShopReservationBean where memberId ="+memberId+" and dateTime ='"+dateTime+"'  and time ="+time+"",
				ShopReservationBean.class);			
		ShopReservationBean result = query.list().get(0);
		
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
}
