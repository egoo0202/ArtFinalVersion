package tw.group4._03_.input.Restaurant;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class CreateRestaurantTable {

	private DataSource dataSource;

	public DataSource getDataSource() {// 只需get因為只要用不希望被改

		// lazy init，能有多晚用到就多晚產生，放constructor會先產出佔用記憶體
		if (dataSource == null) { // 不希望重複產生，
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
			ds.setUsername("group4");
			ds.setPassword("oracle");
			ds.setMaxTotal(50);
			ds.setMaxIdle(50);

			dataSource = ds; // 把BasicDataSource放在屬性上
		}
		return dataSource;
	}
	
	public void dropRestaurantTable() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE CS_RESTAURANT_TABLE CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("營業行事歷表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createRestaurantTable(){
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
		     
			String sql = "CREATE TABLE CS_RESTAURANT_TABLE("
					+ "RESTAURANTNO NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY NOT NULL, "
					+ "DATETIME VARCHAR2(1000 BYTE), "
					+ "YEAR NUMBER(8,0), "
					+ "MONTH NUMBER(8,0), "
					+ "DAY NUMBER(8,0), "	
					
					+ "H09 NUMBER, "
					+ "H10 NUMBER, "
					+ "H11 NUMBER, "
					+ "H12 NUMBER, "
					+ "H13 NUMBER, "	
					
					+ "H14 NUMBER, "
					+ "H15 NUMBER, "
					+ "H16 NUMBER, "
					+ "H17 NUMBER, "
					+ "H18 NUMBER, "
					
					+ "H19 NUMBER, "
					+ "H20 NUMBER, "
					+ "H21 NUMBER, "
					+ "MAXIMUM NUMBER(8,0), "
					+ "OPEN NUMBER(8,0))";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("營業行事歷表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
