package tw.group4._35_.unusedInitweb.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceConn {
	
private static DataSource dataSource;
	
	//getDataSource連線的方法
	public static DataSource getDataSource() {//只需get因為只要用不希望被改
		
		//lazy init，能有多晚用到就多晚產生，放constructor會先產出佔用記憶體
		if (dataSource == null) { //不希望重複產生，
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
			ds.setUsername("group4");
			ds.setPassword("oracle");
			ds.setMaxTotal(50); 
			ds.setMaxIdle(50);  			

			dataSource=ds; //把BasicDataSource放在屬性上
		}
		return dataSource;
	}
}
