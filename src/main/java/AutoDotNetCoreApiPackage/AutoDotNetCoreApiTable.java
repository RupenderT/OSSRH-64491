package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;

public class AutoDotNetCoreApiTable<T> extends AutoDotNetCoreApi<T> implements IAutoDotNetCoreAPITable<T> {

	public AutoDotNetCoreApiTable(String tableName, String host,String jwt, Class<T[]> type) {
		super(tableName, host,jwt,type);
		// TODO Auto-generated constructor stub
	}

	public WhereClause<AutoDotNetCoreApiTable<T>,T> Where(String on) {
		try {
			this.currentWhereOn=on;
			AutoDotNetCoreApiTable<T> copy = (AutoDotNetCoreApiTable<T>) this.clone();
			return new WhereClause<AutoDotNetCoreApiTable<T>,T>(this.currentWhereOn, copy);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	} 
	
	public boolean Add(T model) {
		String url = GetAPIUrl(RequestType.POST);
		Poster poster = new Poster(model, url,JWT);
		try {
			String json = poster.post();
			if (json == "1")
				return true;
			else
				throw new Exception(json);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

	public boolean Update(T model) {
		String url = GetAPIUrl(RequestType.PUT);
		Poster poster = new Poster(model, url,JWT);
		try {
			String json = poster.post();
			if (json == "1")
				return true;
			else
				throw new Exception(json);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

	public boolean Delete() {
		String url = GetAPIUrl(RequestType.DELETE);
		SelectPoster poster = new SelectPoster(this.Data, url,JWT);
		try {
			String json = poster.post();
			if (json == "1")
				return true;
			else
				throw new Exception(json);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return false;
	}

}
