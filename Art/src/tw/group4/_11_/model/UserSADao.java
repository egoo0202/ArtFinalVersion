package tw.group4._11_.model;

import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._35_.login.model.WebsiteMember;


@Repository("UserSADao")
public class UserSADao {

	private SessionFactory sessionFactory;
	private int page = 0;
	private int pageSize = 10;
	private int totalPage = 1;
	
	@Autowired
	public UserSADao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserSABean> selectAll(){
		Session session = sessionFactory.getCurrentSession();
		Query<UserSABean> query = session.createQuery("From UserSABean", UserSABean.class);
		
//		圖片檔需要轉檔 否則無法讀出
		List<UserSABean> list = query.list();
		return list;
	}
	
	public List<UserSABean> selectPage(int page){
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		Query<UserSABean> query = session.createQuery("From UserSABean sa Order by id_SA",UserSABean.class);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<UserSABean> list = query.list();
		
		return list;
	}
	
	public int selectCount() {
		Session session = sessionFactory.getCurrentSession();
		int count = 0;
		String sql = "select count(*) From UserSABean";
		Query<UserSABean> query = session.createQuery(sql);
		
		List<UserSABean> list = query.list();
		
		for (int i = 0; i < list.size(); i++) {
			count++;
		}
		
		return count;
	}
	
	public int getTotlePage(){
		
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		if ((countSaPage % pageSize) != 0) {
			totalPage = (int) (Math.floor(countSaPage/pageSize));
		} else {
			totalPage = (int) (Math.ceil(countSaPage/pageSize));
		}
		
		return totalPage;
	}
	
	public int getPages(String query) {
		Session session = sessionFactory.getCurrentSession();
		String count = "Select count (sa.id_SA) From UserSABean sa FROM UserSABean WHERE theme_SA like %"+query+"% Or classification_SA like %"+query+"% Order by ID_SA";
		Query countQuery = session.createQuery(count);
		Long countSaPage = (Long) countQuery.uniqueResult();
		
		if ((countSaPage % pageSize) != 0) {
			totalPage = (int) (Math.floor(countSaPage/pageSize));
		} else {
			totalPage = (int) (Math.ceil(countSaPage/pageSize));
		}
		return totalPage;
	}
	
	public byte[] picSaByteArray(UserSABean uBean) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<UserSABean> query = session.createQuery("FROM UserSABean ORDER BY ID_SA", UserSABean.class);
		UserSABean uBeanResult = query.uniqueResult();
		Blob blobResult = uBeanResult.getPic_SA();
		
		byte[] byteArray = null;
		try {
			byteArray = blobResult.getBytes(1, (int) blobResult.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return byteArray;
	}
	
	public String judgePic(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserSABean saBean = session.get(UserSABean.class, id);
		
		Blob pic = saBean.getPic_SA();
		String name = saBean.getName_SA();
		
		if (pic != null) {
			return name;
		} else {
			return "這人很懶，沒設照片喔！";
		}
	}
	
	public UserSABean changePic(int id_SA , Blob pic_SA) {
		Session session = sessionFactory.getCurrentSession();
		UserSABean result = session.get(UserSABean.class, id_SA);
		
		
		if (result != null) {
			result.setPic_SA(pic_SA);
		}
		return result;
	}
	
	public DonateRecordBean insert(DonateRecordBean uBean) {
		Session session = sessionFactory.getCurrentSession();
		session.save(uBean);
		return uBean;
	}
	
	public UserSABean selectById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserSABean uBean = session.get(UserSABean.class, id);
		return uBean;
	}
	
	public List<UserSABean> search(String word){
		String sss = "%"+word+"%";
		
		Session session = sessionFactory.getCurrentSession();
		Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE theme_SA like ?0 Or classification_SA like ?1 Order by ID_SA",UserSABean.class);
		query.setParameter(0, sss);
		query.setParameter(1, sss);
		List<UserSABean> list = query.list();
		return list;
	}
	
	public List<UserSABean> search3(String country, String classification, String theme){
		
		Session session = sessionFactory.getCurrentSession();
		String nullString = null;
		
		if (country.equals("*")) {
			if (classification.equals("*")) {
				if (theme.equals(nullString)) {
					Query<UserSABean> query = session.createQuery("FROM UserSABean Order by ID_SA",UserSABean.class);
					List<UserSABean> list = query.list();
					return list;
				} else {
					String c = "%" + theme + "%";
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE theme_SA like ?0 Order by ID_SA",UserSABean.class);
					query.setParameter(0, c);
					List<UserSABean> list = query.list();
					return list;
				}
			} else {
				String b = "%" + classification + "%";
				if (theme.equals(nullString)) {
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE classification_SA like ?0 Order by ID_SA",UserSABean.class);
					query.setParameter(0, b);
					List<UserSABean> list = query.list();
					return list;
				} else {
					String c = "%" + theme + "%";
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE theme_SA like ?0 And classification_SA like ?1 Order by ID_SA",UserSABean.class);
					query.setParameter(0, c);
					query.setParameter(1, b);
					List<UserSABean> list = query.list();
					return list;
				}
			}
		}else {
			String a = "%" + country + "%";	
			if (classification.equals("*")) {
				if (theme.equals(nullString)) {
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE country_SA like ?0 Order by ID_SA",UserSABean.class);
					query.setParameter(0, a);
					System.out.println(a);
					List<UserSABean> list = query.list();
					return list;
				} else {
					String c = "%" + theme + "%";
					System.out.println(a+c);
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE theme_SA like ?0 And country_SA like ?1 Order by ID_SA",UserSABean.class);
					query.setParameter(0, c);
					query.setParameter(1, a);
					List<UserSABean> list = query.list();
					return list;
				}
			} else {
				String b = "%" + classification + "%";
				if (theme.equals(nullString)) {
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE classification_SA like ?0 And country_SA like ?1 Order by ID_SA",UserSABean.class);
					query.setParameter(0, b);
					query.setParameter(1, a);
					List<UserSABean> list = query.list();
					return list;
				} else {
					String c = "%" + theme + "%";
					Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE theme_SA like ?0 And classification_SA like ?1 And country_SA like ?2 Order by ID_SA",UserSABean.class);
					query.setParameter(0, c);
					query.setParameter(1, b);
					query.setParameter(2, a);
					List<UserSABean> list = query.list();
					return list;
				}
			}
		}
	}
	
	public List<UserSABean> searchID(int id){
		Session session = sessionFactory.getCurrentSession();
		Query<UserSABean> query = session.createQuery("FROM UserSABean WHERE ID_SA =?0 ",UserSABean.class);
		query.setParameter(0, id);
		List<UserSABean> list = query.list();
		return list;
	}
	
	public UserSABean donateToSA(int id_SA , int sal_SA) {
		Session session = sessionFactory.getCurrentSession();
		UserSABean result = session.get(UserSABean.class, id_SA);
		int a = result.getSal_SA();
		
		if (sal_SA > 0) {
			a = a + sal_SA;
			result.setSal_SA(a);
		} 
		return result;
	}

	public List<DonateRecordBean> showList(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<DonateRecordBean> query = session.createQuery("From DonateRecordBean Where name_user =?0 ",DonateRecordBean.class);
		query.setParameter(0, name);
		List<DonateRecordBean> list = query.list();
		return list;
	}
	
	public List<DonateRecordBean> showAllDonateRecord(){
		Session session = sessionFactory.getCurrentSession();
		Query<DonateRecordBean> query = session.createQuery("From DonateRecordBean", DonateRecordBean.class);
		
		List<DonateRecordBean> list = query.list();
		return list;
	}
}
