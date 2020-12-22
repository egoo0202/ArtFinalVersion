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
public class UpdateReservationFront {

	@Autowired
	public RestaurantService rs;

	@Autowired
	public ShopReservationService srs;

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/updateReservationAmount.ctrl", method = RequestMethod.POST)
	public String updateReservationAmount(@RequestParam(name = "reservationNo") String reservationNo, Model m) {

		try {
			// 以訂位號獲得訂位資訊
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);
			ShopReservationBean reservation = reservationList.get(0);

			// 獲得該時段的剩餘座位數
			List<RestaurantBean> restaurantList = rs.selectByDateTime(reservation.getDateTime());
			RestaurantBean restaurant = restaurantList.get(0);

			if (reservation.getTime().equals("09:00")) {
				String moment = "上午9點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH09();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("10:00")) {
				String moment = "上午10點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH10();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("11:00")) {
				String moment = "上午11點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH11();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("12:00")) {
				String moment = "中午12點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH12();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("13:00")) {
				String moment = "下午1點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH13();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("14:00")) {
				String moment = "下午2點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH14();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("15:00")) {
				String moment = "下午3點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH15();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("16:00")) {
				String moment = "下午4點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH16();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("17:00")) {
				String moment = "下午5點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH17();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("18:00")) {
				String moment = "晚上6點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH18();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("19:00")) {
				String moment = "晚上7點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH19();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("20:00")) {
				String moment = "晚上8點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH20();
				m.addAttribute("remainingNum", remainingNum);

			} else if (reservation.getTime().equals("21:00")) {
				String moment = "晚上9點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH21();
				m.addAttribute("remainingNum", remainingNum);

			} else {
				String moment = "中午12點";
				m.addAttribute("moment", moment);
				int remainingNum = restaurant.getH12();
				m.addAttribute("remainingNum", remainingNum);

			}

			m.addAttribute("reservation", reservation);
			m.addAttribute("restaurant", restaurant);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("搜尋出錯，請重新查詢");
		}
		return "03/front_reservation/update_choose_number";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/updateAmountExecute.ctrl", method = RequestMethod.POST)
	public String updateAmountExecute(@RequestParam(name = "reservationNo") String reservationNo,

			@RequestParam(name = "newAdultsNum") String newAdultsNum,
			@RequestParam(name = "newChildrenNum") String newChildrenNum, Model m) {
		try {

			// 以訂位號獲得訂位資訊
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);
			ShopReservationBean reservation = reservationList.get(0);

			// 產生時間 日期 總人數 資料
			String time = reservation.getTime();
			String dateTime = reservation.getDateTime();
			int amount = reservation.getAmount();

			// 更新訂位時刻表的剩餘座位數
			List<RestaurantBean> restaurantList = rs.selectByDateTime(dateTime);
			RestaurantBean restaurant = restaurantList.get(0);

			if (time.equals("09:00")) {
				// debug
				int num1 = restaurant.getH09();
				int num2 = amount;
				int num3 = Integer.parseInt(newAdultsNum);
				int num4 = Integer.parseInt(newChildrenNum);
				int num5 = num1 + num2 - num3 - num4;
				System.out.println("有進入09:00迴圈");
				System.out.println(num1);
				System.out.println(num2);
				System.out.println(num3);
				System.out.println(num4);
				System.out.println(num5);

				// 剩餘座位數，先加上原始訂位人數，再減去新訂位人數
				int num = restaurant.getH09() + amount - Integer.parseInt(newAdultsNum)
						- Integer.parseInt(newChildrenNum);
				//debug
				System.out.println(num);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), num, restaurant.getH10(), restaurant.getH11(),
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("10:00")) {
				int num = restaurant.getH10() + amount - Integer.parseInt(newAdultsNum)
						- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), num, restaurant.getH11(),
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("11:00")) {
				int num = restaurant.getH11() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(), num,
						restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("12:00")) {
				int num = restaurant.getH12() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), num, restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("13:00")) {
				int num = restaurant.getH13() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), num, restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("14:00")) {
				int num = restaurant.getH14() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), num, restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("15:00")) {
				int num = restaurant.getH15() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(), num,
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("16:00")) {
				int num = restaurant.getH16() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), num, restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("17:00")) {
				int num = restaurant.getH17() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), num, restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("18:00")) {
				int num = restaurant.getH18() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), num, restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("19:00")) {
				int num = restaurant.getH19() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), num,
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("20:00")) {
				int num = restaurant.getH20() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(),
						restaurant.getH19(), num, restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());

			} else if (time.equals("21:00")) {
				int num = restaurant.getH21() + amount - Integer.parseInt(newAdultsNum)
				- Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), restaurant.getH12(), restaurant.getH13(), restaurant.getH14(),
						restaurant.getH15(), restaurant.getH16(), restaurant.getH17(), restaurant.getH18(),
						restaurant.getH19(), restaurant.getH20(), num, restaurant.getMaximum(), restaurant.getOpen());

			} else {
				int num = restaurant.getH12() + amount - Integer.parseInt(newAdultsNum) - Integer.parseInt(newChildrenNum);

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(),
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), restaurant.getH10(),
						restaurant.getH11(), num, restaurant.getH13(), restaurant.getH14(), restaurant.getH15(),
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), restaurant.getH19(),
						restaurant.getH20(), restaurant.getH21(), restaurant.getMaximum(), restaurant.getOpen());
			}

			// 新的總人數 資料
			int newAmount = (Integer.parseInt(newAdultsNum) + Integer.parseInt(newChildrenNum));
			//debug
			System.out.println("新的訂位總人數為" + newAmount);

			// 更新訂位資料
			srs.update(reservation.getReservationNo(), reservation.getMemberId(), reservation.getMemberName(),
					reservation.getCustomerName(), reservation.getCustomerPhone(), Integer.parseInt(newAdultsNum),
					Integer.parseInt(newChildrenNum), newAmount, reservation.getDateTime(), reservation.getTime(),
					reservation.getPayment(), reservation.getNote(), reservation.getGender(), reservation.getEmail(),
					reservation.getPurpose());

			String reservationUpdateMsg = "用餐人數已修改";
			m.addAttribute("reservationUpdateMsg", reservationUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String reservationErrorMsg = "用餐人數修改失敗，請重試";
			m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/update_return";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/updateReservationInfo.ctrl", method = RequestMethod.POST)
	public String updateReservationInfo(@RequestParam(name = "reservationNo") String reservationNo, Model m) {
		try {
			// 以訂位號獲得訂位資訊
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);
			ShopReservationBean reservation = reservationList.get(0);

			m.addAttribute("reservation", reservation);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改訂位資訊出錯");
		}
		return "03/front_reservation/update_info";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/updateInfoExecute.ctrl", method = RequestMethod.POST)
	public String updateInfoExecute(
			@RequestParam(name = "reservationNo") String reservationNo,

			@RequestParam(name = "customerName") String customerName,
			@RequestParam(name = "customerPhone") String customerPhone, 
			@RequestParam(name = "note") String note,
			@RequestParam(name = "gender") int gender, 
			@RequestParam(name = "email") String email,
			@RequestParam(name = "purpose") int purpose, Model m) {
		try {
			// 以訂位號獲得訂位資訊
			int no = Integer.parseInt(reservationNo);
			List<ShopReservationBean> reservationList = srs.selectByNo(no);
			ShopReservationBean reservation = reservationList.get(0);

			// 更新聯絡資訊
			srs.update(reservation.getReservationNo(), reservation.getMemberId(), reservation.getMemberName(),
					customerName, customerPhone, reservation.getAdultsNum(), reservation.getChildrenNum(),
					reservation.getAmount(), reservation.getDateTime(), reservation.getTime(), reservation.getPayment(),
					note, gender, email, purpose);

			String reservationUpdateMsg = "聯絡資訊已修改";
			m.addAttribute("reservationUpdateMsg", reservationUpdateMsg);

		} catch (Exception e) {
			e.printStackTrace();
			String reservationErrorMsg = "聯絡資訊修改失敗，請重試";
			m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/update_return";
	}

}
