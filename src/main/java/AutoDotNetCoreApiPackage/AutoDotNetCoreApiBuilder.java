package AutoDotNetCoreApiPackage;

public class AutoDotNetCoreApiBuilder {

	private String Host, JWT;

	public AutoDotNetCoreApiBuilder(String host, String jwt) {
		Host = host;
		JWT = jwt;
	}

	public <T> AutoDotNetCoreApiTable<T> Table(String name, Class<T[]> type) {
		return new AutoDotNetCoreApiTable<T>(name, Host,JWT, type);
	}
	public <T> AutoDotNetCoreApiView<T> View(String name, Class<T[]> type) {
		return new AutoDotNetCoreApiView<T>(name, Host,JWT, type);
	}
	public <T> AutoDotNetCoreApiStoredProc<T> StoredProc(String name, Class<T[]> type) {
		return new AutoDotNetCoreApiStoredProc<T>(name, Host,JWT, type);
	}
}
