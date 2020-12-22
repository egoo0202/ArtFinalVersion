package tw.group4._18_.buyer.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._18_.buyer.model.CourseFront;

@Repository("CourseBeanDAOFront")
public class CourseBeanDAOMainFront {

	private SessionFactory sessionFactory;

	@Autowired
	public CourseBeanDAOMainFront(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<CourseFront> selectAllF() {
		Session session = sessionFactory.getCurrentSession();
		Query<CourseFront> query = session.createQuery("From CourseFront", CourseFront.class);
		List<CourseFront> list = query.list();
		return list;
	}
	
	
	public CourseFront selectF(String coId) {
		Session session = sessionFactory.getCurrentSession();
		Query<CourseFront> query = session.createQuery("From CourseFront where coId="+coId, CourseFront.class);
		CourseFront courseFront = query.uniqueResult();
		return courseFront;
		
//		return (CourseFront)session.get(CourseFront.class, coId);
	}
	
	
	//https://vimsky.com/zh-tw/examples/detail/java-method-org.hibernate.query.Query.setParameter.html
	public List<CourseFront> searchByWord(String searchWord){
		System.err.println(searchWord);
		Session session = sessionFactory.getCurrentSession();
		Query<CourseFront> querysbw = session.createQuery("From CourseFront where coTitle LIKE :searchWord ", CourseFront.class);
		querysbw.setParameter("searchWord", "%"+searchWord+"%");
		List<CourseFront> list = querysbw.list();
		return list;
	}
	
	
	public List<CourseFront> searchByType(String searchType){
		System.err.println(searchType);
		Session session = sessionFactory.getCurrentSession();
		Query<CourseFront> querysbt = session.createQuery("From CourseFront where coAct_Type= :searchType");
		querysbt.setParameter("searchType", ""+searchType+"");
		List<CourseFront> list = querysbt.list();
		return list;
	}
	
	
}