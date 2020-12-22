package tw.group4.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AOPHibernateMethods {

	SessionFactory sessionFactory;
	
//	怕找錯人就用@Qualifier(Bean名稱)
	@Autowired
	public AOPHibernateMethods(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//  設定@Pointcut的方法之一
//  設定所有DAO的class名稱到expression變數
//  class名稱*(..)，指的是裡面任何參數的方法
//	String expression = "execution(* tw.group4._35_.geo.model.PositionDao.*(..))"
//			+ " || execution(* tw.group4._35_.cms.model.EventSpaceDao.*(..))"
//			+ " || execution(* tw.group4._35_.csr.model.ActivityDao.*(..))"
//			+ " || execution(* tw.group4._35_.login.model.WebsiteMemberDao.*(..))"
//			+ " || execution(* tw.group4._03_.cms.calendar.model.ShopCalendarDAO.*(..))"
//			+ " || execution(* tw.group4._03_.cms.reservation.model.ShopReservationDAO.*(..))"
//			+ " || execution(* tw.group4._03_.cms.shop.model.CreativeShopDAO.*(..))"
//			+ " || execution(* tw.group4._18_.seller.model.CourseBeanDAO.*(..))"
//			+ " || execution(* tw.group4._18_.buyer.DAO.CourseBeanDAOFront.*(..))"
//			+ " || execution(* tw.group4._18_.buyer.DAO.CourseOrderDAO.*(..))"
//			+ " || execution(* tw.group4._18_.buyer.DAO.CourseOrderItemDAO.*(..))"
//			+ " || execution(* tw.group4._11_.model.StreetArtistBeanDAO.*(..))"
//			+ " || execution(* tw.group4._11_.model.UserSADao.*(..))"
//			+ " || execution(* tw.group4._14_.back.dao.MbOrderListDAOImpAP.*(..))"
//			+ " || execution(* tw.group4._14_.back.dao.ProductBeanDAOImp.*(..))"
//			+ " || execution(* tw.group4._14_.front.model.dao.MessageBoardImplAP.*(..))"
//			+ " || execution(* tw.group4._14_.front.model.dao.OrderDaoImpl.*(..))"
//			+ " || execution(* tw.group4._14_.front.model.dao.OrderItemDaoImpl.*(..))";
//	
//	@Pointcut("@within(org.springframework.stereotype.Repository)")
//	public void repositoryInvocation() {
//	    
//	}
//	
//	方法執行前
//	@Before("repositoryInvocation()")，這是舊方法，要自己去找class名，麻煩
//	public void before(JoinPoint joinPoint) ，這是為了印出當前執行方法所以傳入JoinPoint
//  獲取當前執行的方法名稱
//	System.out.println(joinPoint.getSignature().getName());	
	
	@Before("@annotation(Hibernate)")
	public void before() {
		
//		去Spring IOC容器中找名為"sessionFactory"的bean，型態是SessionFactory
//		在建構子建立此類別實例至Spring IOC容器時
//		已經透過@Autowired，設定此類別實例的sessionFactory屬性的值
		
//		透過已注入的sessionFactory getCurrentSession
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Transaction Begin.");

	}

//	若方法執行正常，執行 
	@AfterReturning("@annotation(Hibernate)")
	public void afterReturning() {
		
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().commit();
		System.out.println("Transaction Commit.");

	}

//	若方法執行異常(拋出例外)，執行		  
	@AfterThrowing("@annotation(Hibernate)")
	public void afterThrowing() {
		
		Session session = sessionFactory.getCurrentSession();
		session.getTransaction().rollback();
		System.out.println("Transaction Rollback.");

	}
	
//	方法執行完畢後，不論正常或異常，執行此  
	@After("@annotation(Hibernate)")
	public void after() {
		System.out.println("Session Closed.");
	}

}
