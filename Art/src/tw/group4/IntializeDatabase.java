package tw.group4;

import tw.group4._03_.input.CreateTable03;
import tw.group4._04_.init.CreateTable;
import tw.group4._11_.createTable.CreateTableSA;
import tw.group4._11_.createTable.Create_SA2;
import tw.group4._11_.createTable.Create_Table_For_Donation;
import tw.group4._14_.init.APTableReset;
import tw.group4._18_._18_io.createTableCo;
import tw.group4._35_.init.model.CreateTableInsertDataService;

public class IntializeDatabase {
	
	public static void main(String[] args) {
		
//		全部執行完畢需時30-60秒
		new CreateTable03().executeCreateTable();
		new CreateTable().execute04();
		new Create_SA2().execute11f();
		new CreateTableSA().execute11b();
		new Create_Table_For_Donation().execute11c();
		new APTableReset().execute14();
		new createTableCo().execute18();
		new CreateTableInsertDataService().execute35();
		System.out.println("本組所有表格已就緒");
	}
}
