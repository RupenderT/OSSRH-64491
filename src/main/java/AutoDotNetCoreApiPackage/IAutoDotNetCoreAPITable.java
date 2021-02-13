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

	boolean Add(T model);

	boolean Update(T model);

	boolean Delete();
}
