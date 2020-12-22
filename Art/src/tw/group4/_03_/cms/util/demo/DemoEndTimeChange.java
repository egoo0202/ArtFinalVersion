package tw.group4._03_.cms.util.demo;

import tw.group4._03_.cms.util.CustomizedTimeChange;

public class DemoEndTimeChange {

	public static void main(String[] args) {
		
		CustomizedTimeChange xyz = new CustomizedTimeChange();
		
		String time = "9:00";
		
		String changeTime = xyz.timeChange(time, -1);
		
		System.out.println("輸入時間: "+ time + "得出時間: " + changeTime);
	}

}
