package tw.group4._35_.cms.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class EventSpaceDao implements InterfaceEventSpaceDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public EventSpaceDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//依場地名稱查詢
	@Override
	public List<EventSpace> select(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EventSpace> query = session.createQuery("From EventSpace where name like :param", EventSpace.class);
		query.setParameter("param", "%"+name+"%");
		List<EventSpace> list = query.list();
		return list;
	}
	
	//查詢全部場地
	@Override
	public List<EventSpace> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EventSpace> query = session.createQuery("From EventSpace", EventSpace.class);
		List<EventSpace> list = query.list();
		return list;
	}
	
	//新增。存在就不新增，不存在才新增。
	@Override
	public EventSpace insert(EventSpace bean) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EventSpace> query = session.createQuery("From EventSpace where name= :name", EventSpace.class);
		query.setParameter("name", bean.getName());
		List<EventSpace> result = query.list();
		
		if(result.size()==0) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	
	//更新。傳入bean.getId對應的資料，確認資料庫有這筆後。
	//detach搜尋到的物件再次進行更新
	@Override
	public boolean update(EventSpace bean) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EventSpace> query = session.createQuery("From EventSpace where id= :id", EventSpace.class);
		query.setParameter("id", bean.getId());
		List<EventSpace> list = query.list();
		if(list.size()!=0) {
			for (EventSpace item: list) {
				session.detach(item);
			}
			session.update(bean);
			return true;
		}
		return false;
	}
	
	//刪除。傳入name有對應資料才刪除。
	@Override
	public boolean delete(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<EventSpace> query = session.createQuery("From EventSpace where name= :name", EventSpace.class);
		query.setParameter("name", name);
		List<EventSpace> list = query.list();

		if(list.size()!=0) {
			for(EventSpace item: list)
				session.delete(item);
				return true;
		}
		return false;
	}
}
