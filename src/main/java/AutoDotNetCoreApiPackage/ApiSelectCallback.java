package AutoDotNetCoreApiPackage;

import java.io.IOException;

public interface ApiSelectCallback<T> {

	void call(T[] arr);
	void onFailure(IOException arg1);
}
