package datasource;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import dbtool.ErrorMsg;

public class LoadDataSource {
	private static String fileName = "jdbc.prop";
	
	public static void save(JdbcDataSource jdbcDataSource) {
		if (jdbcDataSource.getErrorMsg() != ErrorMsg.NONE) {
			System.err.print(jdbcDataSource.getErrorMsg());
			System.exit(-1);
		}
		Properties properties = new Properties();
		properties.put(JdbcDataSource.DB_URL, jdbcDataSource.getDbUrl());
		properties.put(JdbcDataSource.PASS_WORD, jdbcDataSource.getPassWord());
		properties.put(JdbcDataSource.USER_NAME, jdbcDataSource.getUserName());
		File file = new File(fileName);
		try(FileWriter fileWriter = new FileWriter(file)){
			properties.store(fileWriter, "jdbc prop");
			System.out.print(file.getAbsoluteFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JdbcDataSource load() {
		Properties properties = new Properties();
		try(FileReader reader = new FileReader(fileName)){
			properties.load(reader);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if (properties.entrySet().size() > 0) {
			JdbcDataSource dataSource = new JdbcDataSource();
			dataSource.setDbUrl(properties.getProperty(JdbcDataSource.DB_URL));
			dataSource.setPassWord(properties.getProperty(JdbcDataSource.PASS_WORD));
			dataSource.setUserName(properties.getProperty(JdbcDataSource.USER_NAME));
			dataSource.setErrorMsg(ErrorMsg.NONE);
			return dataSource;
		}
		return new JdbcDataSource();
	}
	
}
