package tw.group4._14_.front.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.MessageBoardAP;
import tw.group4._14_.front.model.OrderListBeamAP;

@Repository("MessageBoardImplAP")
public class MessageBoardImplAP {

	
	private SessionFactory sessionFactory;

	@Autowired
	public MessageBoardImplAP(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public MessageBoardAP insert(MessageBoardAP mb) {
		Session session = sessionFactory.getCurrentSession();
		session.save(mb);
		return mb;
	}
	
	public MessageBoardAP updateMessage(MessageBoardAP mb) {
		Session session = sessionFactory.getCurrentSession();
		session.update(mb);
		return mb;
	}
	
	
	public List<MessageBoardAP> selectPdBoardAPs(Integer apId) {
		Session session = sessionFactory.getCurrentSession();
		Query<MessageBoardAP> query = session.createQuery("From MessageBoardAP mb WHERE mb.apId = '"+ apId +"' ORDER BY mb.time DESC", MessageBoardAP.class);
		List<MessageBoardAP> list = query.list();
		return list;

	}
	
	public List<MessageBoardAP> selectAllPdBoardAPs() {
		Session session = sessionFactory.getCurrentSession();
		Query<MessageBoardAP> query = session.createQuery("From MessageBoardAP mb ORDER BY mb.time", MessageBoardAP.class);
		List<MessageBoardAP> list = query.list();
		return list;
	}
	
	public Long countMessageNum(int apId) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "Select count (mb.apId) From MessageBoardAP mb WHERE mb.apId = '"+ apId +"'";
		Query query = session.createQuery(sql);
		Long uniqueResult =(Long) query.uniqueResult();
		
		
		return uniqueResult;

	}
	
	public boolean deleteMessage(int mNo) {
		Session session = sessionFactory.getCurrentSession();
		MessageBoardAP result = session.get(MessageBoardAP.class, mNo);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
	
	public MessageBoardAP selectMessage (int mNo) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(MessageBoardAP.class, mNo);
	}
	
	
}
