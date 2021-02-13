package AutoDotNetCoreApiPackage;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SelectPoster {
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	PostData Data;
	String Url;
	OkHttpClient client ;
	public SelectPoster(PostData data, String url,String jwt) {
		Data = data;
		this.Url=url;
		client = new OkHttpClient.Builder().addInterceptor(new JwtAuthenticationInterceptor(jwt)).build();
	}

	public String post() throws IOException {
        String json=this.PrepareJson();
		RequestBody body = RequestBody.create(json, JSON);
		//System.out.println(json);
		//System.out.println(this.Url);
		Request request = new Request.Builder().url(Url).post(body).build();
		Response response = client.newCall(request).execute();
			String res=response.body().string();
			System.out.println(res);
			return res;
		
	}

	public String PrepareJson() {
		Gson gson = new Gson();  
		String json=gson.toJson(this.Data);  
		return json;
	}
}
