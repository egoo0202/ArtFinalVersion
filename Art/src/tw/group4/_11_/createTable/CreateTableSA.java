package tw.group4._11_.createTable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import tw.group4._11_.model.StreetArtistBean;

import java.io.File;

public class CreateTableSA {

	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元
	
	public void execute11b() {
//	public static void main(String[] args) {
		String line = "";

		try (Connection con = DriverManager.getConnection(DBService_for_Oracle.getDbUrl(),
				DBService_for_Oracle.getUser(), DBService_for_Oracle.getPassword());
				Statement stmt = con.createStatement();) {
			// 1. StreeetArtist表格
			try {
				stmt.executeUpdate(DBService_for_Oracle.getDropStreeetArtist());
				System.out.println("StreetArtist表格刪除成功");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(DBService_for_Oracle.getCreateStreeetArtist());
			System.out.println("StreetArtist表格產生成功");

			File file = new File("inputCSV/StreetArtist.csv");
			// 1-2 由"StreetArtist.csv"逐筆讀入StreetArtist表格內的初始資料，然後依序新增
			// 到StreetArtist表格中
			try (FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis, "UTF8");
					BufferedReader br = new BufferedReader(isr);) {
				int i = 0;
				while ((line = br.readLine()) != null) {
//					System.out.println("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split(",");
					StreetArtistBean bSA = new StreetArtistBean();
					
					if (i>0) {
						bSA.setName_SA(token[1].trim());
						bSA.setCountry_SA(token[2].trim());
						bSA.setTheme_SA(token[3].trim());
						bSA.setClassification_SA(token[4].trim());
						
						int n = saveSA(bSA, con);
//						System.out.println("新增一筆StreetArtist紀錄是否成功=" + n);
					}
					i++;
				} 
				System.out.println("StreetArtist資料新增成功");
			}
		} catch (SQLException e) {
			System.err.println("新建表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建表格時發生IO例外: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int saveSA(StreetArtistBean bean, Connection con) {
		int n = 0;
		String sqlS = "INSERT INTO StreetArtist " + " (NAME_SA , COUNTRY_SA , THEME_SA , CLASSIFICATION_SA) "
				+ " VALUES ( ?, ?, ?, ?)";

		try (PreparedStatement pStmt = con.prepareStatement(sqlS);) {
			pStmt.setString(1, bean.getName_SA());
			pStmt.setString(2, bean.getCountry_SA());
			pStmt.setString(3, bean.getTheme_SA());
			pStmt.setString(4, bean.getClassification_SA());
			n = pStmt.executeUpdate();
//			System.out.println(bean.getTheme_SA());
//			System.out.println(bean.getClassification_SA());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return n;

	}

}
