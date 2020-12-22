package tw.group4._03_.cms.util.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tw.group4._03_.cms.util.CheckCalendarTime;

public class DemoCheckCalendarTime {

	public static void main(String[] args) throws ParseException {
		
		String format = "HH:mm";
		Date startTime = new SimpleDateFormat(format).parse("15:30");
		Date endTime = new SimpleDateFormat(format).parse("09:59");
		CheckCalendarTime a = new CheckCalendarTime();
		
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(a.checkCalendarTime(startTime, endTime));
	}

}
