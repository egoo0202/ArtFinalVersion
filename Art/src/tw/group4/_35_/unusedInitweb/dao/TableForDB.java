package tw.group4._35_.unusedInitweb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class TableForDB {
	
	//創MainTable表格
	public void createTableActivity() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE ACTIVITY (id NUMBER generated always as identity(start with 1 increment by 1 nocache) primary key not null, "
		    		+ "uqid VARCHAR2(1000), title VARCHAR2(1000), category NUMBER(8,2), location VARCHAR2(1000), locationName VARCHAR2(1000), "
		    		+ "onSales VARCHAR2(1000), price VARCHAR2(4000), time VARCHAR2(1000), endTime VARCHAR2(1000), mainUnit VARCHAR2(1000), "
		    		+ "showUnit VARCHAR2(1000), image VARCHAR2(1000), startDate VARCHAR2(1000), endDate VARCHAR2(1000))";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("ACTIVITY表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪MainTable表格
	public void dropTableActivity() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE ACTIVITY CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("ACTIVITY表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創Position表格
	public void createTablePosition() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE POSITION (NO Number(8,2), UQID VARCHAR(1000), CITY VARCHAR(1000), DISTRICT VARCHAR(1000),  VILLAGE VARCHAR2(1000), ADDRESS VARCHAR2(1000),  LATITUDE NUMBER(25, 20), LONGITUDE NUMBER(25, 20), PRIMARY KEY(NO))";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("POSITION表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪Position表格
	public void dropTablePosition() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE POSITION CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("POSITION表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創MEMBER表格
	public void createTableMember() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE MEMBER"
					   + "(seqNo INT GENERATED as IDENTITY constraint MEMBER_PK primary key, "
					   + " memberID			varchar2(20), " 
					   + " name    			varchar2(32), "
					   + " password			varchar2(32), " 
					   + " address 			varchar2(64), "
					   + " email 			varchar2(64), " 
					   + " tel  			varchar2(15), "
					   + " userType			varchar2(10), " 
					   + " registerTime    	Date, "
					   + " total_amount     	number(12,2),  "
					   + " ticket_amount        number(12,2), "
					   + " product_amount       number(12,2), "
					   + " class_amount       number(12,2), "
					   + " reservation_quantity   number(12,2), "
					   + " artShop_quantity       number(12,2), "
					   + " class_quantity         number(12,2), "
					   + " preference           number(6,2) "
					   + " )";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("MEMBER表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪MEMBER表格
	public void dropTableMember() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE MEMBER CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("MEMBER表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創BU_RESERVATIONITEM表格
	public void createTableBURI() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE BU_RESERVATIONITEM"
					   + "(seqno number generated as identity constraint ORDERITEMS_PK primary key, "
					   + " orderNo          int, "
					   + " actNo            int, "
					   + " actTitle      	VARCHAR2(1000), "
					   + " actLocation      VARCHAR2(1000), "
					   + " actLocationName  VARCHAR2(1000), "
					   + " actTime  		VARCHAR2(1000), "
					   + " amount           int, "
					   + " unitPrice        number(18,2), "
					   + " Discount         number "
					   + " ) ";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("BU_RESERVATIONITEM表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪BU_RESERVATIONITEM表格
	public void dropTableBURI() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE BU_RESERVATIONITEM CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("BU_RESERVATIONITEM表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創BU_RESERVATION表格
	public void createTableBUR() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE BU_RESERVATION"
					   + "(orderNo  INT GENERATED as IDENTITY constraint ORDERS_PK primary key, "
					+ " memberId          varchar2(20), "
					+ " totalAmount       number(11,1), "
					+ " BNO               varchar2(8), " 
					+ " invoiceTitle      varchar2(72), " 
					+ " orderDate         Date, "
					+ " CancelTag         varchar2(1 char) "
					+ " )";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("BU_RESERVATION表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪BU_RESERVATION表格
	public void dropTableBUR() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE BU_RESERVATION CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("BU_RESERVATION表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創EventSpace表格
	public void createTableEventSpace() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE EventSpace"
					   + "(id NUMBER generated always as identity(start with 1 increment by 1 nocache) primary key not null, "
					+ " name NVARCHAR2(50), "
					+ " owner NVARCHAR2(50), "
					+ " address NVARCHAR2(50), "
					+ " type NVARCHAR2(50), " 
					+ " shoppingArea NVARCHAR2(50), " 
					+ " transportation NVARCHAR2(50), "
					+ " capacity NUMBER, "
					+ " unitPrice NUMBER, "
					+ " area NUMBER, "
					+ " rentalTime DATE, "
					+ " activityInfo NVARCHAR2(50), "
					+ " contactInfo NVARCHAR2(50) "
					+ " )";
		    
		    stmt.executeUpdate(sql);
		    System.out.println("EventSpace表格已建立");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪EventSpace表格
	public void dropTableEventSpace() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "DROP TABLE EventSpace CASCADE CONSTRAINTS";
	    
		    stmt.executeUpdate(sql);
		    System.out.println("EventSpace表格已刪除");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//創Sponsorship表格
	public void createTableSponsorship() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
		    String sql = "CREATE TABLE Sponsorship"
					   + "(id NUMBER generated always as identity(start with 1 increment by 1 nocache) primary key not null, "
					+ " schoolName NVARCHAR2(50), "
					+ " city NVARCHAR2(50), "
					+ " district NVARCHAR2(50), "
					+ " address NVARCHAR2(50), " 
					+ " schoolType NVARCHAR2(50), " 
					+ " childAmount NUMBER, "
					+ " activityTime DATE, "
					+ " activityType NVARCHAR2(50), "
					+ " fee NUMBER, "
					+ " announcementDate DATE, "
					+ " contactInfo NVARCHAR2(50) "
					+ " )";
			
			stmt.executeUpdate(sql);
			System.out.println("Sponsorship表格已建立");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪ChildSponsorship表格
	public void dropTableSponsorship() {
		
		try (Connection connection = DataSourceConn.getDataSource().getConnection();) {
			Statement stmt = connection.createStatement();
			
			String sql = "DROP TABLE Sponsorship CASCADE CONSTRAINTS";
			
			stmt.executeUpdate(sql);
			System.out.println("Sponsorship表格已刪除");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
