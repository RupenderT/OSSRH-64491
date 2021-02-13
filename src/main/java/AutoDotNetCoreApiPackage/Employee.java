package AutoDotNetCoreApiPackage;

public class Employee {
	 public String employeeID;
     public String lastName;
     public String firstName;
     public String title;
     public String titleOfCourtesy;
     public String birthDate;
     public String hireDate;
     public String address;
     public String city;
     public String region;
     public String postalCode;
     public String country;
     public String homePhone;
     public String extension;
     public String photo;
     public String notes;
     public String reportsTo;
     public String photoPath;
     
     @Override
     public String toString() {
    	 return "Employee{Name="+this.firstName+" "+this.lastName+", Id="+employeeID+"}";
     }
}
