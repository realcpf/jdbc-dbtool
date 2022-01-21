package datasource;

import dbtool.ErrorMsg;

public class JdbcDataSource {

	public static String DB_URL = "dbUrl";
	public static String USER_NAME = "userName";
	public static String PASS_WORD = "passWord";
	
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	private String dbUrl;
	private String userName;
	private  String passWord;	
	private ErrorMsg errorMsg;
	public void setErrorMsg(ErrorMsg msg) {
		this.errorMsg = msg;
	}
	
	public ErrorMsg getErrorMsg() {
		if (errorMsg != null) {
			return errorMsg;
		}
		if (dbUrl == null 
			|| userName == null
					|| passWord == null) {
			return ErrorMsg.NULL_CLASS;
		}
		return ErrorMsg.NONE;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s\n%s\n%s", this.getDbUrl(),this.getUserName(),this.getPassWord());
	}
}
