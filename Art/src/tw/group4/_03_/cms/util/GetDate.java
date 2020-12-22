package tw.group4._03_.cms.util;

import java.util.Calendar;

public class GetDate {

	public int getDaysByYearMonth(int year, int month) {

		Calendar now = Calendar.getInstance();
		now.set(Calendar.YEAR, year);
		now.set(Calendar.MONTH, month - 1);
		now.set(Calendar.DATE, 1);
		now.roll(Calendar.DATE, -1);
		int daysNumber = now.get(Calendar.DATE);
		return daysNumber;
	}
}
