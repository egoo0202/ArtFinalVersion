package tw.group4._11_.createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table_For_Donation {

	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

//	public static void main(String[] args) {
	public void execute11c() {
		
		try (Connection con = DriverManager.getConnection(DBservice_Oracle_DonateList.getDbUrl(),
				DBservice_Oracle_DonateList.getUser(), DBservice_Oracle_DonateList.getPassword());
				Statement stmt = con.createStatement();){
			try {
				stmt.executeUpdate(DBservice_Oracle_DonateList.getDropDonation_SA());
				System.out.println("DONATION_SA表格刪除成功");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(DBservice_Oracle_DonateList.getCreateDonation_SA());
			System.out.println("DONATION_SA表格產生成功");
		
		} catch (SQLException e) {
			System.err.println("新建表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
