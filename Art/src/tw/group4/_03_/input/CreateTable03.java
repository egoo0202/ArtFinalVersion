package tw.group4._03_.input;

import java.util.ArrayList;

import tw.group4._03_.input.CreativeShop.CreateShopsTable;
import tw.group4._03_.input.CreativeShop.ShopsTable;
import tw.group4._03_.input.Restaurant.CreateRestaurantTable;
import tw.group4._03_.input.ShopReservation.CreateShopReservationTable;

public class CreateTable03 {

	public void executeCreateTable() {

		CreateShopsTable input = new CreateShopsTable();

		// 刪除舊的文創商店表格
		input.dropShopsTable();

		// 建立新的文創商店表格
		input.createShopsTableForDB();

		// 讀取Json轉換成list
		ArrayList<ShopsTable> list = input.readJsonToTable();

		// 將list讀進DB
		input.creatShopsInfoTable(list);
		
		// 將圖片存入資料庫
		input.insertPictureIntoTable();
		
		// =============================

		CreateShopReservationTable input2 = new CreateShopReservationTable();

		// 刪除舊的商店預約表格
		input2.dropShopReservationTable();

		// 建立新的商店預約表格 
		input2.createShopReservationTable();

		// =============================

//		CreateShopCalendarTable inpuOld = new CreateShopCalendarTable();

		// 刪除舊的預約行事歷表格
//		inpuOld.dropShopCalendarTable();
		
		// =============================
		
		CreateRestaurantTable input3 = new CreateRestaurantTable();
		
		// 刪除舊的食堂行事歷表格
		input3.dropRestaurantTable();
		
		// 建立新的食堂行事歷表格
		input3.createRestaurantTable();
		
		// =============================

	}
}
