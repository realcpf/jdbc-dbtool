package jdbctools;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datasource.JdbcDataSource;

public class ScheamInfo extends DbStruct{
	public ScheamInfo() {}
	public ScheamInfo(JdbcDataSource jdbcDataSource) {
		super(jdbcDataSource);
		// TODO Auto-generated constructor stub
	}
	private static String TABLE_SCHEM = "TABLE_SCHEM";
	private static String TABLE_CATALOG  = "TABLE_CATALOG";
	
	public String getTableSchem() {
		return tableSchem;
	}
	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}
	public String getTableCatalog() {
		return tableCatalog;
	}
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}
	private String tableSchem;
	private String tableCatalog;
	
	public List<TableInfo> geTableInfos(){
		return super.getTablesInfo(this.getTableSchem(), "", new TableType[] {});
	}
	
	public static List<ScheamInfo> fromResultSet(ResultSet resultSet){
		List<ScheamInfo> scheamInfos = new ArrayList<ScheamInfo>();
		try(resultSet){
			while (resultSet.next()) {
				ScheamInfo info = new ScheamInfo();
				info.setTableCatalog(resultSet.getString(TABLE_CATALOG));
				info.setTableSchem(resultSet.getString(TABLE_SCHEM));
				scheamInfos.add(info);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return scheamInfos;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("tableSchem:%s\ttableCatalog:%s", this.getTableSchem(),this.getTableCatalog());
	}
}
