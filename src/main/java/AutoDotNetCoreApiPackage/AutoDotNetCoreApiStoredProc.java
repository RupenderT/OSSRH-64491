package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

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

	public T[] Select(String[] params) {

		String url = this.API();
		Poster poster = new Poster(params, url,JWT);
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

	String API() {
		return this.Host + "storedProc/" + this.SP_Name;
	}

}
