package tw.group4._04_.front.orderlist.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._04_.front.seat.model.SeatBean;

@Repository("OrderlistDAO")
public class OrderlistDAO {

	private SessionFactory sessionFacory;
	private Session session;

//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public OrderlistDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

//	// 查詢單筆
//	public Orderlist searchBean(String orderid) {
//		Session session = sessionFacory.getCurrentSession();
//		return session.get(Orderlist.class, orderid);
//	}

	// 新增
	public Orderlist insert(Orderlist shoppingcart) {
		Session session = sessionFacory.getCurrentSession();
//		SeatBean resultBean = session.get(SeatBean.class, SeatBean.getACT_NO());
//		if (resultBean == null) {
		session.save(shoppingcart);
		return shoppingcart;
	}

//	// 查詢 //先將查詢結果放入MAP
//	public Map<String, Integer> select(String memberid) {
//		Session session = sessionFacory.getCurrentSession();
//		Orderlist shoppingcart = session.get(Orderlist.class, memberid);
//
//		Map<String, Integer> map = null;
//		return map;
//	}

	// 修改
	public Orderlist  updateOrderlist(String name,String email,String tel,String add,int orderPK) {

		Session session = sessionFacory.getCurrentSession();
		Orderlist orderlist = session.get(Orderlist.class, orderPK);

		
		if (orderlist != null) {
			orderlist.setNAME(name);
			orderlist.setEMAIL(email);
			orderlist.setTEL(tel);
			orderlist.setADDRESS(add);
		
		}

		return orderlist;
	}
	
	// 修改退票
		public Orderlist  updateStatus(int orderPK) {

			Session session = sessionFacory.getCurrentSession();
			Orderlist orderlist = session.get(Orderlist.class, orderPK);

			
			if (orderlist != null) {
				orderlist.setTOTALPRICE(0);
				orderlist.setSTATUS("已退票");;

			}

			return orderlist;
		}

	// 刪除
//	public boolean delete(String memberid) {
//
//		Session session = sessionFacory.getCurrentSession();
//		Orderlist result = session.get(Orderlist.class, memberid);
//
//		if (result != null) {
//			session.delete(result);
//			return true;
//		}
//
//		return false;
//	}

	// 查詢會員訂單
	public List<Orderlist> searchOrderlist(String memberID) {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<Orderlist> query = session.createQuery("From Orderlist Odr where Odr.MEMBERID =" + memberID,
				Orderlist.class);
		List<Orderlist> list = query.list();
		return list;
	}

	// 查詢會員訂單
	public List<Orderlist> searchOrderid(String orderid) {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<Orderlist> query = session.createQuery("From Orderlist Odr where Odr.ORDERID =" + orderid,
				Orderlist.class);
		List<Orderlist> list = query.list();
		return list;
	}
	
	// 查詢所有訂單
		public List<Orderlist> CmsOrderlist() {
			// "From ShowBean"為createQuery
			//
			Session session = sessionFacory.getCurrentSession();
			Query<Orderlist> query = session.createQuery("From Orderlist Odr ORDER BY Odr.ORDERID",
					Orderlist.class);
			List<Orderlist> list = query.list();
			return list;
		}
	
	

	// 刪除會員訂單
	public boolean deleteOrderid(String orderid) {
		Session session = sessionFacory.getCurrentSession();
		System.out.println("DAO:"+orderid);
//		String qryString ="delete from Orderlist Odr where Odr.ORDERID=:orderid";
//		Query query = session.createQuery(qryString);
//		query.setParameter("orderid", orderid);
		Query query = session.createQuery("delete from Orderlist Odr where Odr.ORDERID=" + orderid);
		query.executeUpdate();
		return true;
	}

}
