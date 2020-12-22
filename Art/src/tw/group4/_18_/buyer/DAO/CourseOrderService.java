package tw.group4._18_.buyer.DAO;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._18_.buyer.model.CourseOrderItems;
import tw.group4._18_.buyer.model.CourseOrders;

@Service("CourseOrderService")
public class CourseOrderService {
	
	private CourseOrderDAO coDAO;
	private CourseOrderItemDAO coiDAO;
	
	public CourseOrderService() {
		
	}

	@Autowired
	public CourseOrderService(CourseOrderDAO coDAO, CourseOrderItemDAO coiDAO) {
		this.coDAO = coDAO;
		this.coiDAO = coiDAO;
	}
	
	public void persistOrder(CourseOrders cOrders) {
		checkStock(cOrders);
		System.out.println("檢查庫存");
		coDAO.insertOrder(cOrders);
		System.out.println("儲存訂單");
	}
	
	
	private void checkStock(CourseOrders cOrders) {
		Set<CourseOrderItems> coItems = cOrders.getCourseOrderItems();
		for (CourseOrderItems coi : coItems) {
			coiDAO.updateCourseNum(coi);
		}
		System.out.println("訂單檢查完畢");
	}

	
	public List<CourseOrders> getcoOrder(){
		return coDAO.getcoOrder();
	}

	
	public List<CourseOrders> getcoOrderByMId(String memberId){
		return coDAO.getcoOrderByMId(memberId);
	}
	
	
	public CourseOrders getcoOrderByONo(int orderNoCo){
		return coDAO.getcoOrderByONo(orderNoCo);
	}
	
	
	public boolean deleteOrder(int orderNoCo) {
		return coDAO.deleteOrder(orderNoCo);

	}
	
//	public CourseOrders insertOrder(CourseOrders co) {
//		return coDAO.insertOrder(co);
//
//	}
	
//	public CourseOrders selectOrder(int coOrderNo) {
//		return coDAO.selectcoOrder(coOrderNo);
//	}
	
//	public List<Course> customerSelectAll() {
//		return coDAO.customerSelectAll();
//	}
	
}
