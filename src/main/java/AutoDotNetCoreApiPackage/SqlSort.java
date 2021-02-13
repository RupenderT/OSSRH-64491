package AutoDotNetCoreApiPackage;

public class SqlSort {

	public SqlSort(String name, SqlSortTypes by) {
		this.name = name;
		this.by = by;
	}

	public String name;
	public SqlSortTypes by;
}
