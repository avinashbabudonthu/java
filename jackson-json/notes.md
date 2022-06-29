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