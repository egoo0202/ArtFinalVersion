package tw.group4._03_.cms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomizedTimeChange {

	public String timeChange(String time, int x) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm"); // 24小時制
		Date date = null;
		try {
			date = format.parse(time);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, x);// 24小時制
		date = cal.getTime();
		cal = null;
		
		return format.format(date);
	}
	
}