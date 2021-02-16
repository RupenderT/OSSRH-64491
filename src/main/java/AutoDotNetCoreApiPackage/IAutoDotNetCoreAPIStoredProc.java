package AutoDotNetCoreApiPackage;
/**
 * 
 */

/**
 * @author MIPL
 *
 */
public interface IAutoDotNetCoreAPIStoredProc<T> {
	T[] Execute(String[] params,ApiSelectCallback<T> callback);

}
