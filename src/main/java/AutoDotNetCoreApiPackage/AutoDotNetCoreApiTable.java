package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoDotNetCoreApiTable<T> extends AutoDotNetCoreApi<T> implements IAutoDotNetCoreAPITable<T> {

	public AutoDotNetCoreApiTable(String tableName, String host, String jwt, Class<T[]> type) {
		super(tableName, host, jwt, type);
		// TODO Auto-generated constructor stub
	}

	public WhereClause<AutoDotNetCoreApiTable<T>, T> Where(String on) {
		try {
			this.currentWhereOn = on;
			AutoDotNetCoreApiTable<T> copy = (AutoDotNetCoreApiTable<T>) this.clone();
			return new WhereClause<AutoDotNetCoreApiTable<T>, T>(this.currentWhereOn, copy);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void Add(T model, final ApiPostCallback<T> callback) {
		String url = GetAPIUrl(RequestType.POST);
		Poster poster = new Poster(model, url, JWT);
		try {
			poster.post().enqueue(new Callback() {

				@Override
				public void onFailure(Call arg0, IOException arg1) {
					callback.onFailure(arg1);
				}

				@Override
				public void onResponse(Call arg0, Response res) throws IOException {
					String json = res.body().string();
					callback.call(json.equals("1"));

				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void Update(T model,final ApiPostCallback<T> callback) {
		String url = GetAPIUrl(RequestType.PUT);
		this.Data.obj = model;
		Poster poster = new Poster(this.Data, url, JWT);
		try {
			poster.post().enqueue(new Callback() {

				@Override
				public void onFailure(Call arg0, IOException arg1) {
					callback.onFailure(arg1);

				}

				@Override
				public void onResponse(Call arg0, Response res) throws IOException {
					String json = res.body().string();
					callback.call(json.equals("1"));

				}
			});
			;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void Delete(final ApiPostCallback<T> callback) {
		String url = GetAPIUrl(RequestType.DELETE);
		Poster poster = new Poster(this.Data, url, JWT);
		try {
			poster.post().enqueue(new Callback() {

				@Override
				public void onFailure(Call arg0, IOException arg1) {
					callback.onFailure(arg1);

				}

				@Override
				public void onResponse(Call arg0, Response res) throws IOException {
					String json = res.body().string();
					callback.call(json.equals("1"));

				}
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
