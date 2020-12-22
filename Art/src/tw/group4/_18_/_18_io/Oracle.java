package tw.group4._18_._18_io;


public class Oracle {
	public static final String host = "127.0.0.1";
	public static final String DB_ORACLE = "ORACLE";

	public static final String DB_TYPE = DB_ORACLE;


	private static final String DBURL_Oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	public static final String USERID_Oracle = "group4";
	public static final String PSWD_Oracle = "oracle";


	private static final String DROP_Table_Course = "DROP TABLE COURSE";

	private static final String DROP_Table_CourseCart = "DROP TABLE COURSECART";

	private static final String DROP_Table_CourseUser = "DROP TABLE COURSEUSER";
	
	private static final String DROP_Table_CourseOrderItems = "DROP TABLE COURSEORDERITEMS";

	private static final String DROP_Table_CourseOrders = "DROP TABLE COURSEORDERS";
	
	public static String getDropTableCourseOrderItems() {
		return DROP_Table_CourseOrderItems;
	}

	public static String getDropTableCourseOrders() {
		return DROP_Table_CourseOrders;
	}

	private static final String CREATE_CourseUser = " CREATE TABLE COURSEUSER " 
			
			+ "(memberId	    	varchar2(25), " 
			+ " username    		varchar2(36), "
			+ " password			varchar2(36), " 
			+ " address 			varchar2(90), "
			+ " email 				varchar2(60), " 
			+ " tel  				varchar2(20), "
			+ " PRIMARY KEY(COURSE_NO))";
	
	private static final String CREATE_Course = "CREATE TABLE COURSE " 
			+ "(coid number generated as identity constraint COURSE_PK primary key, "
			+ " cotitle			    	varchar2(120), " 
			+ " coact_type				varchar2(50),  "
			+ " coact_location			varchar2(150), " 
			+ " colocation_name			varchar2(120), " 
			+ " coprice			    	number(10,2),  "
			+ " conum			    	number(10,2),  "
			+ " coact_date				varchar2(60),  " 
			+ " coact_time				varchar2(60),  " 
			+ " coend_date				varchar2(60),  " 
			+ " coend_time				varchar2(60),  "  
			+ " coact_description		varchar2(400),  "
			+ " cohot			    	number(15,2),  "
			+ " coact_image				BLOB )";
			
	
	private static final String CREATE_CourseCart = "CREATE TABLE COURSECART " 
			+ "(coid					number(8,2), " 
			+ " cotitle				    varchar2(100), " 
			+ " coprice			    	number(10,2),  " 
			+ " cocnum			    	number(10,2),  "
			+ " coact_date				varchar2(60),  " 
			+ " coact_time				varchar2(60),  " 
			+ " PRIMARY KEY(COId))";
	
	
	
	private static final String CREATE_CourseOrders = "Create Table COURSEORDERS "
			+ "(ORDERNOCO  integer GENERATED as IDENTITY constraint COURSEORDERS_PK primary key, "
			+ " MEMBERID          varchar2(20),  "
//			+ " MEMBERNAME        varchar2(20),  "
			+ " EMAIL   		  varchar2(150), "
			+ " CUSTOMERADDRESS   varchar2(90), " 
			+ " COCOMMENT         varchar2(300), "
			+ " TOTALAMOUNT       int, " 
			+ " ORDERDATE         Date "
			+ " )";
	
	private static final String CREATE_CourseOrderItems = "Create TABLE COURSEORDERITEMS "
			+ "(ORDERIDCO number generated as identity constraint COURSEORDERITEMS_PK primary key, "
			+ " ORDERNOCO integer NOT NULL REFERENCES COURSEORDERS (ORDERNOCO),"		
			+ " COURSETITLECO           varchar2(150), "
			+ " COURSENUMCO             int, "
			+ " COURSEPRICECO           varchar2(20), "
			+ " COURSEACT_DATECO		varchar2(60),  " 
			+ " COURSEACT_TIMECO		varchar2(60)  " 
			+ " ) ";

	public static String getCreateCourseOrderItems() {
		return CREATE_CourseOrderItems;
	}

	public static String getCreateCourseOrders() {
		return CREATE_CourseOrders;
	}

	public static String getHost() {
		return host;
	}

	public static String getDbOracle() {
		return DB_ORACLE;
	}

	public static String getDbType() {
		return DB_TYPE;
	}

	public static String getDburlOracle() {
		return DBURL_Oracle;
	}

	public static String getUseridOracle() {
		return USERID_Oracle;
	}

	public static String getPswdOracle() {
		return PSWD_Oracle;
	}

	public static String getDropTableCourse() {
		return DROP_Table_Course;
	}

	public static String getDropTableCourseCart() {
		return DROP_Table_CourseCart;
	}

	public static String getDropTableCourseUser() {
		return DROP_Table_CourseUser;
	}

	public static String getCreateCourseUser() {
		return CREATE_CourseUser;
	}

	public static String getCreateCourse() {
		return CREATE_Course;
	}

	public static String getCreateCourseCart() {
		return CREATE_CourseCart;
	}
	
	
}
