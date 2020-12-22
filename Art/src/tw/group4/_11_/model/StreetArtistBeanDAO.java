package tw.group4._11_.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("StreetArtistBeanDAO")
public class StreetArtistBeanDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public StreetArtistBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public StreetArtistBean insert(StreetArtistBean sBean) {
		Session session = sessionFactory.getCurrentSession();
		session.save(sBean);
		return sBean;
	}

	public StreetArtistBean select(int id_SA) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(StreetArtistBean.class, id_SA);
	}
	
	public List<StreetArtistBean> selectAll(){
		Session session = sessionFactory.getCurrentSession();
		Query<StreetArtistBean> query = session.createQuery("From StreetArtistBean Order by ID_SA", StreetArtistBean.class);
		List<StreetArtistBean> list = query.list();
		return list;
	}
	
	public List<StreetArtistBean> search(String word){
		String sss = "%"+word+"%";
		
		Session session = sessionFactory.getCurrentSession();
		Query<StreetArtistBean> query = session.createQuery("FROM StreetArtistBean WHERE theme_SA like ?0 Or classification_SA like ?1 Order by ID_SA",StreetArtistBean.class);
		query.setParameter(0, sss);
		query.setParameter(1, sss);
		List<StreetArtistBean> list = query.list();
		return list;
	}
	
	public List<StreetArtistBean> searchID(int id){
		Session session = sessionFactory.getCurrentSession();
		Query<StreetArtistBean> query = session.createQuery("FROM StreetArtistBean WHERE ID_SA =?0 ",StreetArtistBean.class);
		query.setParameter(0, id);
		List<StreetArtistBean> list = query.list();
		return list;
	}
	
	public StreetArtistBean update(int id_SA , String name_SA , String country_SA , String theme_SA , String classification_SA) {
		Session session = sessionFactory.getCurrentSession();
		StreetArtistBean result = session.get(StreetArtistBean.class, id_SA);
		
		if (result!=null) {
			result.setName_SA(name_SA);
			result.setCountry_SA(country_SA);
			result.setTheme_SA(theme_SA);
			result.setClassification_SA(classification_SA);
		}
		return result;
	}
	
	public boolean delete(int id_SA) {
		Session session = sessionFactory.getCurrentSession();
		StreetArtistBean result = session.get(StreetArtistBean.class, id_SA);
		
		if (result!=null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
	public int showSal(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserSABean uS = session.get(UserSABean.class,id);
		
		if (uS != null) {
			int sal = uS.getSal_SA();
			return sal;
		}
		return 0 ;
	}
}
