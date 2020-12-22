package tw.group4._03_.input.ShopReservation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class CreateShopReservationTable {

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

	public void dropShopReservationTable() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();

			String sql = "DROP TABLE CS_RESERVATION_TABLE CASCADE CONSTRAINTS";

			stmt.executeUpdate(sql);
			
			System.out.println("商店預約表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void createShopReservationTable() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();

			String sql = "CREATE TABLE CS_RESERVATION_TABLE "
					+ "(reservationNo NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY NOT NULL,  "
					+ "memberId NUMBER, "
					+ "memberName VARCHAR2(50), "
					+ "customerName varchar2(80), "
					+ "customerPhone varchar2(80), "
					
					+ "adultsNum NUMBER(8,0), "
					+ "childrenNum NUMBER(8,0), "
					+ "amount NUMBER(8,0), "
					+ "dateTime VARCHAR2(80), "
					+ "time VARCHAR2(80), "
					
					+ "payment NUMBER(8,0), "
					+ "note VARCHAR2(4000 BYTE), "
					+ "GENDER NUMBER(8,0), "
					+ "EMAIL VARCHAR2(4000 BYTE), "
					+ "PURPOSE NUMBER(8,0))";

			stmt.executeUpdate(sql);
			System.out.println("商店預約表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
