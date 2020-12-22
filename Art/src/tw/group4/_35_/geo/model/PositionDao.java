package tw.group4._35_.geo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDao implements InterfacePositionDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public PositionDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Position> readAllToPt() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Position> query = session.createQuery("From Position", Position.class);
		List<Position> list = query.list();	

		return list;
	}
	
	@Override
	public List<Position> readNoNullToPt() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Position> query = session.createQuery("From Position where latitude > 0", Position.class);
		List<Position> list = query.list();	

		return list;
	}
	
	@Override
	public List<Position> selectByCategory(Integer Category){
		Session session = sessionFactory.getCurrentSession();
		
		Query<Position> query = session.createQuery("From Position where category =:category", Position.class);
		query.setParameter("category", Category);
		List<Position> list = query.list();	

		return list;
	}

}
