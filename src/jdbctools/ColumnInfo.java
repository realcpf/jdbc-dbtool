package jdbctools;

public class ColumnInfo {
	@Override
	public String toString() {
		return "ColumnInfo [catalogName=" + catalogName + ", className=" + className + ", displaySize=" + displaySize
				+ ", columnLabel=" + columnLabel + ", colunmName=" + colunmName + ", columnType=" + columnType
				+ ", columnTypeName=" + columnTypeName + ", precision=" + precision + ", scale=" + scale
				+ ", scheamName=" + scheamName + ", tableName=" + tableName + "]";
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Integer getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(Integer displaySize) {
		this.displaySize = displaySize;
	}
	public String getColumnLabel() {
		return columnLabel;
	}
	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}
	public String getCloumnName() {
		if (colunmName == null) {
			return columnLabel;
		}
		return colunmName;
	}
	public void setColumnName(String colunmName) {
		this.colunmName = colunmName;
	}
	public Integer getColumnType() {
		return columnType;
	}
	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}
	public String getColumnTypeName() {
		return columnTypeName;
	}
	public void setColumnTypeName(String columnTypeName) {
		this.columnTypeName = columnTypeName;
	}
	public Integer getPrecision() {
		return precision;
	}
	public void setPrecision(Integer precision) {
		this.precision = precision;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public String getScheamName() {
		return scheamName;
	}
	public void setScheamName(String scheamName) {
		this.scheamName = scheamName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	private String catalogName;
	private String className;
	private Integer displaySize;
	private String columnLabel;
	private String colunmName;
	private Integer columnType;
	private String columnTypeName;
	private Integer precision;
	private Integer scale;
	private String scheamName;
	private String tableName;
}
