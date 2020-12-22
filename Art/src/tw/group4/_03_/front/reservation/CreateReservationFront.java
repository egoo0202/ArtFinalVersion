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
import tw.group4._03_.cms.restaurant.model.RestaurantBean;
import tw.group4._03_.cms.restaurant.model.RestaurantService;
import tw.group4._35_.login.model.WebsiteMember;
import tw.group4.util.Hibernate;

@Controller
public class CreateReservationFront {

	@Autowired
	public RestaurantService rs;
	
	@Autowired
	public ShopReservationService srs;
	
	@RequestMapping(path = "/03/front/reservation/chooseNumberAndDate", method = RequestMethod.GET)
	public String chooseNumberAndDate(Model m) {
		return "03/front_reservation/choose_number_and_date";
	}
	
	@Hibernate
	@RequestMapping(path = "/03/front/reservation/chooseTime.ctrl", method = RequestMethod.POST)
	public String chooseTime(
			@RequestParam(name = "adultsNum") String adultsNum,
			@RequestParam(name = "childrenNum") String childrenNum, 
			@RequestParam(name = "dateTime") String dateTime,
			Model m) {

		try {
			// debug 查看dateTime格式是否正確
			System.out.println(dateTime);
			
			// #取得指定日期行事曆的最大人數資料與營業時間
			List<RestaurantBean> restaurantList = rs.selectByDateTime(dateTime);

			if (restaurantList.size() != 0) {
				RestaurantBean restaurant = restaurantList.get(0);

				int aNum = Integer.parseInt(adultsNum);
				int cNum = Integer.parseInt(childrenNum);
				int amount = aNum + cNum;

				// 上一個頁面回傳的 訂位資訊
				m.addAttribute("adultsNum", adultsNum);
				m.addAttribute("childrenNum", childrenNum);
				m.addAttribute("amount", amount);
				m.addAttribute("dateTime", dateTime);
				// 該日行事曆Bean
				m.addAttribute("restaurant", restaurant);
				
				// 處理預約回傳值 
				// 生成表示剩餘座位數的訊息字串(1. 訂位已額滿  2. 非營業時段  3. 剩餘剩餘剩餘座位數不足)
				// 已額滿 = H00Full
				// 不可訂位 = H00Close
				// 正常訂位 = H00

				// H09
				if (restaurant.getH09() == 0) {
					m.addAttribute("H09Full", "訂位已額滿");
				} else if (restaurant.getH09() == -1) {
					m.addAttribute("H09Close", "不可預訂時段");
				} else if (restaurant.getH09() != 0 && restaurant.getH09() != -1 && amount > restaurant.getH09()) {
					m.addAttribute("H09Over", "剩餘座位不足");
				} else {
					m.addAttribute("H09", restaurant.getH09());
				}

				// H10
				if (restaurant.getH10() == 0) {
					m.addAttribute("H10Full", "已額滿");
				} else if (restaurant.getH10() == -1) {
					m.addAttribute("H10Close", "不可預訂時段");
				} else if (restaurant.getH10() != 0 && restaurant.getH10() != -1 && amount > restaurant.getH10()) {
					m.addAttribute("H10Over", "剩餘座位不足");
				} else {
					m.addAttribute("H10", restaurant.getH10());
				}

				// H11
				if (restaurant.getH11() == 0) {
					m.addAttribute("H11Full", "已額滿");
				} else if (restaurant.getH11() == -1) {
					m.addAttribute("H11Close", "不可預訂時段");
				} else if (restaurant.getH11() != 0 && restaurant.getH11() != -1 && amount > restaurant.getH11()) {
					m.addAttribute("H11Over", "剩餘座位不足");
				} else {
					m.addAttribute("H11", restaurant.getH11());
				}

				// H12
				if (restaurant.getH12() == 0) {
					m.addAttribute("H12Full", "已額滿");
				} else if (restaurant.getH12() == -1) {
					m.addAttribute("H12Close", "不可預訂時段");
				} else if (restaurant.getH12() != 0 && restaurant.getH12() != -1 && amount > restaurant.getH12()) {
					m.addAttribute("H12Over", "剩餘座位不足");
				} else {
					m.addAttribute("H12", restaurant.getH12());
				}

				// H13
				if (restaurant.getH13() == 0) {
					m.addAttribute("H13Full", "已額滿");
				} else if (restaurant.getH13() == -1) {
					m.addAttribute("H13Close", "不可預訂時段");
				} else if (restaurant.getH13() != 0 && restaurant.getH13() != -1 && amount > restaurant.getH13()) {
					m.addAttribute("H13Over", "剩餘座位不足");
				} else {
					m.addAttribute("H13", restaurant.getH13());
				}

				// H14
				if (restaurant.getH14() == 0) {
					m.addAttribute("H14Full", "已額滿");
				} else if (restaurant.getH14() == -1) {
					m.addAttribute("H14Close", "不可預訂時段");
				} else if (restaurant.getH14() != 0 && restaurant.getH14() != -1 && amount > restaurant.getH14()) {
					m.addAttribute("H14Over", "剩餘座位不足");
				} else {
					m.addAttribute("H14", restaurant.getH14());
				}

				// H15
				if (restaurant.getH15() == 0) {
					m.addAttribute("H15Full", "已額滿");
				} else if (restaurant.getH15() == -1) {
					m.addAttribute("H15Close", "不可預訂時段");
				} else if (restaurant.getH15() != 0 && restaurant.getH15() != -1 && amount > restaurant.getH15()) {
					m.addAttribute("H15Over", "剩餘座位不足");
				} else {
					m.addAttribute("H15", restaurant.getH15());
				}

				// H16
				if (restaurant.getH16() == 0) {
					m.addAttribute("H16Full", "已額滿");
				} else if (restaurant.getH16() == -1) {
					m.addAttribute("H16Close", "不可預訂時段");
				} else if (restaurant.getH16() != 0 && restaurant.getH16() != -1 && amount > restaurant.getH16()) {
					m.addAttribute("H16Over", "剩餘座位不足");
				} else {
					m.addAttribute("H16", restaurant.getH16());
				}

				// H17
				if (restaurant.getH17() == 0) {
					m.addAttribute("H17Full", "已額滿");
				} else if (restaurant.getH17() == -1) {
					m.addAttribute("H17Close", "不可預訂時段");
				} else if (restaurant.getH17() != 0 && restaurant.getH17() != -1 && amount > restaurant.getH17()) {
					m.addAttribute("H17Over", "剩餘座位不足");
				} else {
					m.addAttribute("H17", restaurant.getH17());
				}

				// H18
				if (restaurant.getH18() == 0) {
					m.addAttribute("H18Full", "已額滿");
				} else if (restaurant.getH18() == -1) {
					m.addAttribute("H18Close", "不可預訂時段");
				} else if (restaurant.getH18() != 0 && restaurant.getH18() != -1 && amount > restaurant.getH18()) {
					m.addAttribute("H18Over", "剩餘座位不足");
				} else {
					m.addAttribute("H18", restaurant.getH18());
				}

				// H19
				if (restaurant.getH19() == 0) {
					m.addAttribute("H19Full", "已額滿");
				} else if (restaurant.getH19() == -1) {
					m.addAttribute("H19Close", "不可預訂時段");
				} else if (restaurant.getH19() != 0 && restaurant.getH19() != -1 && amount > restaurant.getH19()) {
					m.addAttribute("H19Over", "剩餘座位不足");
				} else {
					m.addAttribute("H19", restaurant.getH19());
				}

				// H20
				if (restaurant.getH20() == 0) {
					m.addAttribute("H20Full", "已額滿");
				} else if (restaurant.getH20() == -1) {
					m.addAttribute("H20Close", "不可預訂時段");
				} else if (restaurant.getH20() != 0 && restaurant.getH20() != -1 && amount > restaurant.getH20()) {
					m.addAttribute("H20Over", "剩餘座位不足");
				} else {
					m.addAttribute("H20", restaurant.getH20());
				}

				// H21
				if (restaurant.getH21() == 0) {
					m.addAttribute("H21Full", "已額滿");
				} else if (restaurant.getH21() == -1) {
					m.addAttribute("H21Close", "不可預訂時段");
				} else if (restaurant.getH21() != 0 && restaurant.getH21() != -1 && amount > restaurant.getH21()) {
					m.addAttribute("H21Over", "剩餘座位不足");
				} else {
					m.addAttribute("H21", restaurant.getH21());
				}

				if (restaurant.getOpen() == 0) {
					String reservationErrorMsg = "很抱歉，當天為非營業時段";
					m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳非營業日訊息
				}
				
			} else {
				String reservationErrorMsg = "很抱歉，當天暫不開放預約";
				m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳錯誤訊息
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "03/front_reservation/choose_time";
	}

	@Hibernate
	@RequestMapping(path = "/03/front/reservation/createReservationConfirm.ctrl", method = RequestMethod.POST)
	public String createReservationConfirm(
			@RequestParam(name = "adultsNum") String adultsNum, 
			@RequestParam(name = "childrenNum") String childrenNum,
			@RequestParam(name = "amount") String amount,
			@RequestParam(name = "dateTime") String dateTime,
			@RequestParam(name = "time") String time, 
			@RequestParam(name = "year") String year, 
			@RequestParam(name = "month") String month, 
			@RequestParam(name = "day") String day, 
			Model m) {
		try {
			m.addAttribute("adultsNum", adultsNum);
			m.addAttribute("childrenNum", childrenNum);
			m.addAttribute("amount", amount);
			m.addAttribute("dateTime", dateTime);
			m.addAttribute("time", time);
			
			m.addAttribute("year", year);
			m.addAttribute("month", month);
			m.addAttribute("day", day);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "03/front_reservation/create_confirm";
	}
	
	@Hibernate
	@RequestMapping(path = "/03/front/reservation/createReservation.ctrl", method = RequestMethod.POST)
	public String createReservation(
			@RequestParam(name = "customerName") String customerName,
			@RequestParam(name = "customerPhone") String customerPhone,
			
			@RequestParam(name = "adultsNum") String adultsNum, 
			@RequestParam(name = "childrenNum") String childrenNum,
			@RequestParam(name = "amount") String amount,
			@RequestParam(name = "dateTime") String dateTime,
			@RequestParam(name = "time") String time, 
			
			@RequestParam(name = "note") String note, 
			@RequestParam(name = "gender") String gender, 
			@RequestParam(name = "email") String email, 
			@RequestParam(name = "purpose") String purpose,
			HttpSession session,
			Model m) {
		try {
			// 執行流程: 1.  獲得 memberId 
			//           2.  使用訂位人資訊加上帳號資訊，建立訂位資料(insert)
			//			 3.  更新訂位時刻表的剩餘座位數
			
			// 從HttpSession中，獲得memberId
			WebsiteMember member = (WebsiteMember) session.getAttribute("member");
			int memberId = member.getId();
			String memberName = member.getName();
			ShopReservationBean reservation = new ShopReservationBean();
			
			// debug
			System.out.println(time);
			
			reservation.setMemberId(memberId);
			reservation.setMemberName(memberName);
			reservation.setCustomerName(customerName);
			reservation.setCustomerPhone(customerPhone);
			
			reservation.setAdultsNum(Integer.parseInt(adultsNum));
			reservation.setChildrenNum(Integer.parseInt(childrenNum));
			reservation.setAmount(Integer.parseInt(amount));
			reservation.setDateTime(dateTime);
			reservation.setTime(time);
			
			reservation.setPayment(0);
			reservation.setNote(note);
			reservation.setGender(Integer.parseInt(gender));
			reservation.setEmail(email);
			reservation.setPurpose(Integer.parseInt(purpose));

			srs.insert(reservation);

			// 更新訂位時刻表的剩餘座位數
			List<RestaurantBean> restaurantList = rs.selectByDateTime(dateTime);
			RestaurantBean restaurant = restaurantList.get(0);
			
			if(time.equals("09:00")) {
				int num = restaurant.getH09() - (Integer.parseInt(amount));
				
				// debug
				System.out.println(restaurant.getH09());
				System.out.println(Integer.parseInt(amount));
				System.out.println(num);
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), num, 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
				
			}else if (time.equals("10:00")) {
				int num = restaurant.getH10() - (Integer.parseInt(amount));

				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						num, restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
				
			}else if (time.equals("11:00")) {
				int num = restaurant.getH11() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), num, restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("12:00")) {
				int num = restaurant.getH12() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), num, 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("13:00")) {
				int num = restaurant.getH13() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						num, restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("14:00")) {
				int num = restaurant.getH14() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), num, restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("15:00")) {
				int num = restaurant.getH15() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), num, 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("16:00")) {
				int num = restaurant.getH16() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						num, restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("17:00")) {
				int num = restaurant.getH17() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), num, restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("18:00")) {
				int num = restaurant.getH18() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), num, 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("19:00")) {
				int num = restaurant.getH19() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						num, restaurant.getH20(), restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("20:00")) {
				int num = restaurant.getH20() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), num, restaurant.getH21(), 
						restaurant.getMaximum(), restaurant.getOpen());
			}else if (time.equals("21:00")) {
				int num = restaurant.getH21() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), restaurant.getH12(), 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), num, 
						restaurant.getMaximum(), restaurant.getOpen());
			} else {
				int num = restaurant.getH12() - (Integer.parseInt(amount));
				
				rs.update(restaurant.getRestaurantNo(), restaurant.getDateTime(), restaurant.getYear(), 
						restaurant.getMonth(), restaurant.getDay(), restaurant.getH09(), 
						restaurant.getH10(), restaurant.getH11(), num, 
						restaurant.getH13(), restaurant.getH14(), restaurant.getH15(), 
						restaurant.getH16(), restaurant.getH17(), restaurant.getH18(), 
						restaurant.getH19(), restaurant.getH20(), restaurant.getH21(),
						restaurant.getMaximum(), restaurant.getOpen());
			}
			
			String reservationCreateMsg = "訂位完成";
			m.addAttribute("reservationCreateMsg", reservationCreateMsg);

		} catch (Exception e) {
			e.printStackTrace();

			String reservationErrorMsg = "系統錯誤，請重試";
			m.addAttribute("reservationErrorMsg", reservationErrorMsg); // 回傳錯誤訊息
		}
		return "03/front_reservation/create_return";
	}

}
