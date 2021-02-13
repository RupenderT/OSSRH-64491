package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;

public class AutoDotNetCoreApiView<T> extends AutoDotNetCoreApi<T> {

	public AutoDotNetCoreApiView(String tableName, String host,String jwt,Class<T[]> type) {
		super(tableName, host,jwt,type);
		// TODO Auto-generated constructor stub
	}

	public WhereClause<AutoDotNetCoreApiView<T>,T> Where(String on) {
		try {
			this.currentWhereOn=on;
			AutoDotNetCoreApiView<T> copy = (AutoDotNetCoreApiView<T>) this.clone();
			return new WhereClause<AutoDotNetCoreApiView<T>,T>(this.currentWhereOn, copy);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	} 

	

}
