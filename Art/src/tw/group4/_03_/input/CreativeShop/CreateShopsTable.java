package tw.group4._03_.input.CreativeShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CreateShopsTable {

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

	public void dropShopsTable() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();

			String sql = "DROP TABLE CS_CREATIVE_SHOP_TABLE CASCADE CONSTRAINTS";

			stmt.executeUpdate(sql);
			System.out.println("藝文商店表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createShopsTableForDB() {
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();

			String sql = "CREATE TABLE CS_CREATIVE_SHOP_TABLE ( "
					+ "SHOPID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY NOT NULL,  "
					+ "SHOPNAME VARCHAR2(1000 BYTE), " + "MEMBERID NUMBER, " + "IMAGE VARCHAR2(2000 BYTE), "
					+ "INTRO VARCHAR2(4000 BYTE), " + "CITYNAME VARCHAR2(1000 BYTE), " + "ADDRESS VARCHAR2(2000 BYTE), "
					+ "OPENTIME VARCHAR2(1000 BYTE), " + "PHONE VARCHAR2(1000 BYTE), " + "FAX VARCHAR2(1000 BYTE), "
					+ "EMAIL VARCHAR2(1000 BYTE), " + "FACEBOOK VARCHAR2(1000 BYTE), " + "WEBSITE VARCHAR2(1000 BYTE), "
					+ "CLICKS NUMBER(8,0), " + "RESERVATION BLOB)";

			stmt.executeUpdate(sql);
			System.out.println("藝文商店表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ShopsTable> readJsonToTable() {

		ArrayList<ShopsTable> list = new ArrayList<ShopsTable>();

		// 未來路徑有變動可能
		try (InputStream is = new FileInputStream("inputJSON/CreativeShops.json");
				InputStreamReader isr = new InputStreamReader(is, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			int c;
			StringBuilder strBuilder = new StringBuilder();
			while ((c = br.read()) != -1) {
				char d = (char) c;
				strBuilder.append(String.valueOf(d));
			}

			String tableStr = String.valueOf(strBuilder);
//			System.out.println(tableStr);

			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<ShopsTable>>() {
			}.getType();

			ArrayList<ShopsTable> jsonArr = gson.fromJson(tableStr, listType);

			for (ShopsTable item : jsonArr) {
				ShopsTable shops = new ShopsTable();

				shops.setShopId(item.getShopId());
				shops.setShopName(item.getShopName());
				shops.setMemberId(item.getMemberId());
				shops.setImage(item.getImage());
				shops.setIntro(item.getIntro());

				shops.setCityName(item.getCityName());
				shops.setAddress(item.getAddress());
				shops.setOpenTime(item.getOpenTime());
				shops.setPhone(item.getPhone());
				shops.setFax(item.getFax());

				shops.setEmail(item.getEmail());
				shops.setFacebook(item.getFacebook());
				shops.setWebsite(item.getWebsite());
				shops.setClicks(item.getClicks());
//				shops.setReservation(item.getReservation());

				list.add(shops);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("已成功轉換json");
		return list;

	}

	double customizeParseDouble(String strNumber) {
		if (strNumber != null && strNumber.length() > 0) {
			try {
				return Double.parseDouble(strNumber);
			} catch (Exception e) {
				return -1; // or some value to mark this field is wrong. or make a function validates field
							// first ...
			}
		} else
			return 0;
	}

	public void creatShopsInfoTable(ArrayList<ShopsTable> list) {

		try (Connection connection = getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO CS_CREATIVE_SHOP_TABLE "
						+ "(shopName, memberId, image, intro, " + "cityName, address, openTime, phone, fax, "
						+ "email, facebook, website, clicks) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");) {

			for (ShopsTable shop : list) {

				pstmt.setString(1, shop.getShopName());
				pstmt.setInt(2, Integer.parseInt(shop.getMemberId()));
				pstmt.setString(3, shop.getImage());
				pstmt.setString(4, shop.getIntro());

				pstmt.setString(5, shop.getCityName());
				pstmt.setString(6, shop.getAddress());
				pstmt.setString(7, shop.getOpenTime());
				pstmt.setString(8, shop.getPhone());
				pstmt.setString(9, shop.getFax());

				pstmt.setString(10, shop.getEmail());
				pstmt.setString(11, shop.getFacebook());
				pstmt.setString(12, shop.getWebsite());
				pstmt.setInt(13, Integer.parseInt(shop.getClicks()));
//				pstmt.setInt(14, Integer.parseInt(shop.getReservation()));

				pstmt.executeUpdate();
				pstmt.clearParameters();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("藝文商店資料已新增至DB");
	}

	public void insertPictureIntoTable() {

		PreparedStatement pstmt = null;
		try (Connection connection = getDataSource().getConnection();) {

			File file1 = new File("./IOFiles/inputShopPicture/001.jpg");
			File file2 = new File("./IOFiles/inputShopPicture/002.jpg");
			File file3 = new File("./IOFiles/inputShopPicture/003.jpg");
			File file4 = new File("./IOFiles/inputShopPicture/004.jpg");
			File file5 = new File("./IOFiles/inputShopPicture/005.jpg");
			File file6 = new File("./IOFiles/inputShopPicture/006.jpg");
			File file7 = new File("./IOFiles/inputShopPicture/007.jpg");
			File file8 = new File("./IOFiles/inputShopPicture/008.jpg");
			File file9 = new File("./IOFiles/inputShopPicture/009.jpg");
			File file10 = new File("./IOFiles/inputShopPicture/010.jpg");

			// 10 ==================
			File file11 = new File("./IOFiles/inputShopPicture/011.jpg");
			File file12 = new File("./IOFiles/inputShopPicture/012.jpg");
			File file13 = new File("./IOFiles/inputShopPicture/013.jpg");
			File file14 = new File("./IOFiles/inputShopPicture/014.jpg");
			File file15 = new File("./IOFiles/inputShopPicture/015.jpg");
			File file16 = new File("./IOFiles/inputShopPicture/016.jpg");
			File file17 = new File("./IOFiles/inputShopPicture/017.jpg");
			File file18 = new File("./IOFiles/inputShopPicture/018.jpg");
			File file19 = new File("./IOFiles/inputShopPicture/019.jpg");
			File file20 = new File("./IOFiles/inputShopPicture/020.jpg");

			// 20 ==================
			File file21 = new File("./IOFiles/inputShopPicture/021.jpg");
			File file22 = new File("./IOFiles/inputShopPicture/022.jpg");
			File file23 = new File("./IOFiles/inputShopPicture/023.jpg");
			File file24 = new File("./IOFiles/inputShopPicture/024.jpg");
			File file25 = new File("./IOFiles/inputShopPicture/025.jpg");
			File file26 = new File("./IOFiles/inputShopPicture/026.jpg");
			File file27 = new File("./IOFiles/inputShopPicture/027.jpg");
			File file28 = new File("./IOFiles/inputShopPicture/028.jpg");
			File file29 = new File("./IOFiles/inputShopPicture/029.jpg");
			File file30 = new File("./IOFiles/inputShopPicture/030.jpg");

			// 30 ==================
			File file31 = new File("./IOFiles/inputShopPicture/031.jpg");
			File file32 = new File("./IOFiles/inputShopPicture/032.jpg");
			File file33 = new File("./IOFiles/inputShopPicture/033.jpg");
			File file34 = new File("./IOFiles/inputShopPicture/034.jpg");
			File file35 = new File("./IOFiles/inputShopPicture/035.jpg");
			File file36 = new File("./IOFiles/inputShopPicture/036.jpg");
			File file37 = new File("./IOFiles/inputShopPicture/037.jpg");
			File file38 = new File("./IOFiles/inputShopPicture/038.jpg");
			File file39 = new File("./IOFiles/inputShopPicture/039.jpg");
			File file40 = new File("./IOFiles/inputShopPicture/040.jpg");

			// 46 ==================
			File file41 = new File("./IOFiles/inputShopPicture/041.jpg");
			File file42 = new File("./IOFiles/inputShopPicture/042.jpg");
			File file43 = new File("./IOFiles/inputShopPicture/043.jpg");
			File file44 = new File("./IOFiles/inputShopPicture/044.jpg");
			File file45 = new File("./IOFiles/inputShopPicture/045.jpg");
			File file46 = new File("./IOFiles/inputShopPicture/Aaart-Icon.jpg");

			System.out.println("圖片讀取成功");
			
			// 轉換成資料流 ==================
			InputStream is1 = new FileInputStream(file1);
			InputStream is2 = new FileInputStream(file2);
			InputStream is3 = new FileInputStream(file3);
			InputStream is4 = new FileInputStream(file4);
			InputStream is5 = new FileInputStream(file5);
			InputStream is6 = new FileInputStream(file6);
			InputStream is7 = new FileInputStream(file7);
			InputStream is8 = new FileInputStream(file8);
			InputStream is9 = new FileInputStream(file9);
			InputStream is10 = new FileInputStream(file10);
			// 10 ==================
			InputStream is11 = new FileInputStream(file11);
			InputStream is12 = new FileInputStream(file12);
			InputStream is13 = new FileInputStream(file13);
			InputStream is14 = new FileInputStream(file14);
			InputStream is15 = new FileInputStream(file15);
			InputStream is16 = new FileInputStream(file16);
			InputStream is17 = new FileInputStream(file17);
			InputStream is18 = new FileInputStream(file18);
			InputStream is19 = new FileInputStream(file19);
			InputStream is20 = new FileInputStream(file20);
			// 20 ==================
			InputStream is21 = new FileInputStream(file21);
			InputStream is22 = new FileInputStream(file22);
			InputStream is23 = new FileInputStream(file23);
			InputStream is24 = new FileInputStream(file24);
			InputStream is25 = new FileInputStream(file25);
			InputStream is26 = new FileInputStream(file26);
			InputStream is27 = new FileInputStream(file27);
			InputStream is28 = new FileInputStream(file28);
			InputStream is29 = new FileInputStream(file29);
			InputStream is30 = new FileInputStream(file30);
			// 30 ==================
			InputStream is31 = new FileInputStream(file31);
			InputStream is32 = new FileInputStream(file32);
			InputStream is33 = new FileInputStream(file33);
			InputStream is34 = new FileInputStream(file34);
			InputStream is35 = new FileInputStream(file35);
			InputStream is36 = new FileInputStream(file36);
			InputStream is37 = new FileInputStream(file37);
			InputStream is38 = new FileInputStream(file38);
			InputStream is39 = new FileInputStream(file39);
			InputStream is40 = new FileInputStream(file40);
			// 40 ==================
			InputStream is41 = new FileInputStream(file41);
			InputStream is42 = new FileInputStream(file42);
			InputStream is43 = new FileInputStream(file43);
			InputStream is44 = new FileInputStream(file44);
			InputStream is45 = new FileInputStream(file45);
			InputStream is46 = new FileInputStream(file46);
			
			System.out.println("資料流轉換成功");
			
			// 填入資料庫
			pstmt = connection.prepareStatement(
					"UPDATE CS_CREATIVE_SHOP_TABLE SET RESERVATION = ? WHERE SHOPID = ?");
			
			pstmt.setBinaryStream(1, is1);
			pstmt.setInt(2, 1);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is2);
			pstmt.setInt(2, 2);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is3);
			pstmt.setInt(2, 3);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is4);
			pstmt.setInt(2, 4);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is5);
			pstmt.setInt(2, 5);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is6);
			pstmt.setInt(2, 6);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is7);
			pstmt.setInt(2, 7);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is8);
			pstmt.setInt(2, 8);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is9);
			pstmt.setInt(2, 9);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is10);
			pstmt.setInt(2, 10);
			pstmt.addBatch();
			
			// 10 ==================
			pstmt.setBinaryStream(1, is11);
			pstmt.setInt(2, 11);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is12);
			pstmt.setInt(2, 12);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is13);
			pstmt.setInt(2, 13);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is14);
			pstmt.setInt(2, 14);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is15);
			pstmt.setInt(2, 15);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is16);
			pstmt.setInt(2, 16);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is17);
			pstmt.setInt(2, 17);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is18);
			pstmt.setInt(2, 18);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is19);
			pstmt.setInt(2, 19);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is20);
			pstmt.setInt(2, 20);
			pstmt.addBatch();

			// 20 ==================
			pstmt.setBinaryStream(1, is21);
			pstmt.setInt(2, 21);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is22);
			pstmt.setInt(2, 22);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is23);
			pstmt.setInt(2, 23);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is24);
			pstmt.setInt(2, 24);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is25);
			pstmt.setInt(2, 25);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is26);
			pstmt.setInt(2, 26);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is27);
			pstmt.setInt(2, 27);
			pstmt.addBatch();

			pstmt.setBinaryStream(1, is28);
			pstmt.setInt(2, 28);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is29);
			pstmt.setInt(2, 29);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is30);
			pstmt.setInt(2, 30);
			pstmt.addBatch();
			
			// 30 ==================
			
			pstmt.setBinaryStream(1, is31);
			pstmt.setInt(2, 31);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is32);
			pstmt.setInt(2, 32);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is33);
			pstmt.setInt(2, 33);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is34);
			pstmt.setInt(2, 34);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is35);
			pstmt.setInt(2, 35);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is36);
			pstmt.setInt(2, 36);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is37);
			pstmt.setInt(2, 37);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is38);
			pstmt.setInt(2, 38);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is39);
			pstmt.setInt(2, 39);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is40);
			pstmt.setInt(2, 40);
			pstmt.addBatch();
			
			// 40 ==================
			pstmt.setBinaryStream(1, is41);
			pstmt.setInt(2, 41);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is42);
			pstmt.setInt(2, 42);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is43);
			pstmt.setInt(2, 43);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is44);
			pstmt.setInt(2, 44);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is45);
			pstmt.setInt(2, 45);
			pstmt.addBatch();
			
			pstmt.setBinaryStream(1, is46);
			pstmt.setInt(2, 46);
			pstmt.addBatch();
			
			// 46 ==================
			
			pstmt.executeBatch();
//                pstmt.executeUpdate(); 
//                pstmt.clearParameters(); 
			pstmt.close();

			System.out.println("圖片儲存成功");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
