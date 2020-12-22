package tw.group4._14_.index.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.back.ARTProduct;

@Service
public class IndexDaoService {
	private IndexDaoImpl indexDao;
	
	public IndexDaoService() {
		
	}

	@Autowired
	public IndexDaoService(IndexDaoImpl indexDao) {
		this.indexDao=indexDao;
	}
	
	public List<ARTProduct> selectShopHot() {
		return indexDao.selectShopHot();
		
	}
	public List<ARTProduct> selectShopHomeHot() {
		return indexDao.selectShopHomeHot();
	}
}
