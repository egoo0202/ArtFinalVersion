package tw.group4._03_.cms.util.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tw.group4._03_.cms.util.CheckReservationTime;

public class DemoCheckTimeExecute {

	public static void main(String[] args) throws ParseException {
		
//		String format = "yyyy-mm-dd,HH:mm";
//		Date nowTime = new SimpleDateFormat(format).parse("2020-11-11,09:30");
//		Date nowTime2 = new SimpleDateFormat(format).parse("2020-11-11,09:55");
//		Date startTime = new SimpleDateFormat(format).parse("2020-11-11,09:30");
//		Date endTime = new SimpleDateFormat(format).parse("2020-11-11,09:59");
//		CheckReservationTime a = new CheckReservationTime();
//		
//		System.out.println(nowTime);
//		System.out.println(nowTime2);
//		System.out.println(startTime);
//		System.out.println(endTime);
//		System.out.println(a.checkReservationTime(nowTime, nowTime2, startTime, endTime));
		String format = "HH:mm";
		Date nowTime = new SimpleDateFormat(format).parse("09:30");
		Date nowTime2 = new SimpleDateFormat(format).parse("09:55");
		Date startTime = new SimpleDateFormat(format).parse("09:30");
		Date endTime = new SimpleDateFormat(format).parse("09:59");
		CheckReservationTime a = new CheckReservationTime();
		
		System.out.println(nowTime);
		System.out.println(nowTime2);
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(a.checkReservationTime(nowTime, nowTime2, startTime, endTime));
	}

}
