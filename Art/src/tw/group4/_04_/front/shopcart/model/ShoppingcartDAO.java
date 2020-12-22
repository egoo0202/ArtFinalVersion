package tw.group4._04_.front.shopcart.model;

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

import tw.group4._04_.back.cmsAct.model.ShowBean2;

@Repository("ShoppingcartDAO")
public class ShoppingcartDAO {

	private SessionFactory sessionFacory;
	private Session session;

//	public SeatBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public ShoppingcartDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

	// 新增
	public Shoppingcart insert(Shoppingcart shoppingcart) {
		Session session = sessionFacory.getCurrentSession();
//		SeatBean resultBean = session.get(SeatBean.class, SeatBean.getACT_NO());
//		if (resultBean == null) {
		session.save(shoppingcart);
		return shoppingcart;
//		}
//		return null;
	}

	// 訂單編號生成
	public String getOrderIdByTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newDate = sdf.format(new Date());
		String result = "";
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			result += random.nextInt(10);
		}
		return newDate + result;
	}

	public int insert4Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		String Seat4 = seats[3];
		Session session = sessionFacory.getCurrentSession();
		Query query = session.createQuery("update SEAT st set "
				+"st."+Seat1+"=1" 
				+"st."+Seat2+"=1" 
				+"st."+Seat3+"=1" 
				+"st."+Seat4+"=1" 
				+ "where name="+actno);
		query.executeUpdate();		
		return (Integer) null;
	}

	public int insert3Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		String Seat3 = seats[2];
		return (Integer) null;
	}

	public int insert2Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		String Seat2 = seats[1];
		return (Integer) null;
	}

	public int insert1Seat(String[] seats,String actno) {
		String Seat1 = seats[0];
		return (Integer) null;
	}

//	// 查詢 //先將查詢結果放入MAP
//	public Map<String, Integer> select(String memberid) {
//		Session session = sessionFacory.getCurrentSession();
//		Shoppingcart shoppingcart = session.get(Shoppingcart.class, memberid);
//
//		Map<String, Integer> map = null;
//		return map;
//	}
//
//	// 修改
//	public Shoppingcart update(String memberid) {
//
//		Session session = sessionFacory.getCurrentSession();
//		Shoppingcart shoppingcart = session.get(Shoppingcart.class, memberid);
//
//		if (shoppingcart != null) {
////			SeatBean.setACT_TITLE(title);
////			SeatBean.setACT_CATEGORY(category);
////			SeatBean.setACT_LOCATION(locationName);
////			SeatBean.setACT_MAINUNIT(mainunit);
////			SeatBean.setACT_SHOWUNIT(showunit);
////			SeatBean.setACT_DESCRIPTION(description);
////			SeatBean.setACT_STARTDATE(startdate);
////			SeatBean.setACT_ENDDATE(enddate);
//		}
//
//		return shoppingcart;
//	}
//
//	// 刪除
//	public boolean delete(String memberid) {
//
//		Session session = sessionFacory.getCurrentSession();
//		Shoppingcart result = session.get(Shoppingcart.class, memberid);
//
//		if (result != null) {
//			session.delete(result);
//			return true;
//		}
//
//		return false;
//	}
//

//
//	// 查詢分類  開始日期排序
//	public List<Shoppingcart> selectOrderlist(String memberID) {
//		// "From ShowBean"為createQuery
//		//
//		Session session = sessionFacory.getCurrentSession();
//		Query<Shoppingcart> query = session.createQuery("From TICKETORDERLIST Order where Order.MEMBERID ="+memberID,Shoppingcart.class);
//		List<Shoppingcart> list = query.list();
//		return list;
//	}

}
