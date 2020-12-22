package tw.group4._14_.dashboard.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_.back.Alerts;
import tw.group4._14_.dashboard.model.EntryClickRate;

@Repository("DashboardDAOImpl")
public class DashboardDAOImpl {

	private SessionFactory sessionFactory;

	@Autowired
	public DashboardDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 查詢活動售票總金額
	public Long sumTicketTotal() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ol.TOTALPRICE) From Orderlist ol";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}


	// 查詢詩人募款總金額
	public Long sumArtistTotal() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(dr.donate_sa) From DonateRecordBean dr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢課程銷售總金額
	public Long sumCourseTotal() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(co.totalAmount) From CourseOrders co";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢註冊會員總人數
	public Long sumMember() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT COUNT(1) FROM WebsiteMember";
		Query createQuery = session.createQuery(sql);
		Long count = (Long) createQuery.uniqueResult();
		return count;
	}

	// 新增一筆什麼點擊率
	public EntryClickRate insert(EntryClickRate ecr) {
		Session session = sessionFactory.getCurrentSession();
		session.save(ecr);
		return ecr;
	}

	// 查詢活動入口點擊率
	public Long sumTicketClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.ticket) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢洋行入口點擊率
	public Long sumShopClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.shop) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢餐廳入口點擊率
	public Long sumRestaurantClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.restaurant) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢推薦入口點擊率
	public Long sumMapClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.map) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢我的足跡入口點擊率
	public Long sumNearbyClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.nearby) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢課程入口點擊率
	public Long sumCourseClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.course) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}

	// 查詢藝人入口點擊率
	public Long sumArtistClick() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT SUM(ecr.artist) From EntryClickRate ecr";
		Query createQuery = session.createQuery(sql);
		Long totaLong = (Long) createQuery.uniqueResult();
		return totaLong;
	}
	
	//查詢餐廳預約總筆數
	public Long sumRestaurantOrder() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT COUNT(1) FROM ShopReservationBean";
		Query createQuery = session.createQuery(sql);
		Long count = (Long) createQuery.uniqueResult();
		return count;
	}

	
	
	// 查詢餐廳大人總金額
		public Long sumRestaurantAdTotal() {
			Session session = sessionFactory.getCurrentSession();
			String sql = "SELECT SUM(cr.adultsNum) From ShopReservationBean cr";
			Query createQuery = session.createQuery(sql);
			Long adultLong = (Long) createQuery.uniqueResult();

//			Long totaLong = adultLong * 650;
			return adultLong;
		}

		// 查詢餐廳小孩總金額
		public Long sumRestaurantChTotal() {
			Session session = sessionFactory.getCurrentSession();
			String sql = "SELECT SUM(cr.childrenNum) From ShopReservationBean cr";
			Query createQuery = session.createQuery(sql);
			Long childrenLong = (Long) createQuery.uniqueResult();

//			Long totaLong = childrenLong * 350;
			return childrenLong;
		}

}
