package AutoDotNetCoreApiPackage;

import java.io.IOException;

public interface ApiPostCallback<T> {

	
	void call(Boolean result);

	void onFailure(IOException arg1);
}
