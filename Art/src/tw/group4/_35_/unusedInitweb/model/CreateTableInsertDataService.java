package tw.group4._35_.unusedInitweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._35_.unusedInitweb.dao.DataForDB;
import tw.group4._35_.unusedInitweb.dao.TableForDB;

@Service
public class CreateTableInsertDataService {
	
	private TableForDB tableForDB;
	
	private DataForDB dataForDB;
	
	@Autowired
	public CreateTableInsertDataService(TableForDB tableForDB, DataForDB dataForDB) {
		this.tableForDB = tableForDB;
		this.dataForDB = dataForDB;
	}
	
	public void executeOrder() {
		
//		創建所需表格
		tableForDB.dropTableActivity();
		tableForDB.createTableActivity();
		tableForDB.dropTablePosition();
		tableForDB.createTablePosition();
		tableForDB.dropTableMember();
		tableForDB.createTableMember();
		tableForDB.dropTableBURI();
		tableForDB.createTableBURI();
		tableForDB.dropTableBUR();
		tableForDB.createTableBUR();
		
		//CRUD練習用表格
		tableForDB.dropTableEventSpace();
		tableForDB.createTableEventSpace();
		tableForDB.dropTableSponsorship();
		tableForDB.createTableSponsorship();
		
//		Activity表格插入資料
		dataForDB.actWriteDB(); //寫入資料到資料庫內的Activity表格
		
		dataForDB.stringWriteCSV(); //輸出為轉換經緯度而產出的csv檔
		
//		Position表格插入資料
		dataForDB.ptActWriteDB(); //寫入資料到資料庫內的Position表格
		
//		EventSpace表格插入資料
		dataForDB.esWriteDB(); //Hibernate練習始祖
	}

}
