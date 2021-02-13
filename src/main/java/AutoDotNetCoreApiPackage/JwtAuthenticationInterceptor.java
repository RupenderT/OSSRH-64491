package AutoDotNetCoreApiPackage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class JwtAuthenticationInterceptor implements Interceptor {
	 private String jwtToken;

	   
	    public JwtAuthenticationInterceptor(String jwtToken) {
	    	 this.jwtToken = jwtToken;
	    }


	    public Response intercept(Chain chain) throws IOException {
	        Request original = chain.request();

	        Request.Builder builder = original.newBuilder()
	                .header("Authorization","Bearer " +jwtToken);
	                        //String.format("Bearer %s", jwtToken));

	        Request request = builder.build();
	        return chain.proceed(request);
	    }
}
