package tw.group4._03_.cms.util;

import java.util.Calendar;
import java.util.Date;

public class CheckReservationTime {
	/**
	 * 判斷指定時間是否在[startTime, endTime]之間，注意時間格式要一致
	 * 
	 * @param checkTime 指定的時間
	 * @param startTime 開始的時間
	 * @param endTime   結束的時間
	 * @return
	 */

	public boolean checkReservationTime(Date checkStartTime, Date checkEndTime, Date startTime, Date endTime) {

		if (checkStartTime.getTime() == startTime.getTime() || checkEndTime.getTime() == endTime.getTime()) {
			return true;
		}

		Calendar checkStart = Calendar.getInstance();
		checkStart.setTime(checkStartTime);

		Calendar checkEnd = Calendar.getInstance();
		checkEnd.setTime(checkEndTime);

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if ((checkStart.after(begin) && checkStart.before(end)) || (checkEnd.after(begin) && checkEnd.before(end))) {
			return true;
		} else {
			return false;
		}
	}

}
