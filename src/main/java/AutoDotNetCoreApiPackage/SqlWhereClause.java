package AutoDotNetCoreApiPackage;

public class SqlWhereClause {
	
   public String name;
   public String value;
   public String operator;
   
   public SqlWhereClause(String name,String value,String operator) {
	   this.name=name;
	   this.value=value;
	   this.operator=operator;
   }
}
