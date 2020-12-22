package tw.group4._14_.front.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.OrderItemBeanAP;


@Repository("OrderItemDaoImpl")
public class OrderItemDaoImpl {
	private SessionFactory sessionFactory;
	
	@Autowired
	public OrderItemDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean updateProductStock(OrderItemBeanAP oibAP) {

		System.out.println("進入 updateProductStock");
		
		String productTitle = oibAP.getOrderNameAP();
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "Select ap.productNum From ARTProduct ap WHERE ap.productTitle = '"+productTitle+"'";
		String sqlId = "Select ap.productId From ARTProduct ap WHERE ap.productTitle = '"+productTitle+"'";

		Query query = session.createQuery(sql);
		Integer uni = (Integer)query.uniqueResult();
		
		Query queryId = session.createQuery(sqlId);
		String productId = (String)queryId.uniqueResult();
		
		ARTProduct result = session.get(ARTProduct.class, productId);
		
		int requestNum = oibAP.getProductNum();
		if (uni < requestNum) {
			
			
			return false;
		}else {
			result.setProductNum(uni-requestNum);
			
		}
		
		return true;
	}

}
