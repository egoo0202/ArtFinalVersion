package tw.group4._35_.csr.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._35_.geo.model.Activity;

@Repository
public class ActivityDao implements InterfaceActivityDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public ActivityDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//按藝文類別選取所有資訊
	@Override
	public List<Activity> selectDBtoActbyCat(int typeCode) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Activity> query = session.createQuery("From Activity where category= :category", Activity.class);
		query.setParameter("category", typeCode);
		List<Activity> list = query.list();			
		
		return list;
	}
	
	//選取所有資訊
	@Override
	public List<Activity> selectDBtoAct() {	 
		Session session = sessionFactory.getCurrentSession();
		
		Query<Activity> query = session.createQuery("From Activity", Activity.class);
		List<Activity> list = query.list();	
		
		return list;
	}
	
}
