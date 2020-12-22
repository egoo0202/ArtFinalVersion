package tw.group4._14_.back.dao;

import java.util.List;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.front.model.OrderListBeamAP;


//@Scope("session")
@Service("ProductBeanDAOService")
public class ProductBeanDAOService {
	
	@Autowired
	private ProductBeanDAOImp pDAO;
	
	public ProductBeanDAOService() {
		
	}

//	@Autowired
	public ProductBeanDAOService(ProductBeanDAOImp pDAO) {
		this.pDAO = pDAO;
	}
//	public ProductBeanDAOService(Session session) {
//		pDAO = new ProductBeanDAOImp(session);
//	}
	

	public ARTProduct insert(ARTProduct pd) {
		return pDAO.insert(pd);
		
	}
	
	public ARTProduct updateProduct(ARTProduct pd) {
		return pDAO.updateProduct(pd);
	}
	

//	@Transactional(rollbackFor = Throwable.class)
	public ARTProduct select(String productId) {
		 return pDAO.select(productId);
	 }
	 

	public  List<ARTProduct> selectAll(int pageNo){
		return pDAO.selectAll(pageNo);
		
	}
	
	public List<ARTProduct> selectQueryAll(int pageNo, String query) {
		return pDAO.selectQueryAll(pageNo,query);
		
	}
	
	
	public List<ARTProduct> selectNoPage() {
		return pDAO.selectNoPage();
	}
	

	public  ARTProduct update (String productId, String productTitle, String productPrice, int productNum, byte[] productImgBlob, String APDES) {
		return pDAO.update(productId, productTitle, productPrice, productNum, productImgBlob, APDES);
		
	}
	

	public boolean delete(String productId) {
		return pDAO.delete(productId);
	}
	
	public int selectCount() {
		return pDAO.selectCount();
	}
	
	public int getTotalPages() {
		return pDAO.getTotalPages();
	}
	
	public int getQueryPages(String query) {
		return pDAO.getQueryPages(query);
	}
	
	public List<OrderListBeamAP> selectUserOrderListNoPage() {
		return pDAO.selectUserOrderListNoPage();
	}
	
	public List<ARTProduct> selectNoImg() {
		return pDAO.selectNoImg();
	}
	
}
