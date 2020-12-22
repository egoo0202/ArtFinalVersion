package tw.group4._14_.front.model.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.front.model.OrderListBeamAP;


@Repository("OrderDaoImpl")
public class OrderDaoImpl {

	private SessionFactory sessionFactory;
	
	@Autowired
	public OrderDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insertOrder(OrderListBeamAP olbAP) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(olbAP);
		
	}
	
	public List<OrderListBeamAP> getCustomerOrder(String memberID){
		System.out.println("memberID:"+memberID);
		Session session = sessionFactory.getCurrentSession();
		Query queryList = session.createQuery("From OrderListBeamAP olb WHERE olb.memberID = '"+memberID+"'", OrderListBeamAP.class);
		
		List<OrderListBeamAP> list = queryList.list();
		return list;
	}
	
	public OrderListBeamAP selectOrder(int orderNoAP) {
		Session session = sessionFactory.getCurrentSession();
		OrderListBeamAP orderListBeamAP = session.get(OrderListBeamAP.class, orderNoAP);
//		return session.get(OrderItemBeanAP.class, orderListBeamAP.getOrderNoAP());
		return orderListBeamAP;
	}
	
	
}
