package AutoDotNetCoreApiPackage;

import java.util.ArrayList;

public class PostData {

	int top;
	ArrayList<String> select = new ArrayList<String>();
	ArrayList<SqlWhereClause> where = new ArrayList<SqlWhereClause>();
	ArrayList<String> groupBy = new ArrayList<String>();
	ArrayList<SqlSort> orderBy = new ArrayList<SqlSort>();
	boolean isDistinct = false;
	ArrayList<Between> betweens = new ArrayList<Between>();
	Object obj;
}
