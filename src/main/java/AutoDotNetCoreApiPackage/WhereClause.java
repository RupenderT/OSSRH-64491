package AutoDotNetCoreApiPackage;
import java.lang.reflect.*;

public class WhereClause<T,U>  {

	String On;
	T Obj;
	Class<T> Type;

	public WhereClause(String on, T obj) {
		this.On = on;
		this.Obj = obj;
	}

	public U Above(String val) {
	Field data=Obj.getClass().getField("Data");
	 Method where=data.getClass().getMethod("where",null);
	 Class[] carg=new Class[1];
	 carg[0]=SqlWhereClause.class;
	 Method add=where.getClass().getMethod("add",carg );
	 add.
		Obj.Data.where.add(new SqlWhereClause(this.On,val,">"));
		return this.Obj;
	}

	public T AboveOrEqual(String val) {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,val,">="));
		return this.Obj;
	}

	public T Below(String val) {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,val,"<"));
		return this.Obj;
	}

	public T BelowOrEqual(String val) {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,val,">="));
		return this.Obj;
	}

	public T Between(String val1,String val2) {
		((AutoDotNetCoreApi<U>)Obj).Data.betweens.add(new Between(val1, val2));
		return this.Obj;
	}

	public T Equals(String val) {
		System.out.println(val);
		System.out.println(this.On);
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,val,"="));
		return this.Obj;
	}

	public T NotEquals(String val) {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,val,"<>"));
		return this.Obj;
	}
	public T IsNull() {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,"AUTOSQLNULL","IS"));
		return this.Obj;
	}
	public T NotEquals() {
		((AutoDotNetCoreApi<U>)Obj).Data.where.add(new SqlWhereClause(this.On,"AUTOSQLNULL","IS NOT"));
		return this.Obj;
	}

	
}
