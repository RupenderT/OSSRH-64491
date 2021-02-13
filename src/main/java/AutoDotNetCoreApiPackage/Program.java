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
         PrintStream stream 
         = new PrintStream(System.out);
         stream.println(arr); 
         stream.flush();

	}

}
