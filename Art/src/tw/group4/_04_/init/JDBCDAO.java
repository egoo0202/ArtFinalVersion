package tw.group4._04_.init;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.dbcp2.BasicDataSource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class JDBCDAO {
private DataSource dataSource;
	
	//getDataSource連線的方法
	public DataSource getDataSource() {//只需get因為只要用不希望被改
		
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
	
	//創MainTable表格
	public void createTableMT() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE MAINTABLE (ACT_NO NUMBER(8,2)GENERATED BY DEFAULT ON NULL AS IDENTITY( START WITH  1 INCREMENT BY  1)PRIMARY KEY NOT NULL, ACT_UID VARCHAR2(1000), ACT_TITLE VARCHAR2(1000), ACT_CATEGORY NUMBER(8,2),  ACT_LOCATION VARCHAR2(1000), ACT_LOCATION_NAME VARCHAR2(1000), ACT_ON_SALES VARCHAR2(1000), ACT_PRICE VARCHAR2(4000), ACT_TIME VARCHAR2(1000), ACT_ENDTIME VARCHAR2(1000), ACT_MAINUNIT VARCHAR2(1000), ACT_SHOWUNIT VARCHAR2(4000), ACT_COMMENT CLOB , ACT_DESCRIPTION CLOB , ACT_IMAGE VARCHAR2(1000), ACT_STARTDATE VARCHAR2(1000), ACT_ENDDATE VARCHAR2(1000),ACT_POPULARITY NUMBER(8,2),ACT_PHOTO BLOB)";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("主表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪MainTable表格
	public void dropTableMT() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE MAINTABLE CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("主表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	//創TicketOrderlist表格
	public void createTableOL() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
//		    String sql = "CREATE TABLE ACTORDERLIST (ORDERID VARCHAR2(1000 BYTE), NAME VARCHAR2(1000 BYTE), EMAIL VARCHAR2(1000 BYTE), TEL VARCHAR2(1000 BYTE), ADDRESS VARCHAR2(1000 BYTE), TOTALPRICE NUMBER)";
		    String sql = "CREATE TABLE TICKETORDERLIST ("
		    		+ "ORDERPK  integer GENERATED as IDENTITY ,"
		    		+ "MEMBERID VARCHAR2(1000 BYTE),"
		    		+ "ORDERID VARCHAR2(1000 BYTE),"
		    		+ "NAME VARCHAR2(1000 BYTE),"
		    		+ "EMAIL VARCHAR2(1000 BYTE),"
		    		+ "TEL VARCHAR2(1000 BYTE) ,"
		    		+ "ADDRESS VARCHAR2(1000 BYTE),"
		    		+ "ACT_ID NUMBER,"
		    		+ "TITLE VARCHAR2(1000 BYTE),"
		    		+ "TICKETCATEGORY VARCHAR2(1000 BYTE),"
		    		+ "TICKET_NUM NUMBER,"
		    		+ "TOTALPRICE NUMBER,"
		    		+ "seats VARCHAR2(1000 BYTE),"
		    		+ "STATUS VARCHAR2(1000 BYTE))";
	    
//		    MEMBERID VARCHAR2(1000 BYTE),ORDERID VARCHAR2(1000 BYTE),NAME VARCHAR2(1000 BYTE),EMAIL VARCHAR2(1000 BYTE),TEL,ADDRESS VARCHAR2(1000 BYTE),ACT_ID NUMBER,TITLE VARCHAR2(1000 BYTE),TICKETCATEGORY VARCHAR2(1000 BYTE),TICKET_NUM NUMBER,TOTALPRICE NUMBER,seats VARCHAR2(1000 BYTE)
		    

		    stmt.executeUpdate(sql);
		    System.out.println("TicketOrderlist表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪ActOrderlist表格
	public void dropTableOL() {
		
		try (Connection connection = getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE TICKETORDERLIST CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("TicketOrderlist表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創OrderNUM表格
		public void createTableOU() {
			
			try (Connection connection = getDataSource().getConnection();) {
				Statement stmt = connection.createStatement();
				
			    String sql = "CREATE TABLE ORDERNUM( ORDERID VARCHAR2(1000 BYTE), TITLE VARCHAR2(1000 BYTE), ADULTNUM NUMBER, HALFNUM NUMBER)";
		    
			    stmt.executeUpdate(sql);
			    System.out.println("ORDERNUM表格已建立");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//刪ORDERNUM表格
		public void dropTableON() {
			
			try (Connection connection = getDataSource().getConnection();) {
				Statement stmt = connection.createStatement();
				
			    String sql = "DROP TABLE ORDERNUM CASCADE CONSTRAINTS";
		    
			    stmt.executeUpdate(sql);
			    System.out.println("ORDERNUM表格已刪除");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//創Seat表格
		public void createTableSeat() {
			
			try (Connection  connection = getDataSource().getConnection();) {
				Statement stmt = connection.createStatement();
				
			    String sql = "CREATE TABLE SEAT("+
			    		"ACT_NO NUMBER NOT NULL ENABLE," + 
			    		"ACT_TITLE VARCHAR2(1000),"+ 
			    		"SEATNUM NUMBER,"+ 
			    		"A1 NUMBER,"+ 
			    		"A2 NUMBER,"+ 
			    		"A3 NUMBER,"+ 
			    		"A4 NUMBER,"+ 
			    		"A5 NUMBER,"+ 
			    		"A6 NUMBER,"+ 
			    		"A7 NUMBER,"+ 
			    		"A8 NUMBER,"+ 
			    		"A9 NUMBER,"+ 
			    		"A10 NUMBER,"+ 
			    		"B1 NUMBER,"+ 
			    		"B2 NUMBER,"+ 
			    		"B3 NUMBER,"+ 
			    		"B4 NUMBER,"+ 
			    		"B5 NUMBER,"+ 
			    		"B6 NUMBER,"+ 
			    		"B7 NUMBER,"+ 
			    		"B8 NUMBER,"+ 
			    		"B9 NUMBER,"+ 
			    		"B10 NUMBER,"+ 
			    		"C1 NUMBER,"+ 
			    		"C2 NUMBER,"+ 
			    		"C3 NUMBER,"+ 
			    		"C4 NUMBER,"+ 
			    		"C5 NUMBER,"+ 
			    		"C6 NUMBER,"+ 
			    		"C7 NUMBER,"+ 
			    		"C8 NUMBER,"+ 
			    		"C9 NUMBER,"+ 
			    		"C10 NUMBER,"+ 
			    		"D1 NUMBER,"+ 
			    		"D2 NUMBER,"+ 
			    		"D3 NUMBER,"+ 
			    		"D4 NUMBER,"+ 
			    		"D5 NUMBER,"+ 
			    		"D6 NUMBER,"+ 
			    		"D7 NUMBER,"+ 
			    		"D8 NUMBER,"+ 
			    		"D9 NUMBER,"+ 
			    		"D10 NUMBER,"+ 
			    		"E1 NUMBER,"+ 
			    		"E2 NUMBER,"+ 
			    		"E3 NUMBER,"+ 
			    		"E4 NUMBER,"+ 
			    		"E5 NUMBER,"+ 
			    		"E6 NUMBER,"+ 
			    		"E7 NUMBER,"+ 
			    		"E8 NUMBER,"+ 
			    		"E9 NUMBER,"+ 
			    		"E10 NUMBER,"+ 
			    		"CONSTRAINT SEAT_PK PRIMARY KEY (ACT_NO))";
			  
			    stmt.executeUpdate(sql);
			 
			    System.out.println("SEAT表格已建立");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//創Seat2表格
				public void createTableSeat2() {
					
					try (Connection  connection = getDataSource().getConnection();) {
						Statement stmt = connection.createStatement();
						
					    String sql = "CREATE TABLE SEAT2("+
					    		"ACT_NO NUMBER NOT NULL ENABLE," + 
					    		"ACT_TITLE VARCHAR2(1000),"+ 
					    		"SEAT2NUM NUMBER,"+ 
					    		"F1 NUMBER,"+ 
					    		"F2 NUMBER,"+ 
					    		"F3 NUMBER,"+ 
					    		"F4 NUMBER,"+ 
					    		"F5 NUMBER,"+ 
					    		"F6 NUMBER,"+ 
					    		"F7 NUMBER,"+ 
					    		"F8 NUMBER,"+ 
					    		"F9 NUMBER,"+ 
					    		"F10 NUMBER,"+ 
					    		"G1 NUMBER,"+ 
					    		"G2 NUMBER,"+ 
					    		"G3 NUMBER,"+ 
					    		"G4 NUMBER,"+ 
					    		"G5 NUMBER,"+ 
					    		"G6 NUMBER,"+ 
					    		"G7 NUMBER,"+ 
					    		"G8 NUMBER,"+ 
					    		"G9 NUMBER,"+ 
					    		"G10 NUMBER,"+ 
					    		"H1 NUMBER,"+ 
					    		"H2 NUMBER,"+ 
					    		"H3 NUMBER,"+ 
					    		"H4 NUMBER,"+ 
					    		"H5 NUMBER,"+ 
					    		"H6 NUMBER,"+ 
					    		"H7 NUMBER,"+ 
					    		"H8 NUMBER,"+ 
					    		"H9 NUMBER,"+ 
					    		"H10 NUMBER,"+ 
					    		"I1 NUMBER,"+ 
					    		"I2 NUMBER,"+ 
					    		"I3 NUMBER,"+ 
					    		"I4 NUMBER,"+ 
					    		"I5 NUMBER,"+ 
					    		"I6 NUMBER,"+ 
					    		"I7 NUMBER,"+ 
					    		"I8 NUMBER,"+ 
					    		"I9 NUMBER,"+ 
					    		"I10 NUMBER,"+ 
					    		"J1 NUMBER,"+ 
					    		"J2 NUMBER,"+ 
					    		"J3 NUMBER,"+ 
					    		"J4 NUMBER,"+ 
					    		"J5 NUMBER,"+ 
					    		"J6 NUMBER,"+ 
					    		"J7 NUMBER,"+ 
					    		"J8 NUMBER,"+ 
					    		"J9 NUMBER,"+ 
					    		"J10 NUMBER,"+ 
					    		"CONSTRAINT SEAT2_PK PRIMARY KEY (ACT_NO))";
					  
					    stmt.executeUpdate(sql);
					 
					    System.out.println("SEAT2表格已建立");

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				//創Seat3表格
				public void createTableSeat3() {
					
					try (Connection  connection = getDataSource().getConnection();) {
						Statement stmt = connection.createStatement();
						
					    String sql = "CREATE TABLE SEAT3("+
					    		"ACT_NO NUMBER NOT NULL ENABLE," + 
					    		"ACT_TITLE VARCHAR2(1000),"+ 
					    		"SEAT3NUM NUMBER,"+ 
					    		"K1 NUMBER,"+ 
					    		"K2 NUMBER,"+ 
					    		"K3 NUMBER,"+ 
					    		"K4 NUMBER,"+ 
					    		"K5 NUMBER,"+ 
					    		"K6 NUMBER,"+ 
					    		"K7 NUMBER,"+ 
					    		"K8 NUMBER,"+ 
					    		"K9 NUMBER,"+ 
					    		"L1 NUMBER,"+ 
					    		"L2 NUMBER,"+ 
					    		"L3 NUMBER,"+ 
					    		"L4 NUMBER,"+ 
					    		"L5 NUMBER,"+ 
					    		"L6 NUMBER,"+ 
					    		"L7 NUMBER,"+ 
					    		"L8 NUMBER,"+ 
					    		"L9 NUMBER,"+ 
					    		"L10 NUMBER,"+ 
					    		"L11 NUMBER,"+ 
					    		"M1 NUMBER,"+ 
					    		"M2 NUMBER,"+ 
					    		"M3 NUMBER,"+ 
					    		"M4 NUMBER,"+ 
					    		"M5 NUMBER,"+ 
					    		"M6 NUMBER,"+ 
					    		"M7 NUMBER,"+ 
					    		"M8 NUMBER,"+ 
					    		"M9 NUMBER,"+ 
					    		"M10 NUMBER,"+ 
					    		"M11 NUMBER,"+ 
					    		"N1 NUMBER,"+ 
					    		"N2 NUMBER,"+ 
					    		"N3 NUMBER,"+ 
					    		"N4 NUMBER,"+ 
					    		"N5 NUMBER,"+ 
					    		"N6 NUMBER,"+ 
					    		"N7 NUMBER,"+ 
					    		"N8 NUMBER,"+ 
					    		"N9 NUMBER,"+ 
					    		"O1 NUMBER,"+ 
					    		"O2 NUMBER,"+ 
					    		"O3 NUMBER,"+ 
					    		"O4 NUMBER,"+ 
					    		"O5 NUMBER,"+ 
					    		"O6 NUMBER,"+ 
					    		"O7 NUMBER,"+ 
					    		"O8 NUMBER,"+ 
					    		"O9 NUMBER,"+ 
					    		"O10 NUMBER,"+ 
					    		"P1 NUMBER,"+ 
					    		"P2 NUMBER,"+ 
					    		"P3 NUMBER,"+ 
					    		"P4 NUMBER,"+ 
					    		"P5 NUMBER,"+ 
					    		"P6 NUMBER,"+ 
					    		"P7 NUMBER,"+ 
					    		"P8 NUMBER,"+ 
					    		"P9 NUMBER,"+ 
					    		"P10 NUMBER,"+ 
					    		"Q1 NUMBER,"+ 
					    		"Q2 NUMBER,"+ 
					    		"Q3 NUMBER,"+ 
					    		"Q4 NUMBER,"+ 
					    		"Q5 NUMBER,"+ 
					    		"Q6 NUMBER,"+ 
					    		"CONSTRAINT SEAT3_PK PRIMARY KEY (ACT_NO))";
					  
					    stmt.executeUpdate(sql);
					 
					    System.out.println("SEAT3表格已建立");

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
		//刪Seat全部表格
		public void dropTableseat() {
			
			try (Connection connection = getDataSource().getConnection();) {
				Statement stmt = connection.createStatement();
				
			    String sql = "DROP TABLE SEAT CASCADE CONSTRAINTS";
			    String sql2 = "DROP TABLE SEAT2 CASCADE CONSTRAINTS";
			    String sql3= "DROP TABLE SEAT3 CASCADE CONSTRAINTS";
		    
			    stmt.addBatch(sql);
			    stmt.addBatch(sql2);
			    stmt.addBatch(sql3);
			    stmt.executeBatch();  
			    
//			    stmt.executeUpdate(sql);
			    System.out.println("SEAT表格已刪除");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//插入Seat表格
				public void InsertTableseat() {
					
					try (Connection connection = getDataSource().getConnection();) {
						Statement stmt = connection.createStatement();
						
						String sql = "INSERT INTO SEAT (ACT_NO,ACT_TITLE) SELECT ACT_NO,ACT_TITLE FROM MAINTABLE";				    
						String sql2 ="UPDATE SEAT SET SEATNUM=50";
						String sql3 = "INSERT INTO SEAT2 (ACT_NO,ACT_TITLE) SELECT ACT_NO,ACT_TITLE FROM MAINTABLE";				    
						String sql4 ="UPDATE SEAT2 SET SEAT2NUM=50";
						String sql5 = "INSERT INTO SEAT3 (ACT_NO,ACT_TITLE) SELECT ACT_NO,ACT_TITLE FROM MAINTABLE";				    
						String sql6 ="UPDATE SEAT3 SET SEAT3NUM=66";
					    stmt.addBatch(sql);
					    stmt.addBatch(sql2);
					    stmt.addBatch(sql3);
					    stmt.addBatch(sql4);
					    stmt.addBatch(sql5);
					    stmt.addBatch(sql6);
					    stmt.executeBatch();  
					    System.out.println("SEAT表格已插入");

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
		
		
		
	
		public ArrayList<MainTable> readJsonToMT() {
			
			ArrayList<MainTable> list = new ArrayList<MainTable>();
			try (InputStream is = new URL("https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=all").openStream();
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
//				若資料不乾淨要用下面方法篩選符號
//				System.out.println(tableStr);
//				String result1 = tableStr.replaceAll("\\\\", "");
//				String result2 = result1.replaceAll(Matcher.quoteReplacement("$"), "");
//				String result3 = result2.substring(1, result2.length()-1);
//				System.out.println(result3);
				
				Gson gson = new Gson();
				Type listType = new TypeToken<ArrayList<MainTable>>() {}.getType();
				ArrayList<MainTable> jsonArr = gson.fromJson(tableStr,listType);
				
				int counter = 0;
				for (MainTable item: jsonArr) {
					MainTable mt = new MainTable();
					counter++;
					mt.setNo(counter);
					mt.setUid(item.getUid());
					mt.setTitle(item.getTitle());
					mt.setCategory(item.getCategory());
//					System.out.println("UID:"+ item.getUid());
//					System.out.println("title:"+ item.getTitle());
//					System.out.println("category:"+ item.getCategory());
					
//					"showInfo"
//					System.out.println("ArrayList<HashMap> showInfo:"+ item.getShowInfo());
					HashMap hashMap1= new HashMap();
					for (int i=0 ; i < item.getShowInfo().size(); i++) {
						hashMap1 = item.getShowInfo().get(i);										
					}
					mt.setLocation(String.valueOf(hashMap1.get("location")));
					mt.setLocationName(String.valueOf(hashMap1.get("locationName")));
					mt.setOnSales(String.valueOf(hashMap1.get("onSales")));
					mt.setPrice(String.valueOf(hashMap1.get("price")));
					mt.setTime(String.valueOf(hashMap1.get("time")));
					mt.setEndTime(String.valueOf(hashMap1.get("endTime")));
//					System.out.println("location:"+hashMap1.get("location"));
//					System.out.println("locationName:"+hashMap1.get("locationName"));
//					System.out.println("onSales:"+hashMap1.get("onSales"));
//					System.out.println("price:"+hashMap1.get("price"));
//					System.out.println("time:"+hashMap1.get("time"));
//					System.out.println("endTime:"+hashMap1.get("endTime"));

//					"masterUnit"
//					System.out.println("ArrayList<String> masterUnit:"+ item.getMasterUnit());
					String str1= "";
					for (int i=0 ; i < item.getMasterUnit().size(); i++) {
						str1 = item.getMasterUnit().get(i);										
					}
					mt.setMainUnit(str1);
//					System.out.println("masterUnit:"+str1);
					
					mt.setShowUnit(item.getShowUnit());
					mt.setComment(item.getComment());
					mt.setDescriptionFilterHtml(item.getDescriptionFilterHtml());
					mt.setImageUrl(item.getImageUrl());				
//					System.out.println("showUnit:"+ item.getShowUnit());
//					System.out.println("comment:"+ item.getComment());
//					System.out.println("descriptionFilterHtml:"+ item.getDescriptionFilterHtml());
//					System.out.println("imageUrl:"+ item.getImageUrl());
					
					mt.setStartDate(item.getStartDate());
					mt.setEndDate(item.getEndDate());
//					System.out.println("startDate:"+ item.getStartDate());
//					System.out.println("endDate:"+ item.getEndDate());
					list.add(mt);
				}
				
//				int counter=0;
//				for (MainTable item: list) {
//					counter++;
//					System.out.println(item.getLocation());
//				}
//				System.out.println( counter);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("已讀取文化部json檔為MainTable物件");
			return list;
		}
		
		public void mtWriteDB(ArrayList<MainTable> list) {
			
			try (Connection connection = getDataSource().getConnection();
					PreparedStatement pstmt = connection.prepareStatement("insert into MainTable (ACT_NO, ACT_UID, ACT_TITLE, ACT_CATEGORY,  ACT_LOCATION, ACT_LOCATION_NAME, ACT_ON_SALES, ACT_PRICE, ACT_TIME, ACT_ENDTIME, ACT_MAINUNIT, ACT_SHOWUNIT, ACT_COMMENT, ACT_DESCRIPTION, ACT_IMAGE, ACT_STARTDATE, ACT_ENDDATE) values (?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,?,?)");
					){
			
				for (MainTable item: list) {
					pstmt.setInt(1, item.getNo());
					pstmt.setString(2, item.getUid());
					pstmt.setString(3, item.getTitle());
					pstmt.setInt(4, item.getCategory());
					pstmt.setString(5, item.getLocation());
					pstmt.setString(6, item.getLocationName());
					pstmt.setString(7, item.getOnSales());
					pstmt.setString(8, item.getPrice());
					pstmt.setString(9, item.getTime());
					pstmt.setString(10, item.getEndTime());
					pstmt.setString(11, item.getMainUnit());
					pstmt.setString(12, item.getShowUnit());
					pstmt.setString(13, item.getComment());
					if(item.getDescriptionFilterHtml().length()<1500) {
						pstmt.setString(14, item.getDescriptionFilterHtml());
					}else {
						pstmt.setString(14, "");
					}
					pstmt.setString(15, item.getImageUrl());
					pstmt.setString(16, item.getStartDate());
					pstmt.setString(17, item.getEndDate());
					pstmt.addBatch();//加入批次
					pstmt.clearParameters();//清除參數再加入下一物件的值
				}
				pstmt.executeBatch();
				pstmt.clearBatch();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("MainTable物件已寫入資料庫");
			
		}
		
		
		//插入圖片測試

		public void InsertBLOB() {
			
//			Blob blob1 = null;
//			Blob blob2 = null;
			PreparedStatement pstmt = null;
			  try (Connection connection = getDataSource().getConnection();){

				  	File file = new File("./IOFiles/inputJPG/activityImage/class_music.jpg"); 	  
				  	File file2 = new File("./IOFiles/inputJPG/activityImage/drama.jpg"); 	  
				  	File file3 = new File("./IOFiles/inputJPG/activityImage/dance.jpg"); 	  
				  	File file4 = new File("./IOFiles/inputJPG/activityImage/family.jpg"); 	  
				  	File file5 = new File("./IOFiles/inputJPG/activityImage/indie_music.jpg"); 	  
				  	File file6 = new File("./IOFiles/inputJPG/activityImage/exhibition.jpg"); 	  
				  	File file7 = new File("./IOFiles/inputJPG/activityImage/lecture.jpg"); 	  
				  	File file8 = new File("./IOFiles/inputJPG/activityImage/movie.jpg"); 	  
				  	File file9 = new File("./IOFiles/inputJPG/activityImage/street_artist.jpg"); 	  
				  	File file10 = new File("./IOFiles/inputJPG/activityImage/competition.jpg"); 	  
				  	File file11 = new File("./IOFiles/inputJPG/activityImage/solicit.jpg"); 	  
				  	File file12 = new File("./IOFiles/inputJPG/activityImage/other.jpg"); 	  
				  	File file13 = new File("./IOFiles/inputJPG/activityImage/music_concert.jpg"); 	  
				  	File file14 = new File("./IOFiles/inputJPG/activityImage/class.jpg"); 	  
					int length = (int) file.length();   					
					InputStream fin = new FileInputStream(file); 
					InputStream fin2 = new FileInputStream(file2); 
					InputStream fin3 = new FileInputStream(file3); 
					InputStream fin4 = new FileInputStream(file4);
					InputStream fin5 = new FileInputStream(file5);
					InputStream fin6 = new FileInputStream(file6);
					InputStream fin7 = new FileInputStream(file7);
					InputStream fin8 = new FileInputStream(file8);
					InputStream fin9 = new FileInputStream(file9);
					InputStream fin10 = new FileInputStream(file10);
					InputStream fin11= new FileInputStream(file11);
					InputStream fin12 = new FileInputStream(file12);
					InputStream fin13 = new FileInputStream(file13);
					InputStream fin14 = new FileInputStream(file14);
					
  
	                // 填入資料庫 
	                pstmt = connection.prepareStatement( 
//	                           "INSERT INTO MAINTABLE (ACT_NO,ACT_PHOTO) VALUES (?,?) "	                		
	                		"UPDATE MAINTABLE SET ACT_PHOTO=? WHERE ACT_CATEGORY=?"	                		
	                		); 
	                pstmt.setBinaryStream (1,fin); 
	                pstmt.setInt(2,1); 
	             // Add it to the batch
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin2); 
	                pstmt.setInt(2,2); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin3); 
	                pstmt.setInt(2,3); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin4); 
	                pstmt.setInt(2,4); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin5); 
	                pstmt.setInt(2,5); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin6); 
	                pstmt.setInt(2,6); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin7); 
	                pstmt.setInt(2,7); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin8); 
	                pstmt.setInt(2,8); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin9); 
	                pstmt.setInt(2,11); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin10); 
	                pstmt.setInt(2,13); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin11); 
	                pstmt.setInt(2,14); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin12); 
	                pstmt.setInt(2,15); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin13); 
	                pstmt.setInt(2,17); 
	                pstmt.addBatch();
	                
	                pstmt.setBinaryStream (1,fin14); 
	                pstmt.setInt(2,19); 
	                pstmt.addBatch();
	                
	               
	                pstmt.executeBatch();  
//	                pstmt.executeUpdate(); 
//	                pstmt.clearParameters(); 

	                fin.close(); 
			   System.out.println("圖片已插入");

			  } catch (Exception e) {
			   e.printStackTrace();
			  }
	

			  
		}
		
		
	
}
