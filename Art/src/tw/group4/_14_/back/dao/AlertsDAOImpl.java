package tw.group4._14_.back.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.Alerts;
import tw.group4._14_.front.model.OrderListBeamAP;

@Repository("AlertsDAOImpl")
public class AlertsDAOImpl {
	

	private SessionFactory sessionFactory;
	
	@Autowired
	public AlertsDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Alerts select(int alertsNo) {
		Session session = sessionFactory.getCurrentSession();
		return  session.get(Alerts.class, alertsNo);
	}
	
	public List<Alerts> selectPartAlerts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Alerts> query = session.createQuery("From Alerts ac ORDER BY ac.time DESC", Alerts.class);
		query.setMaxResults(5);
		List<Alerts> list = query.list();
		return list;
	}
	
	public List<Alerts> selectAllAlerts() {
		Session session = sessionFactory.getCurrentSession();
		Query<Alerts> query = session.createQuery("From Alerts ac ORDER BY ac.time DESC", Alerts.class);
		List<Alerts> list = query.list();
		return list;
	}
	
	
	
	public Alerts insert(Alerts al) {
		Session session = sessionFactory.getCurrentSession();
		session.save(al);
		return al;
	}
	
	public boolean deleteAlerts(int alertsNo) {
		Session session = sessionFactory.getCurrentSession();
		Alerts result = session.get(Alerts.class, alertsNo);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
	public Alerts update(Alerts al) {
		Session session = sessionFactory.getCurrentSession();
		session.update(al);
		return al;
	}
	
	
	public Long sumTotal() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ap.totalAmountAP) From OrderListBeamAP ap";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long)createQuery.uniqueResult();
		return totaLong;
	}
	
	public Long sumMessageAP() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT COUNT(*) FROM MessageBoardAP";
		Query createQuery = session.createQuery(sql);
		Long count = (Long)createQuery.uniqueResult();
		return count;
	}
	
	public Long sumAlertsUnRead() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(al.status) FROM Alerts al";
		Query createQuery = session.createQuery(sql);
		Long count = (Long)createQuery.uniqueResult();
		return count;
	}
	
}
