package tw.group4._04_.front.seat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.google.gson.Gson;

import oracle.net.aso.m;
import tw.group4._04_.back.cmsAct.model.ShowBean;
import tw.group4._04_.back.cmsAct.model.ShowBean2;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBean2;
import tw.group4._04_.front.seat.model.SeatBean3;
import tw.group4._04_.front.seat.model.SeatBeanDAO;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4._04_.front.shopcart.model.Shoppingcart;
import tw.group4.util.Hibernate;

@Controller
public class SeatCrud {

	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBean2 seatBean2;
	@Autowired
	private SeatBean3 seatBean3;
	@Autowired
	private SeatBeanService seatBeanService;
	@Autowired
	private Shoppingcart shoppingcart;

	// 查詢座位
	@Hibernate
	@RequestMapping(path = "/04/seatSearch.ctrl", method = RequestMethod.GET)
	public String seatSearch(Model model, HttpSession session, String ticketcategry, Integer ticketnum) {

		session.setAttribute("shoppingcartnum", ticketnum);
		int actid = (int) session.getAttribute("actid");
		shoppingcart.setACT_ID(actid);
		shoppingcart.setTITLE((String) (session.getAttribute("title")));
		shoppingcart.setTICKETCATEGORY(ticketcategry);
		shoppingcart.setTICKET_NUM(ticketnum);

		// shoppingcart存入session
		session.setAttribute("shoppingcart", shoppingcart);
		Map<String, Integer> seatMap = seatBeanService.select(actid);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		return "04/front_Seat/Seat";
	}

//	//電腦選位
	@Hibernate
	@RequestMapping(path = "/04/radomSeat.ctrl", method = RequestMethod.GET)
	public String radomSeat(Model model, HttpSession session, HttpServletRequest Request, String ticketcategry,
			Integer ticketnum) {

		// 購物車顯示數量
		session.setAttribute("shoppingcartnum", ticketnum);

		// 存入shoppingcart
		int actid = (int) session.getAttribute("actid");
		shoppingcart.setACT_ID(actid);
		shoppingcart.setTITLE((String) (session.getAttribute("title")));
		shoppingcart.setTICKETCATEGORY(ticketcategry);
		shoppingcart.setTICKET_NUM(ticketnum);

		// shoppingcart存入session

		List<String> seatlistList = new ArrayList();

		for (int j = 0; j < ticketnum; j++) {

			// 亂數A~E
			char Alphabet = (char) (int) (Math.random() * 5 + 65);
			Random random = new Random();
			// 亂數1~10
			String num = "";
			for (int i = 1; i < 2; i++) {
				num += random.nextInt(10) + 1;
			}

			String radomString = Alphabet + num;
			System.out.println(radomString);
			Integer seattpye = seatBeanService.search1seat(radomString, actid);
			System.out.println("seattpye" + seattpye);

			String seats[] = {};
			if (seattpye != null) {
				ticketnum = ticketnum + 1;
				System.out.println("座位已劃位");

			} else if (seatlistList.contains(radomString)) {
				ticketnum = ticketnum + 1;
				System.out.println("座位已重複");
			} else {
				// 重新選座位
				seatlistList.add(radomString);
				System.out.println(seatlistList.size());
			}
//			if (seattpye == null) {
//
//				seatlistList.add(radomString);
//			} else {
//				System.out.println("座位已劃位");
//				// 重新選座位
//				ticketnum = ticketnum + 1;
//			}

		}

		/* ArrayList to Array Conversion */
		String seats[] = new String[seatlistList.size()];
		for (int j = 0; j < seatlistList.size(); j++) {
			seats[j] = (String) seatlistList.get(j);
		}

		shoppingcart.setSeats(seats);
		session.setAttribute("shoppingcart", shoppingcart);

		return "04/front_saleTicket/Booking2";

	}

	// 查詢座位數量
	@Hibernate
	@RequestMapping(path = "/04/seatnumSearch.ctrl", method = RequestMethod.GET)
	@ResponseBody
	public String seatnumSearch(Integer actno,Model model, HttpSession session, String ticketcategry) {
//		Integer actno = 1;
		HashMap<String, Integer> seatnumMap = new HashMap<String, Integer>();
		Integer seatnum=seatBeanService.selectBean(actno).getSEATNUM();
		Integer seatnum2=seatBeanService.selectBean2(actno).getSEAT2NUM();
		Integer seatnum3=seatBeanService.selectBean3(actno).getSEAT3NUM();
		seatnumMap.put("seatnum", seatnum);
		seatnumMap.put("seatnum2", seatnum2);
		seatnumMap.put("seatnum3", seatnum3);
		Gson gson = new Gson();
		String json = gson.toJson(seatnumMap);
		return json;
	}

}
