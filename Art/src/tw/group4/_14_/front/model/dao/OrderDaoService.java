package tw.group4._14_.front.model.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_.front.model.OrderItemBeanAP;
import tw.group4._14_.front.model.OrderListBeamAP;


@Service("OrderDaoService")
public class OrderDaoService {
	private OrderDaoImpl oDao;
	private OrderItemDaoImpl oiDao;
	
	public OrderDaoService() {
		
	}

	@Autowired
	public OrderDaoService(OrderDaoImpl oDao, OrderItemDaoImpl oiDao) {
		this.oDao = oDao;
		this.oiDao = oiDao;
	}

	
	public void persistOrder(OrderListBeamAP olbAP) {
		System.out.println("進入persistOrder");
		checkStock(olbAP);
		System.out.println("檢查商品庫存");
		oDao.insertOrder(olbAP);
		System.out.println("儲存訂單");
		
	}
	
	public void checkStock(OrderListBeamAP olbAP) {
		Set<OrderItemBeanAP> items = olbAP.getItems();
		for (OrderItemBeanAP oibAP : items) {
			System.out.println("抵達 for (OrderItemBeanAP oibAP : items)");
			oiDao.updateProductStock(oibAP);
		}
		System.out.println("檢查訂單完成");
	}
	
	public List<OrderListBeamAP> getCustomerOrder(String memberID){
		return oDao.getCustomerOrder(memberID);
	}
	
	public OrderListBeamAP getOrder(int orderNo) {
		return oDao.selectOrder(orderNo);
	}
}
