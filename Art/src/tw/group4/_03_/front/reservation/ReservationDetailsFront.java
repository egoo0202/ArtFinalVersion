package tw.group4._03_.front.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4.util.Hibernate;

@Controller
public class ReservationDetailsFront {

	@Autowired
	public ShopReservationService srs;

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/checkReservationDetails.ctrl", method = RequestMethod.POST)
	public String checkReservationDetails(@RequestParam(name = "reservationNo") String reservationNo, Model m) {
		try {
			ShopReservationBean reservation = srs.select(Integer.parseInt(reservationNo));
			m.addAttribute("reservation", reservation);
		} catch (Exception e) {
			e.printStackTrace();

			String reservationCheckMsg = "系統出錯，請重試";
			m.addAttribute("reservationCheckMsg", reservationCheckMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/reservation_details";

	}
}
