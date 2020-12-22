package tw.group4._04_.back.cmsAct.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository("showBeanDao")
public class ShowBeanDAO {

	private SessionFactory sessionFacory;
	private Session session;

	// 頁數用
	private int pageNo = 0; // 存放目前顯示之頁面的編號
	private int pageSize = 100;
	private int totalPages = 1;
	private String query;

//	public ShowBeanDAO() {
//	
//	}	
	// DAO一叫出來就幫忙取完session了
	// 現在都在DAO層用SessionFactory幫忙做事
	// 不再傳遞session一層一層下去
	@Autowired
	public ShowBeanDAO(@Qualifier("sessionFactory") SessionFactory sessionFacory) {
		this.sessionFacory = sessionFacory;
	}

//	@Autowired 
//	public ShowBeanDAO(Session session) {
//		this.sessionFacory = sessionFacory;
//	}

	// 新增
	public int insert(ShowBean showbean) {
		Session session = sessionFacory.getCurrentSession();
//		ShowBean resultBean = session.get(ShowBean.class, showbean.getACT_NO());
//		if (resultBean == null) {
		int id=(int) session.save(showbean);
		return id;
//		}
//		return null;
	}

	// 查詢
	public ShowBean select(int actno) {
		Session session = sessionFacory.getCurrentSession();
		return session.get(ShowBean.class, actno);
	}

	// 查詢多筆
	public List<ShowBean2> selectAll() {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean2> query = session.createQuery("From ShowBean2 SB2 ORDER BY SB2.ACT_NO", ShowBean2.class);
		List<ShowBean2> list = query.list();
		return list;
	}

	// 查詢分類 開始日期排序
	public List<ShowBean2> selectAll_category(int category) {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean2> query = session.createQuery(
				"From ShowBean2 SB2 where SB2.ACT_CATEGORY=" + category + "ORDER BY SB2.ACT_STARTDATE",
				ShowBean2.class);

		List<ShowBean2> list = query.list();
		return list;
	}

	// 查詢分類 開始日期排序
	public List<ShowBean> selectAll_categoryTEST(int category) {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean> query = session.createQuery(
				"From ShowBean SB where SB.ACT_CATEGORY=" + category + "ORDER BY SB.ACT_STARTDATE", ShowBean.class);
		query.setFirstResult(1);
		query.setMaxResults(100);
		List<ShowBean> list = query.list();
		return list;
	}

	// 查詢多筆 開始日期排序
	public List<ShowBean2> selectAll_startdate() {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean2> query = session.createQuery("From ShowBean2 SB2 ORDER BY SB2.ACT_STARTDATE", ShowBean2.class);
		List<ShowBean2> list = query.list();
		return list;
	}

	// 查詢多筆 結束日期排序
	public List<ShowBean2> selectAll_enddate() {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean2> query = session.createQuery("From ShowBean2 SB2 ORDER BY SB2.ACT_ENDDATE", ShowBean2.class);
		List<ShowBean2> list = query.list();
		return list;
	}
	// 查詢多筆 開始日期排序
	public List<ShowBean> selectAll_startdateTEST() {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean> query = session.createQuery("From ShowBean SB ORDER BY SB.ACT_STARTDATE", ShowBean.class);
		query.setFirstResult(1);
		query.setMaxResults(100);
		List<ShowBean> list = query.list();
		return list;
	}
	
	// 查詢多筆 結束日期排序
	public List<ShowBean> selectAll_enddateTEST() {
		// "From ShowBean"為createQuery
		//
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean> query = session.createQuery("From ShowBean SB ORDER BY SB.ACT_ENDDATE", ShowBean.class);
		query.setFirstResult(1);
		query.setMaxResults(100);
		List<ShowBean> list = query.list();
		return list;
	}

	// 查詢多筆+分頁
	public List<ShowBean> selectAll2() {
		// "From ShowBean"為createQuery
		Session session = sessionFacory.getCurrentSession();
		Query<ShowBean> query = session.createQuery("From ShowBean", ShowBean.class);
		query.setFirstResult(1);
		query.setMaxResults(100);
		List<ShowBean> list = query.list();
		return list;
	}

	// 查詢多筆+分頁
//	public List<ShowBean> selectAll3(int pageNo) {
//		//全部查詢
//		Session session = sessionFacory.getCurrentSession();
//		String countQ = "Select count (SB.ACT_NO) From ShowBean SB";
//		Query countQuery = session.createQuery(countQ);
//		Long countResult = (Long) countQuery.uniqueResult();
//		int lastPageNum = (int) (Math.ceil(countResult / pageSize));
//
//		Query<ShowBean> query = session.createQuery("From ShowBean SB ORDER BY SB.ACT_NO", ShowBean.class);
//		query.setFirstResult((pageNo - 1) * pageSize);
//		query.setMaxResults(pageSize);
//		List<ShowBean> list = query.list();
//		return list;
//	}

