package tw.group4._14_.front.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.group4._14_.front.model.OrderListBeamAP;
import tw.group4._14_.front.model.dao.OrderDaoService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;



@Controller
public class OrderListController {
	
	@Autowired
	private OrderDaoService serv;
	
	@Hibernate
	@RequestMapping(path = "/14/showOrderList.ctrl")
	public String showOrderList(HttpSession session,Model m) {

		WebsiteMember mb = (WebsiteMember) session.getAttribute("member");
		if (mb == null) {
			return "redirect:/35/loginEntry";
		}
		
//		String memberID = Integer.toString(mb.getId());
		String memberID = mb.getRealName();
//		String memberID= "測試用";
		System.out.println(".....:"+memberID);
		List<OrderListBeamAP> customerOrder = serv.getCustomerOrder(memberID);
		System.out.println("customerOrder"+customerOrder);
		m.addAttribute("customerOrder", customerOrder);
		return "14/14_OrderList_DT";
		
	}
	

}
