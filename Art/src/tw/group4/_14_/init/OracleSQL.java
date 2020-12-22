package tw.group4._14_.init;


public class OracleSQL {
	public static final String host = "127.0.0.1";
	public static final String DB_ORACLE = "ORACLE";

	public static final String DB_TYPE = DB_ORACLE;


	private static final String DBURL_Oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	public static final String USERID_Oracle = "group4";
	public static final String PSWD_Oracle = "oracle";


	private static final String DROP_Table_ArtProduct = "DROP TABLE ARTPRODUCT";

	private static final String DROP_Table_APCart = "DROP TABLE APCART";

	private static final String DROP_Table_APMember = "DROP TABLE APMEMBER";
	
	private static final String DROP_Table_ORDERITEMSAP = "DROP TABLE ORDERITEMSAP";

	private static final String DROP_Table_ORDERSAP = "DROP TABLE ORDERSAP";
	
	private static final String DROP_Table_MessageBoardAP = "DROP TABLE MESSAGEBOARDAP";
	
	private static final String DROP_Table_AlertsCenter = "DROP TABLE ALERTSCENTER";
	
	private static final String DROP_MessageBoardRecord  = "DROP TABLE MBRECORD";
	
	private static final String DROP_EntryClickRate  = "DROP TABLE ENTRYCLICKRATE";

	private static final String CREATE_APMember = " CREATE TABLE APMEMBER " 
			
			+ "(memberID			varchar2(20), " 
			+ " name    			varchar2(32), "
			+ " password			varchar2(32), " 
			+ " address 			varchar2(64), "
			+ " email 				varchar2(64), " 
			+ " tel  				varchar2(15), "
			+ " PRIMARY KEY(ACT_NO))";
	
	private static final String CREATE_ArtProduct = "CREATE TABLE Artproduct " 
			+ "(apid number generated as identity constraint Artproduct_PK primary key, "
			+ " aptitle				varchar2(200), " 
			+ " aptype				varchar2(150),  "
			+ " apsubtype			varchar2(150),  "
			+ " apprice				varchar2(164),  " 
			+ " apimg			varchar2(200),  "
			+ " apdes				CLOB,  "		
			+ " apnum				number(8,2),"
			+ " apscore				number(8,2),"
			+ " aprater				number(8,2),"
			+ " apmessage			number(8,2),"
			+ " apimgBlob				BLOB )";
			
	
	private static final String CREATE_APCart = "CREATE TABLE APCART " 
			+ "(APCId 					number(8,2), "
//			+ " memberID				varchar2(100), " 
			+ " apctitle				varchar2(100), " 
			+ " apprice				number(12,2),  " 
			+ " apcnum				number(12,2),  "			
			+ " PRIMARY KEY(APCId))";
	
	
	
	private static final String CREATE_Orders_Oracle = "Create Table ORDERSAP "
			+ "(ORDERNOAP  integer GENERATED as IDENTITY constraint ORDERSAP_PK primary key, "
			+ " MEMBERID          varchar2(200), "
			+ " EMAIL   		  varchar2(164), "
			+ " SHIPPINGADDRESS   varchar2(164), "
			+ " BNO               varchar2(200), " 
			+ " invoiceTitle      varchar2(172), " 
			+ " TOTAL      		  int, " 
			+ " ORDERDATE         Date "
			+ " )";
	
	private static final String CREATE_OrderItemsAP = "Create TABLE ORDERITEMSAP "
			+ "(ORDERIDAP number generated as identity constraint ORDERITEMSAP_PK primary key, "
			+ " ORDERNOAP integer NOT NULL REFERENCES ORDERSAP (ORDERNOAP),"
//			+ " ORDERNOAP           	 int, "
			+ " PRODUCTTITLEAP           varchar2(172), "
			+ " PRODUCTNUMAP             int, "
			+ " PRODUCTPRICEAP           varchar2(200) "
			+ " ) ";
	
	
	private static final String CREATE_MessageBoardAP = "Create TABLE MESSAGEBOARDAP "
			+ "(MESSAGENOAP number generated as identity constraint MESSAGENOAP_PK primary key, "
			+ " APID 			   integer ,"
			+ " MEMBERID           varchar2(172), "
			+ " FAKENAME           varchar2(172), "
			+ " TIME               Date, "
			+ " SUBJECTAP          varchar2(172), "
			+ " TITLE              varchar2(100), "
			+ " SCORE              number, "
			+ " SCORESTRING        varchar2(172), "
			+ " CONTENTAP          CLOB "
			+ " ) ";
	
	
	private static final String CREATE_AlertsCenter = "Create TABLE ALERTSCENTER "
			+ "(ALERTNO number generated as identity constraint ALERTNO_PK primary key, "
			+ " MEMBERID 		   number ,"
			+ " MEMBERNAME 		   varchar2(150) ,"
			+ " LINK 			   varchar2(150) ,"
			+ " ICON           	   varchar2(150), "
			+ " TYPE               varchar2(100), "
			+ " TIME               varchar2(100), "
			+ " ISSUE              varchar2(100), "
			+ " ISSUEID            number, "
			+ " CONTENTAC          varchar2(172), "
			+ " DESCRIPTION        varchar2(200), "
			+ " STATUS             number "
			+ " ) ";

	
	private static final String CREATE_MessageBoardRecord = "Create TABLE MBRECORD "
			+ "(MBRECORDNO number generated as identity constraint MBRECORDNO_PK primary key, "
			+ " MEMBERID 		   number ,"
			+ " APID           	   number, "
			+ " STATUS             number "
			+ " ) ";
	

	private static final String CREATE_EntryClickRate = "Create TABLE ENTRYCLICKRATE "
			+ "(ECRNO number generated as identity constraint ECRNO primary key, "
			+ " TICKET 		   number ,"
			+ " SHOP           number, "
			+ " RESTAURANT     number, "
			+ " MAP            number, "
			+ " NEARBY         number, "
			+ " COURSE         number, "
			+ " ARTIST         number "
			+ " ) ";
	
	
	public static String getDropTableMessageboardap() {
		return DROP_Table_MessageBoardAP;
	}

	public static String getCreateMessageboardap() {
		return CREATE_MessageBoardAP;
	}

	public static String getCreateOrderitemsap() {
		return CREATE_OrderItemsAP;
	}

	public static String getCreateOrdersOracle() {
		return CREATE_Orders_Oracle;
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

	public static String getDropTableArtproduct() {
		return DROP_Table_ArtProduct;
	}

	public static String getDropTableApcart() {
		return DROP_Table_APCart;
	}

	public static String getDropTableApmember() {
		return DROP_Table_APMember;
	}

	public static String getCreateApmember() {
		return CREATE_APMember;
	}

	public static String getCreateArtproduct() {
		return CREATE_ArtProduct;
	}

	public static String getCreateApcart() {
		return CREATE_APCart;
	}
	
	public static String getDropTableOrderitemsap() {
		return DROP_Table_ORDERITEMSAP;
	}

	public static String getDropTableOrdersap() {
		return DROP_Table_ORDERSAP;
	}

	public static String getDropTableAlertscenter() {
		return DROP_Table_AlertsCenter;
	}

	public static String getCreateAlertscenter() {
		return CREATE_AlertsCenter;
	}

	public static String getDropMessageboardrecord() {
		return DROP_MessageBoardRecord;
	}

	public static String getCreateMessageboardrecord() {
		return CREATE_MessageBoardRecord;
	}

	public static String getDropEntryclickrate() {
		return DROP_EntryClickRate;
	}

	public static String getCreateEntryclickrate() {
		return CREATE_EntryClickRate;
	}
	
	
}
