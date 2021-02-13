package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Poster {
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	Object Data;
	String Url;
	OkHttpClient client;
	public Poster(Object data, String url,String jwt) {
		Data = data;
		client = new OkHttpClient.Builder().addInterceptor(new JwtAuthenticationInterceptor(jwt)).build();
	}

	public String post() throws IOException {
        String json=this.PrepareJson();
		RequestBody body = RequestBody.create(json, JSON);
		System.out.println(json);
		System.out.println(this.Url);
		Request request = new Request.Builder().url(Url).post(body).build();
	Response response = client.newCall(request).execute();
			return response.body().string();
		
	}

	public String PrepareJson() {
		Gson gson = new Gson();  
		String json=gson.toJson(this.Data);  
		return json;
	}
}
