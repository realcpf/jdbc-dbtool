package jdbctools;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datasource.JdbcDataSource;

public class DbStruct {
	private JdbcDataSource jdbcDataSource;
	protected static String DRIVER_URL;
	protected static String USER_NAME;
	protected static String PASS_WD;
	private static String APPLICATION_NAME = "ApplicationName";
	public DbStruct() {}
	public DbStruct(JdbcDataSource jdbcDataSource) {
		this.jdbcDataSource = jdbcDataSource;
		DbStruct.DRIVER_URL = jdbcDataSource.getDbUrl();
		DbStruct.USER_NAME = jdbcDataSource.getUserName();
		DbStruct.PASS_WD = jdbcDataSource.getPassWord();
	}
	
	public List<TableInfo> getTablesInfo(String scheamLikeName, String likeName,TableType[] tableTypes){
		if (tableTypes.length == 0) {
			tableTypes = new TableType[] {TableType.TABLE};
		}
		String[] types= new String[tableTypes.length];
		for (int i = 0; i < types.length; i++) {
			types[i] = tableTypes[i].name();
		}
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
		try(Connection conn = DriverManager.getConnection(DRIVER_URL,USER_NAME,PASS_WD)){
			ResultSet rs = conn.getMetaData().getTables(null, scheamLikeName, likeName, types);
			tableInfos = TableInfo.fromResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableInfos;
	}
	
	public String dbInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		try(Connection conn = DriverManager.getConnection(DRIVER_URL,USER_NAME,PASS_WD)){
			stringBuilder.append(String.format("%s %s\n now : %s", 
					conn.getClientInfo(APPLICATION_NAME),
					conn.getMetaData().getDatabaseProductVersion(),
					conn.getSchema()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return DbStruct.DRIVER_URL;
	}
	
	public List<ScheamInfo> scheamsInfo(String like) {
		List<ScheamInfo> infos = new ArrayList<ScheamInfo>();
		try(Connection conn = DriverManager.getConnection(DRIVER_URL,USER_NAME,PASS_WD);){
			DatabaseMetaData dbMetaData = conn.getMetaData();
			infos = ScheamInfo.fromResultSet(dbMetaData.getSchemas(null, like));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infos;
	}
}
