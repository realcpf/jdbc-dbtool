package jdbctools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableInfo extends DbStruct{
	public static final String[] COL_NAMES = new String[] {
		"TABLE_CAT",
		"TABLE_SCHEM",
		"TABLE_NAME",
		"TABLE_TYPE",
		"REMARKS",
		"TYPE_CAT",
		"TYPE_SCHEM",
		"TYPE_NAME",
		"SELF_REFERENCING_COL_NAME",
		"REF_GENERATION"
	};
	
	public List<ColumnInfo> getColumnInfos(){
		List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
		try(Connection conn = DriverManager.getConnection(DRIVER_URL,USER_NAME,PASS_WD);
				PreparedStatement preparedStatement = conn.prepareStatement(
						String.format("select * from %s.%s where 1=2", this.getTableScheam(),this.getTableName()))){
			preparedStatement.execute();
			try(ResultSet rs = preparedStatement.getResultSet()){
				ResultSetMetaData mData = rs.getMetaData();
				int count = mData.getColumnCount();
				for (int i = 1; i <=count; i++) {
					ColumnInfo info = new ColumnInfo();
					String catalogName = mData.getCatalogName(i);
					String className = mData.getColumnClassName(i);
					Integer displaySize = mData.getColumnDisplaySize(i);
					String columnLabel = mData.getColumnLabel(i);
					String cloumnName = mData.getColumnName(i);
					Integer columnType = mData.getColumnType(i);
					String columnTypeName = mData.getColumnTypeName(i);
					Integer precision = mData.getPrecision(i);
					Integer scale = mData.getScale(i);
					String scheamName = mData.getSchemaName(i);
					String tableName = mData.getTableName(i);
					info.setCatalogName(catalogName);
					info.setClassName(className);
					info.setDisplaySize(displaySize);
					info.setColumnLabel(columnLabel);
					info.setColumnLabel(columnLabel);
					info.setColumnType(columnType);
					info.setColumnTypeName(columnTypeName);
					info.setPrecision(precision);
					info.setScale(scale);
					info.setScheamName(scheamName);
					columnInfos.add(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return columnInfos;
	}
	
	public static List<TableInfo> fromResultSet(ResultSet rs) {
		List<TableInfo> tableInfos = new ArrayList<TableInfo>();
		try(ResultSet localResultSet = rs){
			while (localResultSet.next()) {
				TableInfo tableInfo = new TableInfo();
				tableInfo.setTableCat(localResultSet.getString(COL_NAMES[0]));
				tableInfo.setTableScheam(localResultSet.getString(COL_NAMES[1]));
				tableInfo.setTableName(localResultSet.getString(COL_NAMES[2]));
				tableInfo.setTableType(localResultSet.getString(COL_NAMES[3]));
				tableInfo.setRemarks(localResultSet.getString(COL_NAMES[4]));
				tableInfo.setTypeCat(localResultSet.getString(COL_NAMES[5]));
				tableInfo.setTypeSchem(localResultSet.getString(COL_NAMES[6]));
				tableInfo.setTypeName(localResultSet.getString(COL_NAMES[7]));
				tableInfo.setSelfReferenceColName(localResultSet.getString(COL_NAMES[8]));
				tableInfo.setRefGeneration(localResultSet.getString(COL_NAMES[9]));
				tableInfos.add(tableInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableInfos;
	}
	
	public String getTableScheam() {
		return tableScheam;
	}
	public void setTableScheam(String tableScheam) {
		this.tableScheam = tableScheam;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTypeCat() {
		return typeCat;
	}
	public void setTypeCat(String typeCat) {
		this.typeCat = typeCat;
	}
	public String getTableCat() {
		return tableCat;
	}
	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}
	public String getTypeSchem() {
		return typeSchem;
	}
	public void setTypeSchem(String typeSchem) {
		this.typeSchem = typeSchem;
	}
	public String getSelfReferenceColName() {
		return selfReferenceColName;
	}
	public void setSelfReferenceColName(String selfReferenceColName) {
		this.selfReferenceColName = selfReferenceColName;
	}
	public String getRefGeneration() {
		return refGeneration;
	}
	public void setRefGeneration(String refGeneration) {
		this.refGeneration = refGeneration;
	}
	private String tableScheam;
	private String tableType;
	private String tableName;
	private String remarks;
	private String typeCat;
	private String tableCat;
	private String typeSchem;
	private String selfReferenceColName;
	private String refGeneration;
	public String getTypeName() {
		return typeName;
	}

	@Override
	public String toString() {
		return "TableInfo [tableScheam=" + tableScheam + ", tableType=" + tableType + ", tableName=" + tableName
				+ ", remarks=" + remarks + ", typeCat=" + typeCat + ", tableCat=" + tableCat + ", typeSchem="
				+ typeSchem + ", selfReferenceColName=" + selfReferenceColName + ", refGeneration=" + refGeneration
				+ ", typeName=" + typeName + "]";
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	private String typeName;
}
