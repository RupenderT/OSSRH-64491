
## AutoDotNetCoreApi Java Library for Android
AutodotnetCoreApi also have a java library to consume AutodotnetCoreApi from Java programs  or Android Apps
# Usage of  Java Library:
Add AutoDotNetCoreApi dependency to your project.

https://search.maven.org/artifact/com.github.rupendert/autodotnetcoreapi

## Apache Maven
        <dependency>
             <groupId>com.github.rupendert</groupId>
             <artifactId>autodotnetcoreapi</artifactId>
             <version>1.0.1</version>
        </dependency>

## Gradle Groovy DSL
        implementation 'com.github.rupendert:autodotnetcoreapi:1.0.1'

## Gradle Kotlin DSL
        implementation("com.github.rupendert:autodotnetcoreapi:1.0.1")
        
## Scala SBT
        libraryDependencies += "com.github.rupendert" % "autodotnetcoreapi" % "1.0.1"
        
## Apache Ivy
        <dependency org="com.github.rupendert" name="autodotnetcoreapi" rev="1.0.1" />
        
## Groovy Grape
        @Grapes(
            @Grab(group='com.github.rupendert', module='autodotnetcoreapi', version='1.0.1')
              )
              
## Leiningen
        [com.github.rupendert/autodotnetcoreapi "1.0.1"]
        
## Apache Buildr

        'com.github.rupendert:autodotnetcoreapi:jar:1.0.1'
        
## Maven Central Badge
        [![Maven Central](https://img.shields.io/maven-central/v/com.github.rupendert/autodotnetcoreapi.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.rupendert%22%20AND%20a:%22autodotnetcoreapi%22)
        
## PURL 
        pkg:maven/com.github.rupendert/autodotnetcoreapi@1.0.1
        
## Bazel
        maven_jar(
            name = "autodotnetcoreapi",
            artifact = "com.github.rupendert:autodotnetcoreapi:1.0.1",
            sha1 = "fc59a335f8310ded8378d9572461c152e06e3073",
        )
        
## Dependencies:
        com.google.code.gson:gson com.squareup.okhttp3:okhttp com.squareup.okio:okio org.jetbrains.kotlin:kotlin-stdlib

####  First create a class for representing your Sql Server Table  or View like :
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
            }
        
Create Object of AutoDotNetCoreApiBuilder
         AutoDotNetCoreApiBuilder builder=new AutoDotNetCoreApiBuilder(api, jwt);

Now use apiBuilder object to get object of your class like:
      
       AutoDotNetCoreApiTable<T> employeeTable=builder.Table(name,T[].class);
        
 - **T**: T is your class type who represent your Table(All properties name must    match the table columns name)

- **tableName**: name of the table in your database;

For creating Database Views
         AutoDotNetCoreApiView<T>  dbView=builder.View(name,T[].class)

For stored procedure
        AutoDotNetCoreApiStoredProc<T> db_sp=builder.StoredProc(name,T[].class)
        
Table Object you can use For:
-   Getting the data of table,
- Filterint the table data,
- For updateing the row,
- For adding new row
- Get the count of table rows
- And  more.
## Available methods for Table And View

-	First
-	Select
-	Desc
-	Asc
-	Distinct
-	OrderBy
-	Where
-	Get
-	Count
-	Take

## Available methods for Table
-	Delete
-	Add
-	Update
	

## Available Method for  Stored Procedure
-   Execute;

## T[] Get(ApiSelectCallback)
    this method will return from the table and will filter data if you used any where clasue before it
       employees.Desc("employeeid").get(ApiSelectCallback)
##  First()
#### First() is chaining method after using this you will get only top row of your table eg:
     employees.Select(["Id,name"]).Desc("id").First().getResult(new ApiSelectCallback{
     @Override
                public void call(T[] array) {
                    //use array here
                }

                @Override
                public void onFailure(IOException e) {
                    
                }
     });
        
##  select(stringArr)
##### is chaining method it takes array of columnsNames and when you use GetResult method on your table you will get values in only those fileds eg:
       
        employees.Select({"id", "Name").getResult(new ApiSelectCallback{
     @Override
                public void call(T[] array) {
                    //use array here
                }

                @Override
                public void onFailure(IOException e) {
                    
                }
     }); 
 
## Desc(columnName)
    Select result in Desc order.
## Asc(columnName)
    Select result in Asc order
## OrderBy(SqlSort[] arr)
    will order the result by given array
## Where(columnName)
    will return the object of WhereClause set on the given column name;
    In where clause you can create a chain of metods to filter the data like this
    employees.Where("DOBMonth").Between("1", "2").Where("id").Above("1").getResult(ApiSelectCallback)

## WhereClause have following Methods
- above(String val);
-  aboveOrEqual(String val);
- below(String val) ;
-  belowOrEqual(String val)
- between(String val1, String val2); 
-  equals(String val);
-  notEquals(String val);
- isNull()
- isNotNull()

WhereClause metods returns the object of your tableClass so you can add another filter on the table.

Methods of AutoDotNetCoreApiTable Object
## Add(T Obj,ApiPostCallback<T>)
 add Method accepts your Class object without Idenity Column and it will add new row in table.
       employees.add(obj,new ApiPostCallback<Employee>{
       public void call(Boolean aBoolean) {
                    if(aBoolean){
                        Snackbar.make(view,"Insert done", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

                @Override
                public void onFailure(IOException e) {

                }
       })
  
## Update(T obj)
   update metods accepts object with the properties which you want to update in table you must use where caluse to add
   filter other wise it will update all rows in absence of where clause.
         employees.Where("Employeeid").Equals(id).Update(obj,new ApiPostCallback<Employee>{
       public void call(Boolean aBoolean) {
                    if(aBoolean){
                        Snackbar.make(view,"Update done", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

                @Override
                public void onFailure(IOException e) {

                }
       });

## Delete()
it will delete the recored from the table accourding to filter criteria you given using whereClause 
    employees.Where("employeeid").Equals(id).Delete(new ApiPostCallback<Employee>{
       public void call(Boolean aBoolean) {
                    if(aBoolean){
                        Snackbar.make(view,"Deleted", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }

                @Override
                public void onFailure(IOException e) {

                }
       })
    
## Execute(String[] arr,ApiSelectCallback)(From Stored Proc):
execute method require array of string for the parameters of your db stroed proc. if db stroed proc. dosen't reqire any so provide an empty array;



