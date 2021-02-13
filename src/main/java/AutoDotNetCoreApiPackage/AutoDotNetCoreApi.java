package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public abstract class AutoDotNetCoreApi<T> implements Cloneable {

	PostData Data = new PostData();
	String currentWhereOn;
	Class<T[]> Type;

	String TableName, Host,JWT;

	public AutoDotNetCoreApi(String tableName, String host,String jwt,Class<T[]> obj) {
		this.TableName = tableName;
		this.Host = host;
		this.Type=obj;
		this.JWT=jwt;
	}

	public T[] Get() {
		return this.Execute(RequestType.GET);
	}
	public AutoDotNetCoreApi<T> first() {
		this.Data.top = 1;
		return this;
	}

	public AutoDotNetCoreApi<T> Select(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.Data.select.add(arr[i]);
		}
		return this;
	}

	public AutoDotNetCoreApi<T> Desc(String by) {
		if (!by.isEmpty())
			this.Data.orderBy.add(new SqlSort(by, SqlSortTypes.DESC));

		return this;
	}

	public AutoDotNetCoreApi<T> Asc(String by) {
		if (!by.isEmpty())
			this.Data.orderBy.add(new SqlSort(by, SqlSortTypes.ASC));

		return this;
	}

	public AutoDotNetCoreApi<T> Distinct() {
		this.Data.isDistinct = true;
		return this;
	}

	public AutoDotNetCoreApi<T> OrderBy(SqlSort[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.Data.orderBy.add(arr[i]);
		}
		return this;
	}

	public String Count() {
		this.Data.select.add("COUNT(*) Total");
		return ExecutePlain(RequestType.GET);
	}

	public AutoDotNetCoreApi<T> Take(int number) {
		this.Data.top = number;
		return this;
	}

	public WhereClause<AutoDotNetCoreApi<T>,T> Where(String on) {
		try {
			this.currentWhereOn=on;
			AutoDotNetCoreApi<T> copy = (AutoDotNetCoreApi<T>) this.clone();
			return new WhereClause<AutoDotNetCoreApi<T>,T>(this.currentWhereOn, copy);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public T[] Execute(RequestType type) {
		String url = GetAPIUrl(type);
		SelectPoster poster = new SelectPoster(this.Data, url,JWT);
		try {
			String json = poster.post();
			T[] arr = new Gson().fromJson(json, this.Type);
			return arr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(JsonSyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	public T[] GetResult() {
		return this.Execute(RequestType.GET);
	}
	protected String GetAPIUrl(RequestType type) {
		switch (type) {
		case GET:
			return this.Host + "Get/" + this.TableName;
		case POST:
			return this.Host + "POST/" + this.TableName;
		case PUT:
			return this.Host + "PUT/" + this.TableName;
		case DELETE:
			return this.Host + "DELETE/" + this.TableName;
		case STOREDPROC:
			return this.Host + "storedProc/" + this.TableName;

		}
		return null;
	}

	protected String ExecutePlain(RequestType type) {
		String url = GetAPIUrl(type);
		SelectPoster poster = new SelectPoster(this.Data, url,JWT);
		try {
			String json = poster.post();

			return json;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
