package tw.group4._04_.back.cmsAct.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service("showbeanService")

public class ShowBeanService {

	private ShowBeanDAO SDao;

	public ShowBeanService() {
	}

//	public ShowBeanService(Session session) {
//		SDao = new ShowBeanDAO();
//	}
	@Autowired
	public ShowBeanService(ShowBeanDAO SDao) {
		this.SDao = SDao;
	}

	public int insert(ShowBean showbean) {
		return SDao.insert(showbean);
	}

	public ShowBean select(int actId) {
		return SDao.select(actId);
	}

	public List<ShowBean2> selectAll() {
		return SDao.selectAll();
	}

	public List<ShowBean2> selectAll_category(int category) {

		return SDao.selectAll_category(category);
	}

	public List<ShowBean> selectAll_categoryTEST(int category) {

		return SDao.selectAll_categoryTEST(category);
	}

	public List<ShowBean2> selectAll_startdate() {
		return SDao.selectAll_startdate();
	}

	public List<ShowBean2> selectAll_enddate() {
		return SDao.selectAll_enddate();
	}

	public List<ShowBean> selectAll_startdateTEST() {
		return SDao.selectAll_startdateTEST();
	}

	public List<ShowBean> selectAll_enddateTEST() {
		return SDao.selectAll_enddateTEST();
	}

	public List<ShowBean> selectAll2() {
		return SDao.selectAll2();
	}

	public List<ShowBean> selectAll3(int pageNo, int category) {
		return SDao.selectAll3(pageNo, category);
	}

	public int getTotalPages() {
		return SDao.getTotalPages();
	}

	public ShowBean update(int actno, String title, int category, String location, String locationName, String mainunit,
			String showunit, String description, String startdate, String enddate, byte[] photo) {

		return SDao.update(actno, title, category, location, locationName, mainunit, showunit, description, startdate,
				enddate, photo);
	}

	public boolean delete(int actid) {
		return SDao.delete(actid);
	}

	public List<ShowBean2> find(String searchString) {
		return SDao.find(searchString);
	}

	public List<ShowBean> findTEST(String searchString) {
		return SDao.findTEST(searchString);
	}

	// 查詢熱門
	public List<ShowBean> select_popularity() {

		return SDao.select_popularity();
	}
	//查詢四筆相似
	public List<ShowBean> findlike(String searchString) {
		
		return SDao.findlike(searchString);
		
	}

}