	// 查詢分類+多筆+分頁
	public List<ShowBean> selectAll3(int pageNo, int category) {
		// 全部查詢
		Session session = sessionFacory.getCurrentSession();
		String countQ = "Select count (SB.ACT_NO) From ShowBean SB";
		Query countQuery = session.createQuery(countQ);
		Long countResult = (Long) countQuery.uniqueResult();
		int lastPageNum = (int) (Math.ceil(countResult / pageSize));

		Query<ShowBean> query = session.createQuery(
				"From ShowBean SB WHERE SB.ACT_CATEGORY=" + category + "ORDER BY SB.ACT_NO", ShowBean.class);
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<ShowBean> list = query.list();
		return list;
	}

	// 計算數量
	public int selectCount() {
		Session session = sessionFacory.getCurrentSession();
		int count = 0;
		String sql = "SELECT COUNT(*) FROM ShowBean";
		Query<ShowBean> q = session.createQuery(sql);

//		q.setFirstResult(1);
//		q.setMaxResults(10);
		List<ShowBean> list = q.list();

		for (int i = 0; i < list.size(); i++) {
			count++;
		}

		return count;
	}

	// 計算總數
	public int getTotalPages() {
		Session session = sessionFacory.getCurrentSession();
		String countQ = "Select count (SB.ACT_NO) From ShowBean SB";
		Query countQuery = session.createQuery(countQ);
		Long countResult = (Long) countQuery.uniqueResult();
		System.out.println("countResult" + countResult);
//		totalPages = (int) (Math.ceil(countResult/pageSize));
		if ((countResult % pageSize) != 0) {
			totalPages = (int) (Math.ceil(countResult / pageSize)) + 1;
		} else {
			totalPages = (int) (Math.ceil(countResult / pageSize));

		}
		return totalPages;
	}

	// 修改
	public ShowBean update(int actno, String title, int category, String location, String locationName, String mainunit,
			String showunit, String description, String startdate, String enddate,byte[]photo){

		Session session = sessionFacory.getCurrentSession();
		ShowBean showBean = session.get(ShowBean.class, actno);
		
		
		if (showBean != null) {
			showBean.setACT_TITLE(title);
			showBean.setACT_CATEGORY(category);
			showBean.setACT_LOCATION(locationName);
			showBean.setACT_MAINUNIT(mainunit);
			showBean.setACT_SHOWUNIT(showunit);
			showBean.setACT_DESCRIPTION(description);
			showBean.setACT_STARTDATE(startdate);
			showBean.setACT_ENDDATE(enddate);
			showBean.setACT_PHOTO(photo);

		}

		return showBean;
	}

	// 刪除
	public boolean delete(int actno) {

		Session session = sessionFacory.getCurrentSession();
		ShowBean result = session.get(ShowBean.class, actno);

		if (result != null) {
			session.delete(result);
			return true;
		}

		return false;
	}

	// 模糊查詢
	// find內預設傳入String searchString參數
	public List<ShowBean2> find(String searchString) {

		Session session = sessionFacory.getCurrentSession();
		String queryString = "from ShowBean2 where ACT_TITLE like'%" + searchString + "%'";
		Query query = session.createQuery(queryString);

		return query.list();

	}

	// 模糊查詢
	// find內預設傳入String searchString參數
	public List<ShowBean> findTEST(String searchString) {

		Session session = sessionFacory.getCurrentSession();
		String queryString = "from ShowBean where ACT_TITLE like'%" + searchString + "%'";
		Query query = session.createQuery(queryString);
//		query.setFirstResult(1);
//		query.setMaxResults(100);
		return query.list();

	}
	public List<ShowBean> findlike(String searchString) {
		
		Session session = sessionFacory.getCurrentSession();
		String queryString = "from ShowBean where ACT_TITLE like'%" + searchString + "%'";
		Query query = session.createQuery(queryString);
		query.setFirstResult(1);
		query.setMaxResults(4);
		return query.list();
		
	}
	//file2byte[]方法
	private static byte[] readFileToByteArray(File file){
	    FileInputStream fis = null;
	    // Creating a byte array using the length of the file
	    // file.length returns long which is cast to int
	    byte[] bArray = new byte[(int) file.length()];
	    try{
	      fis = new FileInputStream(file);
	      fis.read(bArray);
	      fis.close();                   
	    }catch(IOException ioExp){
	      ioExp.printStackTrace();
	    }
	    return bArray;
	  }
	
	// 查詢熱門
		public List<ShowBean> select_popularity() {
			// "From ShowBean"為createQuery
			//
			Session session = sessionFacory.getCurrentSession();
			Query<ShowBean> query = session.createQuery("From ShowBean SB WHERE SB.ACT_POPULARITY >10 ORDER BY SB.ACT_POPULARITY", ShowBean.class);
			query.setFirstResult(1);
			query.setMaxResults(4);
			List<ShowBean> list = query.list();
			return list;
		}

}
