package tw.group4._35_.login.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WebsiteMemberDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public WebsiteMemberDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public WebsiteMember insert(WebsiteMember wmBean) {
		Session session = sessionFactory.getCurrentSession();
		
		if (wmBean!=null) {
			session.save(wmBean);
		}
		
		return wmBean;
	}
	
	public WebsiteMember update(WebsiteMember wmBean) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(wmBean);
		return wmBean;
	}
	
	public int insertWithResult(WebsiteMember wmBean) {
		Session session = sessionFactory.getCurrentSession();
		
		if (wmBean!=null) {
			session.save(wmBean);
			return 1;
		}
		
		return 0;
	}
	
	public WebsiteMember selectById(int id) {
		Session session = sessionFactory.getCurrentSession();
		WebsiteMember wmBean = session.get(WebsiteMember.class, id);
		return wmBean;
	}
	
	public Boolean checkLogin(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name and password = :password", WebsiteMember.class);
		query.setParameter("name", member.getName());
		query.setParameter("password", member.getPassword());
		WebsiteMember memberResult = query.uniqueResult();

		if(memberResult!=null) {
			return true;
		}
		
		return false;
	}
	
	public WebsiteMember getMemberFullInfo(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name and password = :password", WebsiteMember.class);
		query.setParameter("name", member.getName());
		query.setParameter("password", member.getPassword());
		WebsiteMember memberResult = query.uniqueResult();
		
		return memberResult;
	}
	
	public boolean checkNameExsist(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name", WebsiteMember.class);
		query.setParameter("name", name);
		WebsiteMember memberResult = query.uniqueResult();
		
		if (memberResult==null) {
			return false;
		}
		
		return true;
	}
	
	public List<WebsiteMember> selectAllMembers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember", WebsiteMember.class);
		List<WebsiteMember> list = query.list();
		return list;
	}
	
	public List<WebsiteMember> selectSingleMember(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name= :name", WebsiteMember.class);
		query.setParameter("name", name);
		WebsiteMember member = query.uniqueResult();
		List<WebsiteMember> list = new ArrayList<WebsiteMember>();
		list.add(member);
		
		return list;
	}
	
	public boolean deleteMemberByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name= :name", WebsiteMember.class);
		query.setParameter("name", name);
		List<WebsiteMember> list = query.list();

		if(list.size()!=0) {
			for(WebsiteMember item: list)
				session.delete(item);
				return true;
		}
		
		return false;
	}
	
	public boolean updateMemberByName(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name= :name", WebsiteMember.class);
		query.setParameter("name", member.getName());
		List<WebsiteMember> list = query.list();
		if(list.size()!=0) {
			for (WebsiteMember item: list) {
				session.detach(item);
			}
			session.update(member);
			return true;
		}
		
		return false;
	}
	
}
