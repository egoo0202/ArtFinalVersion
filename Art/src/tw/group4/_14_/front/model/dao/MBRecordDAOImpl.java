package tw.group4._14_.front.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.MBRecordBean;
import tw.group4._14_.front.model.MessageBoardAP;

@Repository("MBRecordDAOImpl")
public class MBRecordDAOImpl {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public MBRecordDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public MBRecordBean insertMBRecord(MBRecordBean mbid) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mbid);
		return mbid;
		
	}
	
	public MBRecordBean looking(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(MBRecordBean.class, id);
		
	}
	
	public int searchMessage (int mid, int apid) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From MBRecordBean mb where mb.mberId="+mid+" and mb.apid= "+apid;
		Query<MBRecordBean> createQuery = session.createQuery(hql);
		List<MBRecordBean> list = createQuery.list();
		int size = list.size();
		
		return size;
	}
	
	public MBRecordBean selectMessage (int mid, int apid) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "From MBRecordBean mb where mb.mberId="+mid+" and mb.apid= "+apid;
		Query<MBRecordBean> createQuery = session.createQuery(hql);
		MBRecordBean uniqueResult = createQuery.uniqueResult();
		
		return uniqueResult;
	}
	
	
	public MBRecordBean changeStatus(MBRecordBean pd) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pd);
		return pd;
	}
	
	
	public boolean deleteMBRecord(int mbId) {
		Session session = sessionFactory.getCurrentSession();
		MessageBoardAP result = session.get(MessageBoardAP.class, mbId);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}

	public int sumMessage (int apid) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT COUNT(1) From MessageBoardAP mb where mb.apid= "+apid;
		Query<MBRecordBean> createQuery = session.createQuery(hql);
		List<MBRecordBean> list = createQuery.list();
		int size = list.size();
		
		return size;
	}
}
