package dbtool;

public enum ErrorMsg {
	NONE("no error"),
	NULL_CLASS("null class");
	private String msg;
	private ErrorMsg(String msg){
		this.msg =msg;
	}
}
