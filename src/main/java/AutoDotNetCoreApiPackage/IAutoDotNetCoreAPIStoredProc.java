package AutoDotNetCoreApiPackage;
/**
 * 
 */

/**
 * @author MIPL
 *
 */
public interface IAutoDotNetCoreAPIStoredProc<T> {
	T[] Select(String[] params,ApiSelectCallback<T> callback);

}
