package tw.group4._03_.front.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4._03_.cms.reservation.model.ShopReservationBean;
import tw.group4._03_.cms.reservation.model.ShopReservationService;
import tw.group4._03_.cms.restaurant.model.RestaurantBean;
import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4.util.Hibernate;

@Controller
public class DeleteReservationFront {

	@Autowired
	public RestaurantService rs;

	@Autowired
	public ShopReservationService srs;

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/deleteReservationByNo.ctrl", method = RequestMethod.POST)
	public String deleteReservationByNo(@RequestParam(name = "reservationNo") String reservationNo, Model m) {

		try {
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);

			if (reservationList.size() != 0) {
				m.addAttribute("reservationList", reservationList);
			} else {
				String reservationSerachMsg = "查無此預約資料，請重新查詢";
				System.out.println(reservationSerachMsg);
				m.addAttribute("reservationSerachMsg", reservationSerachMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();

			String reservationSerachMsg = "搜尋出錯，請重新查詢";
			m.addAttribute("reservationSerachMsg", reservationSerachMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/delete_confirm";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/deleteReservation.ctrl", method = RequestMethod.POST)
	public String deleteReservation(@RequestParam(name = "reservationNo") String reservationNo, Model m) {

		try {
			// 因為是以訂單號獲取資料
			// 所以順序上一定需先修改剩餘座位數
			// 不然座位數一定會出錯
			
			// 以訂位號獲得訂位資訊
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);
			ShopReservationBean reservation = reservationList.get(0);

			// 以訂位日期獲得的營業時間表
			List<RestaurantBean> restaurantList = rs.selectByDateTime(reservation.getDateTime());
			RestaurantBean restaurant = restaurantList.get(0);
			String time = reservation.getTime();
			int amount = reservation.getAmount();

			// 將該時段剩餘座位數
			// 加上要刪除訂位的訂位人數
			if (time.equals("09:00")) {
				int num = restaurant.getH09() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), num, restaurant.getH10(), restaurant.getH11(),
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("10:00")) {
				int num = restaurant.getH10() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), num, restaurant.getH11(),
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("11:00")) {
				int num = restaurant.getH11() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(), num,
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("12:00")) {
				int num = restaurant.getH12() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), num, restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("13:00")) {
				int num = restaurant.getH13() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), num, restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("14:00")) {
				int num = restaurant.getH14() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), num, restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("15:00")) {
				int num = restaurant.getH15() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), num,
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("16:00")) {
				int num = restaurant.getH16() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), num, restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("17:00")) {
				int num = restaurant.getH17() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), num, restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("18:00")) {
				int num = restaurant.getH18() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), num, restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("19:00")) {
				int num = restaurant.getH19() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), num,
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("20:00")) {
				int num = restaurant.getH20() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(),
						restaurant.getH19(), num, restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			} else if (time.equals("21:00")) {
				int num = restaurant.getH21() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(),
						restaurant.getH19(), restaurant.getH20(), num, restaurant.getMaximum(), restaurant.getOpen());
			} else {
				int num = restaurant.getH12() + amount;

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), num, restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			}

			// 刪除訂位
			srs.delete(no);
			System.out.println("訂位刪除成功");
			String reservationDeleteMsg = "訂位刪除成功";
			m.addAttribute("reservationDeleteMsg", reservationDeleteMsg);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("預約刪除失敗");
			String reservationErrorMsg = "預約刪除失敗";
			m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/delete_return";
	}

}
