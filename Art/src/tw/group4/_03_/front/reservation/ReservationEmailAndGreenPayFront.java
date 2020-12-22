package tw.group4._03_.front.reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.reservation.model.GreenPayDAO;
import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4.util.Hibernate;

@Controller
public class ReservationEmailAndGreenPayFront {

	@Autowired
	public ShopReservationService srs;

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/pay.ctrl", method = RequestMethod.POST)
	public String updateReservationAmount(@RequestParam(name = "reservationNo") String reservationNo,
			HttpSession session, Model m) {

		// 以訂位號獲得訂位資訊
		int no = Integer.parseInt(reservationNo);
		List<ShopReservationBean> reservationList = srs.selectByNo(no);
		ShopReservationBean reservation = reservationList.get(0);

		// # 處理綠界需求資料

		// 一、日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
		String sDate = sdf.format(today);

		// 二、價格
		int totalPrice = (reservation.getAdultsNum() * 650) + (reservation.getChildrenNum() * 350);
		String price = Integer.toString(totalPrice);

		// 訂位詳情
		String paymentInfo = "大人 " + reservation.getAdultsNum() + "位 小孩 " + reservation.getChildrenNum() + "位";

		// # 轉跳綠界
		GreenPayDAO green = new GreenPayDAO();
		String greenPayPage = green.greenPayPage(sDate, price, paymentInfo);
		session.setAttribute("greenPage", greenPayPage);
		
		// 設定付款回傳訂單號
		session.setAttribute("greenReservationNo", reservationNo);
		
		return "03/front_reservation/reservation_transmitting";

	}


}