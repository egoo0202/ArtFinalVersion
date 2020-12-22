package tw.group4._35_.routePlanning.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MyJourneyDao {

	private SessionFactory sessionFactory;

	@Autowired
	public MyJourneyDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Boolean insertMyJourney(MyJourney myJourney) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(myJourney);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<MyJourney> getMyJourney(String memberName) {
		Session session = sessionFactory.getCurrentSession();

		Query<MyJourney> query = session.createQuery("From MyJourney where memberName = :name", MyJourney.class);
		query.setParameter("name", memberName);
		List<MyJourney> list = query.list();

		return list;
	}

	public boolean deleteJourney(String id) {
		Session session = sessionFactory.getCurrentSession();

		Query<MyJourney> query = session.createQuery("From MyJourney where id= :id", MyJourney.class);
		query.setParameter("id", Integer.valueOf(id));
		List<MyJourney> list = query.list();

		if (list.size() != 0) {
			for (MyJourney item : list)
				session.delete(item);
			return true;
		}

		return false;
	}

	public boolean updateJourney(MyJourney myJourney) {
		Session session = sessionFactory.getCurrentSession();

		Query<MyJourney> query = session.createQuery("From MyJourney where id= :id", MyJourney.class);
		query.setParameter("id", myJourney.getId());
		List<MyJourney> list = query.list();
		if (list.size() != 0) {
			myJourney.setLat(list.get(0).getLat());
			myJourney.setLon(list.get(0).getLon());
			session.detach(list.get(0));
			session.update(myJourney);
			return true;
		}
		return false;
	}

}
