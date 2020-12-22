package tw.group4._03_.cms.reservation.model;

import java.util.List;

public interface IShopReservationBean {

	public boolean checkReservationNo(int reservationNo);

	public ShopReservationBean insert(ShopReservationBean bean);

	public ShopReservationBean select(int reservationNo);

	public List<ShopReservationBean> selectByNo(int reservationNo);

	public List<ShopReservationBean> selectByMemberId(int memberId);
	
	// 5 #======================================

	public List<ShopReservationBean> selectByMemberName(String memberName);

	public List<ShopReservationBean> selectByDateTime(String dateTime);

	public List<ShopReservationBean> selectAll();

	public ShopReservationBean update(int reservationNo, int memberId, String memberName, String customerName,
			String customerPhone, int adultsNum, int childrenNum, int amount, String dateTime, String time,
			int payment, String note, int gender, String email, int purpose);

	public boolean delete(int reservationNo);

	// 10 #======================================

	public boolean deleteByMemberIdAndDateAndTime(int memberId, String dateTime, String time);

}
