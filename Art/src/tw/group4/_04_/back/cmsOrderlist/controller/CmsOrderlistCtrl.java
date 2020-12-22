package tw.group4._04_.back.cmsOrderlist.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._04_.front.orderlist.model.Orderlist;
import tw.group4._04_.front.orderlist.model.OrderlistService;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4._04_.front.shopcart.model.ShoppingcartService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class CmsOrderlistCtrl {

	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Orderlist orderlist;
	@Autowired
	private OrderlistService orderlistService;

	// 查詢訂單
	@Hibernate
	@RequestMapping(path = "/04/Cms/SearchOrder.ctrl", method = RequestMethod.GET)
	public String SearchOrder(Model model, HttpSession session, HttpServletRequest Request) {

		WebsiteMember member = (WebsiteMember) session.getAttribute("member");

		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {
			

			List<Orderlist> orderlists = orderlistService.CmsOrderlist();

				model.addAttribute("orderlists", orderlists);

			}
			return "04/cms_Orderlist/ShowOrderlist";

		}
	
	// 查詢單筆訂單
	@Hibernate
	@RequestMapping(path = "/04/Cms/SearchOneOrder.ctrl", method = RequestMethod.GET)
	public String SearchOneOrder(String orderid,Model model, HttpSession session, HttpServletRequest Request) {

		WebsiteMember member = (WebsiteMember) session.getAttribute("member");

		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {
			

			List<Orderlist> orderlists = orderlistService.searchOrderid(orderid);

				model.addAttribute("orderlists", orderlists);

			}
			return "04/cms_Orderlist/ShowOrderlist";

		}
		
		
	
	//show detail
	@Hibernate
	@RequestMapping(path = "/04/Cms/OrderlistDetail.ctrl", method = RequestMethod.GET)
	public String processOrderDetail(String orderid,Model model) {
		System.out.println("orderid="+orderid);		
		List<Orderlist> orderlists = orderlistService.searchOrderid(orderid);
		orderlist = orderlists.get(0);
		
		String seatString = orderlist.getSeatstring();
		System.out.println(seatString);
		String[] seatarray = seatString.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		for (String s : seatarray) {
			System.out.println(s);
		}
		orderlist.setSeats(seatarray);
		model.addAttribute("orderlist",orderlist);
		
		return "04/cms_Orderlist/OrderlistDetail";
	}
	//刪除訂單
	@Hibernate
	@RequestMapping(path = "/04/Cms/DeleteOrderlist.ctrl", method = RequestMethod.GET)
	public String processDeleteOrderlist(String orderid,Model model,HttpSession session,HttpServletRequest request) {
		//直接由orderid取得orderlists
		List<Orderlist> orderlists = orderlistService.searchOrderid(orderid);
		orderlist = orderlists.get(0);		
		String seatString = orderlist.getSeatstring();
		System.out.println(seatString);
		String[] seatsArray = seatString.replaceAll("\\[", "").replaceAll("\\]", "").split(",");		
		int ticketnum =orderlist.getTICKET_NUM();
		String actno =Integer.toString(orderlist.getACT_ID());
		//取得memberID
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		String memberID = Integer.toString(member.getId());
		System.out.println(orderid);
		orderlistService.deleteOrderid(orderid);
		
		//位置數量加回去
		SeatBean seatBean = seatBeanService.selectBean(orderlist.getACT_ID());
        Integer seatnum=seatBean.getSEATNUM();      
		seatBeanService.updateSeatnum(orderlist.getACT_ID(),seatBean.getSEATNUM()+ticketnum);
		
		System.out.println(ticketnum);
		switch (ticketnum) {
		case 1:
			seatBeanService.delete1Seat(seatsArray,actno);
			break;
		case 2:
			seatBeanService.delete2Seat(seatsArray,actno);
			break;
		case 3:
			seatBeanService.delete3Seat(seatsArray,actno);
			break;
		default:
			seatBeanService.delete4Seat(seatsArray,actno);
			break;
		}
		return "redirect:/04/Cms/SearchOrder.ctrl?";

	}
	
	//申請退票
		@Hibernate
		@RequestMapping(path = "/04/Cms/OrderlistStatus.ctrl", method = RequestMethod.GET)
		public String processUpdateOrderlistStatus(String orderpk,String orderid,Model model,HttpSession session,HttpServletRequest request) {
			//直接由orderid取得orderlists
			List<Orderlist> orderlists = orderlistService.searchOrderid(orderid);
			orderlist = orderlists.get(0);		
			String seatString = orderlist.getSeatstring();
			System.out.println(seatString);
			String[] seatsArray = seatString.replaceAll("\\[", "").replaceAll("\\]", "").split(",");		
			int ticketnum =orderlist.getTICKET_NUM();
			String actno =Integer.toString(orderlist.getACT_ID());
			//取得memberID
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			String memberID = Integer.toString(member.getId());

			orderlistService.updateStatus(Integer.parseInt(orderpk));
			
			//位置數量加回去
			SeatBean seatBean = seatBeanService.selectBean(orderlist.getACT_ID());
	        Integer seatnum=seatBean.getSEATNUM();      
			seatBeanService.updateSeatnum(orderlist.getACT_ID(),seatBean.getSEATNUM()+ticketnum);
			
			System.out.println(ticketnum);
			switch (ticketnum) {
			case 1:
				seatBeanService.delete1Seat(seatsArray,actno);
				break;
			case 2:
				seatBeanService.delete2Seat(seatsArray,actno);
				break;
			case 3:
				seatBeanService.delete3Seat(seatsArray,actno);
				break;
			default:
				seatBeanService.delete4Seat(seatsArray,actno);
				break;
			}
			return "redirect:/04/Cms/SearchOrder.ctrl?";

		}
	
	@Hibernate
	@RequestMapping(path = "/04/Cms/UpdateOrderlist.ctrl", method = RequestMethod.GET)
	public String processUpdateOrderlist(String orderid,Model model) {
		System.out.println("orderid="+orderid);		
		List<Orderlist> orderlists = orderlistService.searchOrderid(orderid);
		orderlist = orderlists.get(0);
		
		String seatString = orderlist.getSeatstring();
		System.out.println(seatString);
		String[] seatarray = seatString.replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		for (String s : seatarray) {
			System.out.println(s);
		}
		orderlist.setSeats(seatarray);
		model.addAttribute("orderlist",orderlist);
		
		return "04/cms_Orderlist/UpdateOrderlist";
	}
	
	//修改訂單
	@Hibernate
	@RequestMapping(path = "/04/Cms/UpdateOrderlist2.ctrl", method = RequestMethod.GET)
	public String UpdateOrderlist2(String name,String email,String tel,String add,String orderPK,Model model, HttpSession session, HttpServletRequest Request) {

		System.out.println("orderPK"+orderPK);
		int orderPKint=Integer.parseInt(orderPK);
		orderlist.setNAME(Request.getParameter("name"));
		orderlist.setEMAIL(Request.getParameter("email"));
		orderlist.setTEL(Request.getParameter("tel"));
		orderlist.setADDRESS(Request.getParameter("add"));
		orderlistService.updateOrderlist(name, email, tel, add, orderPKint);
				

		return "redirect:/04/Cms/SearchOrder.ctrl?";
	}
	
	

}
