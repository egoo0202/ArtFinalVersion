package tw.group4._04_.front.shopcart.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.encoder.QRCode;

import tw.group4._04_.front.ecpay.PaymentImpl;
import tw.group4._04_.front.javaMail.controller.SpringMail;
import tw.group4._04_.front.javaMail.model.EmailServiceImpl;
import tw.group4._04_.front.qrcode.QRCodeTool;
import tw.group4._04_.front.qrcode.QRCodeToolTest;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4._04_.front.shopcart.model.ShoppingcartService;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;


@Controller
public class ShoppingCartCtrl {

	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;
	@Autowired
	private ShoppingcartService shoppingcartService;
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	@Autowired
	private QRCodeToolTest qrcodetool;
	//判定是否登入
	@Hibernate
	@RequestMapping(path = "/04/booking.ctrl", method = RequestMethod.GET)
	public String booking(Model model, HttpSession session, HttpServletRequest Request) {

		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {
			String memberID = Integer.toString(member.getId());
			System.out.println("memberID:" + memberID);
			// 將memberID放入shoppingcart

			if (shoppingcart == null) {
				shoppingcart = new Shoppingcart();
				shoppingcart.setMEMBERID(memberID);
			} else {
			}
			shoppingcart.setMEMBERID(memberID);

			return "04/front_saleTicket/Booking";
		}

	}
	//取得劃位資訊
	@Hibernate
	@RequestMapping(path = "/04/shoppingcart.ctrl", method = RequestMethod.GET)
	public String shoppingcart(Model model, HttpSession session, HttpServletRequest Request) {
		List<String> seat = new ArrayList<String>();
		String[] seats = Request.getParameterValues("seat");
//			int seatnum=Integer.parseInt(Request.getParameter("seatnum"));
		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		shoppingcart.setSeats(seats);
//			shoppingcart.setSeatnum(seatnum);

		return "04/front_saleTicket/Booking2";
	}
    //取得訂購人資訊
	@Hibernate
	@RequestMapping(path = "/04/shoppingcart2.ctrl", method = RequestMethod.GET)
	public String shoppingcart2(Model model, HttpSession session, HttpServletRequest Request) {

		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		if (shoppingcart == null) {
			return "redirect:/index.html";
		}
		String ticketcategory = shoppingcart.getTICKETCATEGORY();
		System.out.println(ticketcategory);
		if ("全票".equals(ticketcategory)) {
			int Totalprice = shoppingcart.getTICKET_NUM() * 2000;
			shoppingcart.setTOTALPRICE(Totalprice);
		} else {
			int Totalprice = shoppingcart.getTICKET_NUM() * 1000;
			shoppingcart.setTOTALPRICE(Totalprice);
		}

		shoppingcart.setNAME(Request.getParameter("name"));
		shoppingcart.setEMAIL(Request.getParameter("email"));
		shoppingcart.setTEL(Request.getParameter("tel"));
		shoppingcart.setADDRESS(Request.getParameter("add"));

		return "04/front_saleTicket/Booking3";
	}
	@Hibernate
	@RequestMapping(path = "/04/delectTicket.ctrl", method = RequestMethod.GET)
	public String Ticket(Model model, HttpSession session, HttpServletRequest Request, String seat) {
//		System.out.println("seat" + seat);
		String[] seats2 = {};
		List<String> seatlist = new ArrayList<String>();
		// 取得SESSION 中seats
		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		String[] seats = shoppingcart.getSeats();
		for (String s : seats) {
			if (!s.equals(seat)) {
//				System.out.println(s);
				seatlist.add(s);
			}
		}
		// 將List<String> seatlist 轉為String[]
		seats2 = new String[seatlist.size()];
		seatlist.toArray(seats2);
		shoppingcart.setSeats(seats2);
		// 取得座位數
		int TicketNUM = seatlist.size();
		shoppingcart.setTICKET_NUM(seatlist.size());
		session.setAttribute("shoppingcartnum", TicketNUM);//購物車顯示數字

		return "04/front_saleTicket/Booking2";
	}
	//清空購物車
	@Hibernate
	@RequestMapping(path = "/04/delectCart.ctrl", method = RequestMethod.GET)
	public String delectCart(Model model, HttpSession session, HttpServletRequest Request) {
		// 移除shoppingcart
		session.removeAttribute("shoppingcart");
		session.removeAttribute("shoppingcartnum");

		return "04/front_saleTicket/Booking2";
	}

	// 儲存訂單
	@Hibernate
	@RequestMapping(path = "/04/SaveCart.ctrl", method = RequestMethod.GET)
	public String SaveCart(Model model, HttpSession session, HttpServletRequest Request) throws MessagingException, IOException, NotFoundException, WriterException {

		shoppingcart = (Shoppingcart) session.getAttribute("shoppingcart");
		String orderlistID = shoppingcartService.getOrderIdByTime();		
		String[] seats = shoppingcart.getSeats();
		String actno =Integer.toString(shoppingcart.getACT_ID());
		int ticketnum=shoppingcart.getTICKET_NUM();
		seatBean =(SeatBean) session.getAttribute("seatBean");
		seatBeanService.updateSeatnum(shoppingcart.getACT_ID(),seatBean.getSEATNUM()-ticketnum);
		switch (ticketnum) {
		case 1:
			seatBeanService.insert1Seat(seats,actno);
			break;
		case 2:
			seatBeanService.insert2Seat(seats,actno);
			break;
		case 3:
			seatBeanService.insert3Seat(seats,actno);
			break;
		default:
			seatBeanService.insert4Seat(seats,actno);
			break;
		}
		//將Arry轉為String存入DB
		String seatsString = Arrays.toString(seats);
		System.out.println("seatsString" + seatsString);
		shoppingcart.setSeatstring(seatsString);
		//orderid存入shoppingcart
		shoppingcart.setORDERID(orderlistID);
		shoppingcart.setSTATUS("已付款");
		shoppingcartService.insert(shoppingcart);
		System.out.println("訂單已成立");
		qrcodetool.QRCode(shoppingcart);
		//寄訂單詳細mail

		emailServiceImpl.processmailsendHTML(shoppingcart);
			
//		model.addAttribute("orderlistID", orderlistID);
//		model.addAttribute("email", shoppingcart.getEMAIL());
		session.setAttribute("orderlistID", orderlistID);
		session.setAttribute("email", shoppingcart.getEMAIL());

		//綠界傳值
		PaymentImpl payment = new PaymentImpl();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
		String dateString = sdFormat.format(today);
		Integer totalAmount =shoppingcart.getTOTALPRICE();
		String title =shoppingcart.getTITLE();
		System.out.println(title);
		String genAioCheckOutALL = payment.genAioCheckOutALL(dateString, Integer.toString(totalAmount),title);


		session.setAttribute("form", genAioCheckOutALL);

		
		//清空購物車,未購數量
		session.removeAttribute("shoppingcart");
		session.removeAttribute("shoppingcartnum");
		//傳至綠界
//		return "04/front_Orderlist/EcPay";
		return "04/front_Orderlist/ThxOrder";
	}
	@Hibernate
	@RequestMapping(path = "/04/goshoppingcart.ctrl", method = RequestMethod.GET)
	public String goshoppingcart(Model model, HttpSession session, HttpServletRequest Request) {
		
		WebsiteMember member = (WebsiteMember) session.getAttribute("member");
		if (member == null) {
			return "redirect:/35/loginEntry";
		} else {	
			return "04/front_saleTicket/Booking2";
		}
	}
	

}
