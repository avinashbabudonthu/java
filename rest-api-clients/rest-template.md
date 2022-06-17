# Model
```
public class Student {

	private String email;
	private String password;
	private Boolean rememberMe;

	public Student() {
	}

	public Student(String email, String password, Boolean rememberMe) {
		this.email = email;
		this.password = password;
		this.rememberMe = rememberMe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "{email=" + email + ", password=" + password + ", rememberMe=" + rememberMe + "}";
	}

}
```

# API imports
```
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
```

# Client imports
```
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
```

# Simple API that return String
## API
```
@GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
public String hello() {
	return "Spring Rest Angular 4 Hello World";
}
```
## Client
```
public void hello() {
	RestTemplate restTemplate = new RestTemplate();
	String response = restTemplate.getForObject("http://localhost:9090/hello", String.class);
	System.out.println(response);
}
```

# Simple API that return list of Objects
## API
```
@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
public List<Student> getAllStudents() {
	Student student1 = new Student("jack@test.com", "jack", true);
	Student student2 = new Student("jill@test.com", "jill", false);
	Student student3 = new Student("john@test.com", "john", true);

	return Arrays.asList(student1, student2, student3);
}
```
## Client
```
public void getAllStudents() {
	final RestTemplate restTemplate = new RestTemplate();
	final String url = "http://localhost:9090/students";
	String response = restTemplate.getForObject(url, String.class);
	System.out.println(response);
}
```

# With request parameters
## API
```
@GetMapping(value = "/students2", produces = APPLICATION_JSON_VALUE)
public Student getStudent(@RequestParam("email") String email, @RequestParam("password") String password) {
	return new Student(email, password, true);
}
```
## Client
```
public void getStudent() {
	final RestTemplate restTemplate = new RestTemplate();
	final String url = "http://localhost:9090/students2?email=jack@test.com&password=123test";
	String response = restTemplate.getForObject(url, String.class);
	System.out.println(response);
}
```

# With path variables
## API
```
@GetMapping(value = "/students/{email}/{password}", produces = APPLICATION_JSON_VALUE)
public Student getStudent2(@PathVariable("email") String email, @PathVariable("password") String password) {
	return new Student(email, password, true);
}
```
## Client
```
public void getStudent2() {
	final RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:9090/students/jack@test.com/123test";
	String response = restTemplate.getForObject(url, String.class);
	System.out.println(response); 
	
	// method 2
	String urlWithPathParams = "http://localhost:9090/students/{email}/{password}";
	Map<String, String> pathParams = new HashMap<>();
	pathParams.put("email", "jack@test.com");
	pathParams.put("password", "test1223");
	Student student = restTemplate.getForObject(urlWithPathParams, Student.class, pathParams);
	System.out.println("student: " + student);
}
```
## Method 1 Output
```
{"email":"jack@test.com","password":"123test","rememberMe":true}
```
## Method 2 Output
```
student: {email=jack@test.com, password=test1223, rememberMe=true}
```

# With request headers
## API
```
@GetMapping(value = "/students3", produces = APPLICATION_JSON_VALUE)
public Student getStudent3(@RequestHeader("email") String email, @RequestHeader("password") String password) {
	return new Student(email, password, true);
}
```
## Client
```
public void getStudent3() {
	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.add("email", "jack@test.com");
	httpHeaders.add("password", "test123");

	HttpEntity<String> entity = new HttpEntity<String>("parameters", httpHeaders);

	ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/students3", HttpMethod.GET, entity, String.class);
	System.out.println(response.getBody());
}
```

# With request body
## API
```
@PostMapping(value = "/students", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public Student saveStudent(@RequestBody Student student) {
	return student;
}
```
## Client
```
public void saveStudent() {
	Student student = new Student("test", "test124", false);

	RestTemplate restTemplate = new RestTemplate();
	String response = restTemplate.postForObject("http://localhost:9090/students", student, String.class);
	System.out.println(response);
}
```

# With request body and request headers
## API
```
@PostMapping(value = "/students2", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public Student saveStudent2(@RequestBody Student student, @RequestHeader("email") String email, @RequestHeader("password") String password) {
	student.setEmail(email);
	student.setPassword(password);

	return student;
}
```
## Client
```
public void saveStudent2() {
	final String url = "http://localhost:9090/students2";

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.add("email", "jack@test.com");
	httpHeaders.add("password", "test123");

	Student student = new Student("test", "test124", false);

	HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
			String.class);
	System.out.println(response.getBody());
}
```

# With request headers only
## API
```
@PostMapping(value = "/students3", produces = APPLICATION_JSON_VALUE)
public Student saveStudent3(@RequestHeader("email") String email, @RequestHeader("password") String password) {
	Student student = new Student();

	student.setEmail(email);
	student.setPassword(password);

	return student;
}
```
## Client
```
public void saveStudent3() {
	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	httpHeaders.add("email", "jack@test.com");
	httpHeaders.add("password", "test123");

	HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

	ResponseEntity<String> response = restTemplate.exchange("http://localhost:9090/students3",
			HttpMethod.POST, entity, String.class);
	System.out.println(response.getBody());
}
```

