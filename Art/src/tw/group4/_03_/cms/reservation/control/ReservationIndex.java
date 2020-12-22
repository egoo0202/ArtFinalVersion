package tw.group4._03_.cms.reservation.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4.util.Hibernate;

@Controller
public class ReservationIndex {

	@Autowired
	public ShopReservationService srs;

	@Hibernate
	@RequestMapping(path = "/03/cms/reservation/reservationIndex.ctrl", method = RequestMethod.GET)
	public String reservationIndex(Model m) {
		try {
			List<ShopReservationBean> reservationList = srs.selectAll();
			
			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "搜尋出錯，請重新查詢";
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			String reservationSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return "03/cms_reservation/reservation_index";
	}
}
