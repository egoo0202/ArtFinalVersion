package tw.group4._18_._18_io.json;

import java.util.ArrayList;



public class TestOnly {

	public static void main(String[] args) {
				
		CourseDataInputJson jdbcdao = new CourseDataInputJson();
	
		jdbcdao.dropTable(); //刪除表格
		
		jdbcdao.createTable();//創建表格
		ArrayList<COURSE> list = jdbcdao.readJson();//讀取網路上的json
		jdbcdao.writeDB(list);//寫入資料到資料庫內的表格
		
	}

}
