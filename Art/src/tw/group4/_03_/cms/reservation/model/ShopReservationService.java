package tw.group4._03_.cms.reservation.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("shopReservationService")
public class ShopReservationService implements IShopReservationBean {

	@Autowired
	private ShopReservationDAO shopReservationDAO;

	@Override
	public boolean checkReservationNo(int reservationNo) {
		return shopReservationDAO.checkReservationNo(reservationNo);
	}

	@Override
	public ShopReservationBean insert(ShopReservationBean bean) {
		return shopReservationDAO.insert(bean);
	}

	@Override
	public ShopReservationBean select(int reservationNo) {
		return shopReservationDAO.select(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByNo(int reservationNo) {
		return shopReservationDAO.selectByNo(reservationNo);
	}

	@Override
	public List<ShopReservationBean> selectByMemberId(int memberId) {
		return shopReservationDAO.selectByMemberId(memberId);
	}

	// =====================
	
	@Override
	public List<ShopReservationBean> selectByMemberName(String memberName) {
		return shopReservationDAO.selectByMemberName(memberName);
	}
	
	@Override
	public List<ShopReservationBean> selectByDateTime(String dateTime){
		return shopReservationDAO.selectByDateTime(dateTime);
	}
	
	@Override
	public List<ShopReservationBean> selectAll() {
		return shopReservationDAO.selectAll();
	}

	@Override
	public ShopReservationBean update(
			int reservationNo, int memberId, String memberName, String customerName, String customerPhone, 
			int adultsNum, int childrenNum, int amount, String dateTime, String time,
			int payment, String note, int gender, String email, int purpose) {
		return shopReservationDAO.update( 
				reservationNo, memberId, memberName, customerName, customerPhone,
				adultsNum, childrenNum, amount, dateTime, time,
				payment, note, gender, email, purpose);
	}
	
	@Override
	public boolean delete(int reservationNo) {
		return shopReservationDAO.delete(reservationNo);
	}

	// =====================

	public boolean deleteByMemberIdAndDateAndTime(int memberId, String dateTime, String time) {
		return shopReservationDAO.deleteByMemberIdAndDateAndTime(memberId, dateTime, time);
	}

	
}
