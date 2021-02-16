package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoDotNetCoreApiStoredProc<T> implements IAutoDotNetCoreAPIStoredProc<T> {

	String SP_Name;
	String Host;
	Class<T[]> Type;
	String JWT;
	public AutoDotNetCoreApiStoredProc(String sp_Name, String host,String jwt,Class<T[]> type) {
		SP_Name = sp_Name;
		Host = host;
		Type=type;
		// TODO Auto-generated constructor stub
	}

	public T[] Execute(String[] params,final ApiSelectCallback<T> callback) {

		String url = this.API();
		Poster poster = new Poster(params, url,JWT);
		try {
			 poster.post().enqueue(new Callback() {

				@Override
				public void onFailure(Call arg0, IOException arg1) {
					callback.onFailure(arg1);
					
				}

				@Override
				public void onResponse(Call arg0, Response res) throws IOException {
					String json=res.body().string();
					T[] arr = new Gson().fromJson(json, Type);
					callback.call(arr);
					
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(JsonSyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	String API() {
		return this.Host + "storedProc/" + this.SP_Name;
	}

}
