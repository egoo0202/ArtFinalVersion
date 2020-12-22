package tw.group4._03_.cms.util.demo;

import tw.group4._03_.cms.util.GetDate;

public class DemoGetDate {

	public static void main(String[] args) {
		GetDate a = new GetDate();
		
		 int day1 = a.getDaysByYearMonth(2019, 02);
		 int day2 = a.getDaysByYearMonth(2020, 02);
		 int day3 = a.getDaysByYearMonth(2015, 01);
		 int day4 = a.getDaysByYearMonth(2020, 10);
		 int day5 = a.getDaysByYearMonth(1900, 12);
		 int day6 = a.getDaysByYearMonth(2050, 01);
		 int day7 = a.getDaysByYearMonth(2005, 06);
		 
		 System.out.println("testDay1 = "+day1);
		 System.out.println("testDay2 = "+day2);
		 System.out.println("testDay3 = "+day3);
		 System.out.println("testDay4 = "+day4);
		 System.out.println("testDay5 = "+day5);
		 System.out.println("testDay6 = "+day6);
		 System.out.println("testDay7 = "+day7);
		 
	}
}
