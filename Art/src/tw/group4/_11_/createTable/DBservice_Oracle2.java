package tw.group4._11_.createTable;

public class DBservice_Oracle2 {
	public static final String host = "127.0.0.1";
	public static final String DB_ORACLE = "ORACLE";

	public static final String DB_TYPE = DB_ORACLE;


	private static final String DBURL_Oracle = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	public static final String USERID_Oracle = "group4";
	public static final String PSWD_Oracle = "oracle";


	private static final String DROP_DETAIL_SA_Oracle = "DROP TABLE DETAIL_SA";

	private static final String CREATE_DETAIL_SA_Oracle = "Create TABLE DETAIL_SA "
			+ "(ID_SA number generated as identity constraint DETAIL_SA_PK primary key, "
			+ " NAME_SA				varchar2(100), "
			+ " COUNTRY_SA			varchar2(50), "
			+ " THEME_SA			varchar2(160), "
			+ " CLASSIFICATION_SA	varchar2(200), "
			+ " WEB_SA				varchar2(300),"
			+ " PIC_SA				blob,"
			+ " SAL_SA				number"
			+ " ) ";


	public static String getDropDETAIL_SA() {
		String drop = DROP_DETAIL_SA_Oracle;
		return drop;
	}

	public static String getCreateDETAIL_SA() {
		String create = CREATE_DETAIL_SA_Oracle;
		return create;
	}
	public static String getDbUrl() {
		String url = DBURL_Oracle;
		return url;
	}

	public static String getUser() {
//		String user = "group4";
		return USERID_Oracle;
	}

	public static String getPassword() {
//		String pswd = "oracle";
		return PSWD_Oracle;
	}
}
