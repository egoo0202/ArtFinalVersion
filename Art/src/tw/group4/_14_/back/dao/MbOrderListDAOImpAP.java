package tw.group4._14_.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.OrderListBeamAP;

@Repository("MbOrderListDAOImpAP")
public class MbOrderListDAOImpAP {

	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
	public MbOrderListDAOImpAP(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public OrderListBeamAP select(int orderListID) {
		Session session = sessionFactory.getCurrentSession();
		return  session.get(OrderListBeamAP.class, orderListID);
	}
	
	public boolean delete(int orderListID) {
		Session session = sessionFactory.getCurrentSession();
		OrderListBeamAP result = session.get(OrderListBeamAP.class, orderListID);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
}
