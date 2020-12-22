package tw.group4._11_.createTable;

public class DBservice_Oracle_DonateList {

	public static final String host = "127.0.0.1";
	public static final String DB_ORACLE = "ORACLE";

	public static final String DB_TYPE = DB_ORACLE;


	private static final String DBURL_Oracle = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	public static final String USERID_Oracle = "group4";
	public static final String PSWD_Oracle = "oracle";


	private static final String DROP_DONATION_SA_Oracle = "DROP TABLE DONATION_SA";

	private static final String CREATE_DONATION_SA_Oracle = "Create TABLE DONATION_SA "
			+ "(ID_DONATION number generated as identity constraint DONATION_SA_PK primary key, "
			+ " NAME_SA					varchar2(100), "
			+ " NAME_USER				varchar2(50), "
			+ " DONATE_SA				number,"
			+ " TIME					varchar2(50)"
			+ " ) ";


	public static String getDropDonation_SA() {
		String drop = DROP_DONATION_SA_Oracle;
		return drop;
	}

	public static String getCreateDonation_SA() {
		String create = CREATE_DONATION_SA_Oracle;
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
