package AutoDotNetCoreApiPackage;


public class WhereClause<T, U> {

	String On;
	T Obj;
	Class<T> Type;

	public WhereClause(String on, T obj) {
		this.On = on;
		this.Obj = obj;
	}

	public T Above(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, ">"));
		return this.Obj;
	}

	public T AboveOrEqual(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, ">="));
		return this.Obj;
	}

	public T Below(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, "<"));
		return this.Obj;
	}

	public T BelowOrEqual(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, ">="));
		return this.Obj;
	}

	public T Between(String val1, String val2) {
		((AutoDotNetCoreApi<U>) Obj).Data.betweens.add(new Between(val1, val2));
		return this.Obj;
	}

	public T Equals(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, "="));
		return this.Obj;
	}

	public T NotEquals(String val) {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, val, "<>"));
		return this.Obj;
	}

	public T IsNull() {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, "AUTOSQLNULL", "IS"));
		return this.Obj;
	}

	public T NotEquals() {
		((AutoDotNetCoreApi<U>) Obj).Data.where.add(new SqlWhereClause(this.On, "AUTOSQLNULL", "IS NOT"));
		return this.Obj;
	}

	

}
