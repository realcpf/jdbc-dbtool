package dbtool;

public class Prompt {
	private static StringBuffer msg=new StringBuffer();
	
	public Prompt() {
		
		// TODO Auto-generated constructor stub
	}
	private void doWork(StringBuffer sBuffer) {
		msg.append(sBuffer);
	}
	
	public void refresh() {
		msg.append("\n>");
		System.out.println(msg);
	}
}
