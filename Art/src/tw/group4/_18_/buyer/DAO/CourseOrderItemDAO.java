package tw.group4._18_.buyer.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._18_.buyer.model.CourseFront;
import tw.group4._18_.buyer.model.CourseOrderItems;

@Repository
public class CourseOrderItemDAO {
	private SessionFactory sessionFactory;
	
	@Autowired
	public CourseOrderItemDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean updateCourseNum(CourseOrderItems coi) {

		
		
		String coTitle = coi.getCourseTitle();
		
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "Select co.coNum From CourseFront co WHERE co.coTitle = '"+coTitle+"'";
		String sqlId = "Select co.coId From CourseFront co WHERE co.coTitle = '"+coTitle+"'";

		Query query = session.createQuery(sql);
		Integer uni = (Integer)query.uniqueResult();
		
		Query queryId = session.createQuery(sqlId);
		String coId = (String)queryId.uniqueResult();
		
		CourseFront result = session.get(CourseFront.class, coId);
		
		int requestNum = coi.getCourseNum();
		if (uni < requestNum) {
			
			
			return false;
		}else {
			result.setCoNum(uni-requestNum);
			
		}
		
		return true;
	}


}
