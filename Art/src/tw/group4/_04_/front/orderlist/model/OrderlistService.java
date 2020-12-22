package tw.group4._04_.front.orderlist.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._04_.back.cmsAct.model.ShowBeanDAO;

@Service
public class OrderlistService {
	
	private OrderlistDAO orderlistDAO;

	@Autowired
	public OrderlistService(OrderlistDAO orderlistDAO) {
		this.orderlistDAO = orderlistDAO;
	}
	
	// 新增
		public Orderlist  updateOrderlist(String name,String email,String tel,String add,int orderPK) {
	
			return orderlistDAO. updateOrderlist(name,email,tel,add,orderPK);
		}
	
	public List<Orderlist> searchOrderlist(String memberID) {
		
		return orderlistDAO.searchOrderlist(memberID);
	}
	
	public List<Orderlist> CmsOrderlist() {
		
		return orderlistDAO.CmsOrderlist();
	}
	
	public List<Orderlist> searchOrderid(String orderid) {
		
		return orderlistDAO.searchOrderid(orderid);
	}
	
	public boolean deleteOrderid(String orderid) {
		
		return orderlistDAO.deleteOrderid(orderid);
	}
	
	// 修改退票
			public Orderlist  updateStatus(int orderPK) {

				return orderlistDAO.updateStatus(orderPK);
			}



}
