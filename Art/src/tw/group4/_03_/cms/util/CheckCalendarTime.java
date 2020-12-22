package tw.group4._03_.cms.util;

import java.util.Calendar;
import java.util.Date;

public class CheckCalendarTime {
	/**
	 * 判斷結束的時間[endTime]在開始的時間[startTime]之後，注意時間格式要一致
	 * 
	 * @param startTime 開始的時間
	 * @param endTime   結束的時間
	 * @return
	 */

	public boolean checkCalendarTime(Date startTime, Date endTime) {

		Calendar begin = Calendar.getInstance();
		begin.setTime(startTime);

		Calendar end = Calendar.getInstance();
		end.setTime(endTime);

		if ((begin.before(end))) {
			return true;
		} else {
			return false;
		}
	}
}
