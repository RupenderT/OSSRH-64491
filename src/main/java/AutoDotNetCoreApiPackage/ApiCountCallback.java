package AutoDotNetCoreApiPackage;

import java.io.IOException;

public interface ApiCountCallback<T> {

	
	void call(String result);

	void onFailure(IOException arg1);
}
