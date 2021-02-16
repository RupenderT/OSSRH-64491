package AutoDotNetCoreApiPackage;
/**
 * 
 */

/**
 * @author MIPL
 *
 */
public interface IAutoDotNetCoreAPITable<T> {
	Object Select(String[] arr);

	void Add(T model,ApiPostCallback<T> callback);

	void Update(T model,ApiPostCallback<T> callback);

	void Delete(ApiPostCallback<T> callback);
}
