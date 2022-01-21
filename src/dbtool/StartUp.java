package dbtool;

import java.util.List;

import datasource.JdbcDataSource;
import datasource.LoadDataSource;
import jdbctools.ColumnInfo;
import jdbctools.DbStruct;
import jdbctools.TableType;

public class StartUp {
	private static JdbcDataSource jdbcDataSource;
	public static void main(String[] args) {
		StartUp startUp = new StartUp();
		startUp.initDataSource();
		if (jdbcDataSource.getErrorMsg() != ErrorMsg.NONE) {
			System.err.println(jdbcDataSource.getErrorMsg());
			System.exit(-1);
		}
		System.out.println("datasource init done ！" + jdbcDataSource.toString());
		DbStruct dbStruct = new DbStruct(jdbcDataSource);
		System.out.println(dbStruct.dbInfo());
		dbStruct.scheamsInfo("test1").forEach(d->{
			System.out.println(d.geTableInfos());
		});
		dbStruct.getTablesInfo("test1", "", new TableType[] {}).forEach(e->{
			List<ColumnInfo> columnInfos = e.getColumnInfos();
			columnInfos.forEach(c->{
				System.out.println(c);
			});
		});
	}
	
	public void initDataSource() {
		jdbcDataSource = LoadDataSource.load();
	}
}
