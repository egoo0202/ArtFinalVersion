package tw.group4._18_._18_io.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CourseDataInputJson {
private DataSource dataSource;
	
	
	public DataSource getDataSource() {
		
		
		if (dataSource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("oracle.jdbc.OracleDriver");
			ds.setUrl("jdbc:oracle:thin:@//localhost:1521/xepdb1");
			ds.setUsername("group4");
			ds.setPassword("oracle");
			ds.setMaxTotal(50); 
			ds.setMaxIdle(50);  			

			dataSource=ds; 
		}
		return dataSource;
	}
	
	
	public void createTable() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE COURSE_LN (ID VARCHAR2(1000), TITLE VARCHAR(1000), ACT_CATEGORY NUMBER(8,2),  ACT_LOCATION VARCHAR2(1000), LOCATION_NAME VARCHAR2(1000), ON_SALES VARCHAR2(1000), PRICE NUMBER(6), ACT_TIME VARCHAR2(1000), END_TIME VARCHAR2(1000), MAIN_UNIT VARCHAR2(1000), SHOW_UNIT VARCHAR2(1000), ACT_COMMENT VARCHAR2(4000), ACT_DESCRIPTION VARCHAR2(4000), ACT_IMAGE VARCHAR2(1000), START_DATE VARCHAR2(1000), END_DATE VARCHAR2(1000), PRIMARY KEY(ID))";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("課程表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void dropTable() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE COURSE_LN CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("課程表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<COURSE> readJson() {
		
		ArrayList<COURSE> list = new ArrayList<COURSE>();
		try (InputStream is = new URL("	https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=19").openStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF8");
				BufferedReader br = new BufferedReader(isr);	
				) {
			int c;
			StringBuilder strBuilder = new StringBuilder();
			while ((c = br.read())!=-1) {
				char d =(char)c;
				strBuilder.append(String.valueOf(d));
			}
			
			String tableStr= String.valueOf(strBuilder);


			
			
			
			
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<COURSE>>() {}.getType();
			ArrayList<COURSE> jsonArr = gson.fromJson(tableStr,listType);
			
			for (COURSE item: jsonArr) {
				COURSE mt = new COURSE();
				mt.setUid(item.getUid());
				mt.setTitle(item.getTitle());
				mt.setCategory(item.getCategory());


				
				
				
				HashMap hashMap1= new HashMap();
				for (int i=0 ; i < item.getShowInfo().size(); i++) {
					hashMap1 = item.getShowInfo().get(i);										
				}
				mt.setLocation(String.valueOf(hashMap1.get("location")));
				mt.setLocationName(String.valueOf(hashMap1.get("locationName")));
				mt.setOnSales(String.valueOf(hashMap1.get("onSales")));

				int r = 0;
				r = ((int)(Math.random()*10)+1)*500;
				
				mt.setPrice(Integer.valueOf(r));
				mt.setTime(String.valueOf(hashMap1.get("time")));
				mt.setEndTime(String.valueOf(hashMap1.get("endTime")));


				
				
				
				String str1= "";
				for (int i=0 ; i < item.getMasterUnit().size(); i++) {
					str1 = item.getMasterUnit().get(i);										
				}
				mt.setMainUnit(str1);

				
				mt.setShowUnit(item.getShowUnit());
				mt.setComment(item.getComment());
				mt.setDescriptionFilterHtml(item.getDescriptionFilterHtml());
				mt.setImageUrl(item.getImageUrl());				


				
				
				mt.setStartDate(item.getStartDate());
				mt.setEndDate(item.getEndDate());


				list.add(mt);
			}
			


			
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void writeDB(ArrayList<COURSE> list) {
		
		try (Connection connection = getDataSource().getConnection();
				PreparedStatement pstmt = connection.prepareStatement("insert into COURSE_LN (ID, TITLE, ACT_CATEGORY,  ACT_LOCATION, LOCATION_NAME, ON_SALES, PRICE, ACT_TIME, END_TIME, MAIN_UNIT, SHOW_UNIT, ACT_COMMENT, ACT_DESCRIPTION, ACT_IMAGE, START_DATE, END_DATE) values (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?,?)");
				){
		
			for (COURSE item: list) {
				pstmt.setString(1, item.getUid());
				pstmt.setString(2, item.getTitle());
				pstmt.setInt(3, item.getCategory());
				pstmt.setString(4, item.getLocation());
				pstmt.setString(5, item.getLocationName());
				pstmt.setString(6, item.getOnSales());
				pstmt.setInt(7, item.getPrice());
				pstmt.setString(8, item.getTime());
				pstmt.setString(9, item.getEndTime());
				pstmt.setString(10, item.getMainUnit());
				pstmt.setString(11, item.getShowUnit());
				pstmt.setString(12, item.getComment());
				if(item.getDescriptionFilterHtml().length()<1500) {
					pstmt.setString(13, item.getDescriptionFilterHtml());
				}else {
					pstmt.setString(13, "");
				}
				pstmt.setString(14, item.getImageUrl());
				pstmt.setString(15, item.getStartDate());
				pstmt.setString(16, item.getEndDate());
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			pstmt.executeBatch();
	


			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("資料已寫入資料庫");
		
	}
	
}
