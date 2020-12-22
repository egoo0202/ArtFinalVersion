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

import tw.group4._11_.model.UserSABean;

import java.io.File;

public class Create_SA2 {

	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元
	
	public void execute11f() {
//	public static void main(String[] args) {
		String line = "";

		try (Connection con = DriverManager.getConnection(DBservice_Oracle2.getDbUrl(),
				DBservice_Oracle2.getUser(), DBservice_Oracle2.getPassword());
				Statement stmt = con.createStatement();) {
			// 1. DETAIL_SA表格
			try {
				stmt.executeUpdate(DBservice_Oracle2.getDropDETAIL_SA());
				System.out.println("DETAIL_SA表格刪除成功");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(DBservice_Oracle2.getCreateDETAIL_SA());
			System.out.println("DETAIL_SA表格產生成功");
			
			File file = new File("inputCSV/StreetArtist.csv");	
			// 1-2 由"StreetArtist.csv"逐筆讀入StreetArtist表格內的初始資料，然後依序新增
			// 到StreetArtist表格中
			try (
					FileInputStream fis = new FileInputStream(file);
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
					UserSABean bUSA = new UserSABean();
					
					if (i>0) {
						bUSA.setName_SA(token[1].trim());
						bUSA.setCountry_SA(token[2].trim());
						bUSA.setTheme_SA(token[3].trim());
						bUSA.setClassification_SA(token[4].trim());
						bUSA.setWeb_SA(null);
						if (token[3].trim().contains("串珠") || token[3].trim().contains("裝飾")) {
							FileInputStream fis1 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/Beaded.jpg");
							bUSA.setFis(fis1);
//							System.out.println(i+", 1");
						}else if (token[3].trim().contains("書法")) {
							FileInputStream fis2 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/calligraphy.jpg");
							bUSA.setFis(fis2);
//							System.out.println(i+", 2");
						}else if (token[3].trim().contains("電子琴") || token[3].trim().contains("電鋼琴")) {
							FileInputStream fis3 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/elecpiano.jpg");
							bUSA.setFis(fis3);
//							System.out.println(i+", 3");
						}else if (token[3].trim().contains("塗鴉") || token[3].trim().contains("噴畫")) {
							FileInputStream fis4 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/Graffiti.jpg");
							bUSA.setFis(fis4);
//							System.out.println(i+", 4");
						}else if (token[3].trim().contains("吉他")) {
							FileInputStream fis5 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/guitar.jpg");
							bUSA.setFis(fis5);
//							System.out.println(i+", 5");
						}else if (token[3].trim().contains("魔術")) {
							FileInputStream fis6 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/magic.jpg");
							bUSA.setFis(fis6);
//							System.out.println(i+", 6");
						}else if (token[3].trim().contains("紙藝")) {
							FileInputStream fis8 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/paperArt.jpg");
							bUSA.setFis(fis8);
//							System.out.println(i+", 8");
						}else if (token[3].trim().contains("剪")) {
							FileInputStream fis9 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/Paper-cut.jpg");
							bUSA.setFis(fis9);
//							System.out.println(i+", 9");
						}else if (token[3].trim().contains("尺八")) {
							FileInputStream fis10 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/somthing.jpg");
							bUSA.setFis(fis10);
//							System.out.println(i+", 10");
						}else if (token[3].trim().contains("小提琴")) {
							FileInputStream fis12 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/violin.jpg");
							bUSA.setFis(fis12);
//							System.out.println(i+", 12");
						}else if (token[4].trim().contains("工藝")) {
							FileInputStream fis11 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/Unknown.jpg");
							bUSA.setFis(fis11);
//							System.out.println(i+", 11");
						}else{
							FileInputStream fis7 = new FileInputStream("WebContent/WEB-INF/pages/_11_SA/pic/noIMG.jpg");
							bUSA.setFis(fis7);
//							System.out.println(i+", 7");
						}
						bUSA.setSal_SA(0);

						int n = saveSA(bUSA, con);
//						System.out.println("新增一筆DETAIL_SA紀錄是否成功=" + n);
					}
//					if (bUSA.getFis() != null) {
//						bUSA.getFis().close();
//					}
					i++;
				} 
//				System.out.println("DETAIL_SA資料新增成功");
			}
		} catch (SQLException e) {
			System.err.println("新建表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建表格時發生IO例外: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static int saveSA(UserSABean bUSA, Connection con) {
		int n = 0;
		String sqlS = "INSERT INTO DETAIL_SA " + " (NAME_SA , COUNTRY_SA , THEME_SA , CLASSIFICATION_SA , WEB_SA , PIC_SA , SAL_SA) "
				+ " VALUES ( ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement pStmt = con.prepareStatement(sqlS);) {
			pStmt.setString(1, bUSA.getName_SA());
			pStmt.setString(2, bUSA.getCountry_SA());
			pStmt.setString(3, bUSA.getTheme_SA());
			pStmt.setString(4, bUSA.getClassification_SA());
			pStmt.setString(5, bUSA.getWeb_SA());
			pStmt.setBlob(6, bUSA.getFis());
			pStmt.setInt(7, bUSA.getSal_SA());
			
			n = pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
}
