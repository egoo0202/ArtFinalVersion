package tw.group4._14_.index.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;

@Repository("IndexDaoImpl")
public class IndexDaoImpl {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public IndexDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//查詢洋行熱門商品
	public List<ARTProduct> selectShopHot() {
		Session session = sessionFactory.getCurrentSession();
		Query<ARTProduct> query = session.createQuery("From ARTProduct ap ORDER BY ap.productScore DESC", ARTProduct.class);
		query.setMaxResults(3);
		List<ARTProduct> list = query.list();
		return list;
	}
	
	public List<ARTProduct> selectShopHomeHot() {
		Session session = sessionFactory.getCurrentSession();
		Query<ARTProduct> query = session.createQuery("From ARTProduct ap ORDER BY ap.productScore DESC where ap.productType='cook' ", ARTProduct.class);
		query.setMaxResults(3);
		List<ARTProduct> list = query.list();
		return list;
	}

}
