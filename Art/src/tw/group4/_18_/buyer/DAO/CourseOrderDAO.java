package tw.group4._18_.buyer.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._18_.buyer.model.CourseOrders;
import tw.group4._18_.seller.model.Course;

@Repository("OrderDAO")
public class CourseOrderDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public CourseOrderDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Course> customerSelectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Course> query = session.createQuery("From Course", Course.class);
		List<Course> list = query.list();
		return list;
	}

	
	public void insertOrder(CourseOrders co) {
		Session session = sessionFactory.getCurrentSession();
		session.save(co);
	}

	
	public List<CourseOrders> getcoOrder() {
		Session session = sessionFactory.getCurrentSession();
		Query<CourseOrders> query = session.createQuery("From CourseOrders", CourseOrders.class);
		List<CourseOrders> list = query.list();
		return list;
	}
	
	
//	public List<CourseOrders> getcoOrderByONo(int orderNoCo) {
//		Session session = sessionFactory.getCurrentSession();
//		Query<CourseOrders> query = session.createQuery("From CourseOrders cos WHERE cos.orderNoCo = " + orderNoCo, CourseOrders.class);
//		List<CourseOrders> list = query.list();
//		return list;
//	}
	
	public CourseOrders getcoOrderByONo(int orderNoCo) {
		Session session = sessionFactory.getCurrentSession();
		CourseOrders courseOrders = session.get(CourseOrders.class, orderNoCo);
		System.out.println(courseOrders);
		System.out.println(orderNoCo);
		return courseOrders;
	}

	public List<CourseOrders> getcoOrderByMId(String memberId) {
		Session session = sessionFactory.getCurrentSession();
		Query<CourseOrders> query = session.createQuery("From CourseOrders cos WHERE cos.memberId = '"+memberId+"'", CourseOrders.class);
		List<CourseOrders> list = query.list();
		return list;
	}
	
	public boolean deleteOrder(int orderNoCo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orderNoCo);
		return true;
	}

	


}
