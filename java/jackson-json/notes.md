# Dependencies
* Jackon dependencies - check for latest version
```
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-core</artifactId>
	<version>2.10.0</version>
</dependency>

<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-annotations</artifactId>
	<version>2.10.0</version>
</dependency>

<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.10.0</version>
</dependency>
```
# Ignore Unknow Properties
* Use `com.fasterxml.jackson.annotation.JsonIgnoreProperties`
* Use at class level
* Example
```
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeModel {
	
	private String name;
	private String designation;
	
}
```

# Ignore properties in json
* Example
```
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
   public static void main(String args[]) {
      ObjectMapper mapper = new ObjectMapper();
      try {
         Student student = new Student(1,11,"1ab","Mark");       
         String jsonString = mapper
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(student);
         System.out.println(jsonString);
      }
      catch (IOException e) { 
         e.printStackTrace();
      }   
   }
}
@JsonIgnoreProperties({ "id", "systemId" })
class Student {
   public int id;
   public String systemId;
   public int rollNo;
   public String name;

   Student(int id, int rollNo, String systemId, String name){
      this.id = id;
      this.systemId = systemId;
      this.rollNo = rollNo;
      this.name = name;
   }
}
```
* Output
```
{
"rollNo" : 11,
"name" : "Mark"
}
```

# JSON file to object
* Employee json
```
{
  "name": "jack",
  "designation": "SE"
}
```
* Employee class
```
package com.java;

public class Employee {

    private String name;
    private String designation;
    
    // getters & setters

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
```
* Main method
```
package com.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.net.URL;

public class JSONToObjects {

    @Test
    public void jsonFileToObject(){
        final ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = null;
        try {
            URL url = getClass().getClassLoader().getResource("employee.json");
            employee = objectMapper.readValue(url, Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee);
    }
}
```
* Output
```
Employee{name='jack', designation='SE'}
```
