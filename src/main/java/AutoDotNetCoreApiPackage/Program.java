package AutoDotNetCoreApiPackage;

import java.io.PrintStream;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		 String api="http://localhost:53106/api/myapi/";
		 AutoDotNetCoreApiBuilder builder=new AutoDotNetCoreApiBuilder(api, "");
         AutoDotNetCoreApiTable<Employee> employee=builder.Table("Employees", Employee[].class);
         Employee[] arr=employee.GetResult();
         System.out.print(Arrays.toString(arr));
         
         Employee em=new Employee();
         em.firstName="from ";
         em.lastName="java";
         boolean res=employee.Add(em);
         System.out.print(res);
         Employee[] e=employee.Where("lastname").Equals("java").GetResult();
         System.out.println(Arrays.toString(e));
         if(e.length>0) {
        	 Employee e1=e[0];
        	 e1.lastName="javaup";
        	 employee.Where("lastname").Equals("java").Update(e1);
         }
         
	}

}
