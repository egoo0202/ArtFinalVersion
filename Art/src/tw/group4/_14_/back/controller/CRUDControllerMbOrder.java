package tw.group4._14_.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._14_.back.dao.MbOrderListDAOServiceAP;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4.util.Hibernate;

@Controller
public class CRUDControllerMbOrder {

	@Autowired
	private MbOrderListDAOServiceAP mOrderService;
	
	@Autowired
	private ProductBeanDAOService pDaoservice;
	
	//列出所有會員訂單
	@Hibernate
	@RequestMapping(path = "/14/ShowAllOrderList.ctrl") 
	public String processAction3(Model m) {
		
		List<OrderListBeamAP> OrderList = pDaoservice.selectUserOrderListNoPage();
		m.addAttribute("OrderList", OrderList);
		
		return "14/14_OrderCRUDPage";
	}
	
	//列出某筆訂單資料
	@Hibernate
	@RequestMapping(path = "/14/MbOrderListSelect.ctrl")
	public String MbOrderListSelect(@RequestParam(name = "orderListID") int orderListID, Model m) {
		OrderListBeamAP order = mOrderService.select(orderListID);
		
		m.addAttribute("order", order);
		
		return "14/14_OrderDetailCMS";
	}
	
	
	//刪除某筆訂單
	@Hibernate
	@RequestMapping(path = "/14/MbOrderListDelet.ctrl")
	public String MbOrderListDelet(@RequestParam(name = "orderListID") int orderListID) {
		
		mOrderService.delete(orderListID);
		
		
		return "redirect:/14/ShowAllOrderList.ctrl";
	}
	
}