# With request header and request param
## API
```
@PostMapping(value = "/students4", produces = APPLICATION_JSON_VALUE)
public Student saveStudent4(@RequestHeader("email") String email, @RequestParam("password") String password) {
	Student student = new Student();

	LOGGER.info("students3(): {}", student);

	student.setEmail(email);
	student.setPassword(password);

	return student;
}
```
## Client
```
public void saveStudent4() {
	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	httpHeaders.add("email", "jack@test.com");

	HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

	ResponseEntity<String> response = restTemplate.exchange(
			"http://localhost:9090/students4?password=23456", HttpMethod.POST, entity, String.class);
	System.out.println(response.getBody());
}
```

# With request param only
## API
```
@PostMapping(value = "/students5", produces = APPLICATION_JSON_VALUE)
public Student saveStudent5(@RequestParam("email") String email, @RequestParam("password") String password) {
	Student student = new Student();

	student.setEmail(email);
	student.setPassword(password);

	return student;
}
```
## Client
```
public void saveStudent5() {
	final String url = "http://localhost:9090/students5?password=23456&email=test@test.com";

	RestTemplate restTemplate = new RestTemplate();

	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);

	HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

	// method 1
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	System.out.println(response.getBody());
	
	// method 2
	ResponseEntity<Student> response2 = restTemplate.exchange(url, HttpMethod.POST, entity, Student.class);
	System.out.println(response2.getBody());
}
```
## Method 1 Output
```
{"email":"test@test.com","password":"23456","rememberMe":null}
```
## Method 2 Output
```
{"email":"test@test.com","password":"23456","rememberMe":null}
```

# With body, request header, request param and path variable
## API
```
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.angular4.model.Student;

@PutMapping(value = "/student/{email}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public List<Student> updateStudent(@RequestBody Student studentBody, @PathVariable("email") String email,
			@RequestHeader("rememberMe") Boolean rememberMe, @RequestParam("password") String password) {
	LOGGER.info("update student. Input Student Body: {}, path variable email: {}, request param password:{}, request header rememberMe: {}", studentBody, email, password, rememberMe);

	List<Student> students = new ArrayList<>();

	Student student = new Student();
	student.setEmail(email);
	student.setPassword(password);
	student.setRememberMe(rememberMe);

	students.add(student);
	students.add(studentBody);

	return students;
}
```
## Client
```
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.springrest.angular4.model.Student;

public void updateStudent() {
	final String url = "http://localhost:9090/student/{email}?password=test1234";
	final RestTemplate restTemplate = new RestTemplate();

	// request headers
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	httpHeaders.add("rememberMe", "true");

	// path variables
	Map<String, String> pathParams = new HashMap<>();
	pathParams.put("email", "jack@test.com");

	// request body
	Student student = new Student("jill@test.com", "test1235", false);

	HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
	
	// API call
	restTemplate.put(url, httpEntity, pathParams);
}
```
## Output
```
update student. Input Student Body: {email=jill@test.com, password=test1235, rememberMe=false}, path variable email: jack@test, request param password:test1234, request header rememberMe: true
```

# With body, request header, request param and path variable
## API
```
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.angular4.model.Student;

private static final Logger LOGGER = LoggerFactory.getLogger(DeleteController.class);

@DeleteMapping(value = "/student/{email}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public List<Student> deleteStudent(@RequestBody Student studentBody,
	@PathVariable(value = "email", required = false) String email,
	@RequestHeader(value = "rememberMe", required = false) Boolean rememberMe,
	@RequestParam(value = "password", required = false) String password) {
	LOGGER.info("Delete student. Input Student Body: {}, path variable email: {}, request param password:{}, request header rememberMe: {}", studentBody, email, password, rememberMe);

	List<Student> students = new ArrayList<>();

	Student student = new Student();
	student.setEmail(email);
	student.setPassword(password);
	student.setRememberMe(rememberMe);

	students.add(student);
	students.add(studentBody);

	return students;
}
```
## Client
```
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.springrest.angular4.model.Student;

public void deleteStudent() {
	final String url = "http://localhost:9090/student/{email}?password=test1234";
	final RestTemplate restTemplate = new RestTemplate();

	// request headers
	HttpHeaders httpHeaders = new HttpHeaders();
	httpHeaders.setContentType(MediaType.APPLICATION_JSON);
	httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	httpHeaders.add("rememberMe", "true");

	// path variables
	Map<String, String> pathParams = new HashMap<>();
	pathParams.put("email", "jack@test.com");

	// request body
	Student student = new Student("jill@test.com", "test1235", false);

	HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);

	// API call
	restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class, pathParams);
}
```
## Output
```
Delete student. Input Student Body: {email=jill@test.com, password=test1235, rememberMe=false}, path variable email: jack@test, request param password:test1234, request header rememberMe: true
```
