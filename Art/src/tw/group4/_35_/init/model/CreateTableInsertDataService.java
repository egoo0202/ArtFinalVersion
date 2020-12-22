package tw.group4._35_.init.model;

import tw.group4._35_.init.dao.DataForDB;
import tw.group4._35_.init.dao.TableForDB;

public class CreateTableInsertDataService {
	
	public void execute35() {
		
		executeOrder();
		
		System.out.println("資料庫初始化完畢");

	}
	
	public void executeOrder() {
		
		TableForDB tableForDB = new TableForDB();
		DataForDB dataForDB = new DataForDB();
		
//		創建所需表格
		tableForDB.dropTableActivity();
		tableForDB.createTableActivity();
		tableForDB.dropTablePosition();
		tableForDB.createTablePosition();
		tableForDB.dropTableWebsiteMember();
		tableForDB.createTableWebsiteMember();
//		下方訂單系列這次沒有寫道
//		tableForDB.dropTableBURI();
//		tableForDB.createTableBURI();
//		tableForDB.dropTableBUR();
//		tableForDB.createTableBUR();
		
//		我的旅程表格
		tableForDB.dropTableMyJourney();
		tableForDB.createTableMyJourney();
//		活動場地表格
		tableForDB.dropTableEventSpace();
		tableForDB.createTableEventSpace();
		
//		Activity表格插入資料
		dataForDB.actWriteDB(); //寫入資料到資料庫內的Activity表格
		dataForDB.stringWriteCSV(); //輸出為轉換經緯度而產出的csv檔

//		Position表格插入資料
		dataForDB.ptActWriteDB(); //寫入資料到資料庫內的Position表格
		
//		EventSpace表格插入資料
		dataForDB.esWriteDB(); //Hibernate練習始祖
//		WebsiteMember表格插入資料
		dataForDB.wmWriteDB(); //Hibernate練習始祖
	}

}
