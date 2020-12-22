package tw.group4._03_.cms.shop.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("creativeShopDAO")
public class CreativeShopDAO {

	// @Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFacory;

	@Autowired
	public CreativeShopDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	public boolean checkShopId(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);

		if (result != null) {
			return true;
		}
		return false;
	}
//
//	public boolean checkReservation(int shopId) {
//		Session session = sessionFacory.getCurrentSession();
//		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);
//
//		if (result.getReservation() != null) {
//			return true;
//		}
//		return false;
//	}

	public CreativeShopBean insert(CreativeShopBean bean) {
		Session session = sessionFacory.getCurrentSession();
		session.save(bean);
		return bean;
	}

	public CreativeShopBean select(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(CreativeShopBean.class, shopId);
	}

	public List<CreativeShopBean> selectByShopId(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where shopId = " + shopId + " ",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	// 5 ==========================

	public List<CreativeShopBean> selectByShopName(String shopName) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session
				.createQuery("From CreativeShopBean where shopName like '%" + shopName + "%' ", CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public List<CreativeShopBean> selectByMemberId(int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where memberId = " + memberId + " ",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}
	
	public List<CreativeShopBean> selectByShopNameAndMemberId(String shopName, int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where shopName like '%" + shopName + "%' and memberId = " + memberId + " ",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public List<CreativeShopBean> selectAll() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean", CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public List<CreativeShopBean> selectByReservation() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where reservation = 1",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}
	
	// 10 ==========================
	
	public List<CreativeShopBean> selectByMemberIdAndReservation(int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where memberId = " + memberId + " and reservation = 1",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}
	
	public List<CreativeShopBean> selectByShopNameAndReservation(String shopName) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where shopName like '%" + shopName + "%' and reservation = 1",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}
	
	public List<CreativeShopBean> selectByShopNameAndMemberIdAndReservation(String shopName, int memberId) {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean where shopName like '%" + shopName + "%'and memberId = " + memberId + " and reservation = 1",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.list();
		return list;
	}

	public CreativeShopBean update(int shopId, String shopName, int memberId, String image, String intro,
			String cityName, String address, String openTime, String phone, String fax, String email, String facebook,
			String website, int clicks, byte[] reservation) {

		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);
		if (result != null) {
			result.setShopName(shopName);
			result.setMemberId(memberId);
			result.setImage(image);
			result.setIntro(intro);

			result.setCityName(cityName);
			result.setAddress(address);
			result.setOpenTime(openTime);
			result.setPhone(phone);
			result.setFax(fax);

			result.setEmail(email);
			result.setFacebook(facebook);
			result.setWebsite(website);
			result.setClicks(clicks);
			result.setReservation(reservation);

		}
		return result;
	}

	public boolean delete(int shopId) {
		Session session = sessionFacory.getCurrentSession();
		CreativeShopBean result = session.get(CreativeShopBean.class, shopId);

		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	// 15 ==========================
	
	public List<CreativeShopBean> select16OrderByShopId() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean order by shopId DESC",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.setMaxResults(16).list();
		return list;
	}
	
	public List<CreativeShopBean> select16OrderByPopularity() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean order by clicks DESC",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.setMaxResults(16).list();
		return list;
	}
	
	public List<CreativeShopBean> select9OrderByPopularity() {
		Session session = sessionFacory.getCurrentSession();
		Query<CreativeShopBean> query = session.createQuery("From CreativeShopBean order by shopId DESC",
				CreativeShopBean.class);
		List<CreativeShopBean> list = query.setMaxResults(9).list();
		return list;
	}
	
}
