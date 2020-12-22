package tw.group4._03_.front.reservation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4._14_.dashboard.dao.DashboardService;
import tw.group4._14_.dashboard.model.EntryClickRate;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class RedirectReservationControllerFront {

	@Autowired
	public ShopReservationService srs;
	
	@Autowired
	private DashboardService dbService;

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/onlineBooking.ctrl", method = RequestMethod.GET)
	public String onlineBooking(HttpSession session, Model m) {
		//
		
		EntryClickRate ecr = new EntryClickRate();
		ecr.setRestaurant(1);
		dbService.insert(ecr);
		//
		return "03/front_reservation/online_booking";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/myReservation.ctrl", method = RequestMethod.GET)
	public String redirectToMyReservation(HttpSession session, Model m) {

		try {

			// 設定綠界付款成功 更新訂位資料
			if (session.getAttribute("greenReservationNo") != null) {

				String greenReservationNo = (String) session.getAttribute("greenReservationNo");
				int no = Integer.parseInt(greenReservationNo);
				ShopReservationBean reservation = srs.select(no);

				// 付款完成
				srs.update(no, reservation.getMemberId(), reservation.getMemberName(),
						reservation.getCustomerName(), reservation.getCustomerPhone(), reservation.getAdultsNum(),
						reservation.getChildrenNum(), reservation.getAmount(), reservation.getDateTime(),
						reservation.getTime(), 1, reservation.getNote(), reservation.getGender(),
						reservation.getEmail(), reservation.getPurpose());

				// 從HttpSession中，獲得memberId
				WebsiteMember member = (WebsiteMember) session.getAttribute("member");
				int memberId = member.getId();

				// 取得該用戶的預約
				List<ShopReservationBean> reservationList = srs.selectByMemberId(memberId);

				if (reservationList.size() != 0) {
					m.addAttribute("reservationList", reservationList);
				} else {
					String reservationSerachMsg = "沒有訂位資料!";
					m.addAttribute("reservationSerachMsg", reservationSerachMsg);
				}

			} else {

				// 從HttpSession中，獲得memberId
				WebsiteMember member = (WebsiteMember) session.getAttribute("member");
				int memberId = member.getId();

				// 取得該用戶的預約
				List<ShopReservationBean> reservationList = srs.selectByMemberId(memberId);

				if (reservationList.size() != 0) {
					m.addAttribute("reservationList", reservationList);
				} else {
					String reservationSerachMsg = "沒有訂位資料!";
					m.addAttribute("reservationSerachMsg", reservationSerachMsg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "查詢出錯，請嘗試重新載入";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/my_reservation";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/cancelPayment.ctrl", method = RequestMethod.POST)
	public String cancelPayment(@RequestParam(name = "reservationNo") String reservationNo, HttpSession session, Model m) {

		try {

			// 取消付款成功 更新訂位資料
			ShopReservationBean reservation = srs.select(Integer.parseInt(reservationNo));

			srs.update(Integer.parseInt(reservationNo), reservation.getMemberId(), reservation.getMemberName(),
					reservation.getCustomerName(), reservation.getCustomerPhone(), reservation.getAdultsNum(),
					reservation.getChildrenNum(), reservation.getAmount(), reservation.getDateTime(),
					reservation.getTime(), 0, reservation.getNote(), reservation.getGender(), reservation.getEmail(),
					reservation.getPurpose());

			// 從HttpSession中，獲得memberId
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			int memberId = member.getId();

			// 取得該用戶的預約
			List<ShopReservationBean> reservationList = srs.selectByMemberId(memberId);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "沒有訂位資料!";
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}

		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "查詢出錯，請嘗試重新載入";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/my_reservation";
	}

}
