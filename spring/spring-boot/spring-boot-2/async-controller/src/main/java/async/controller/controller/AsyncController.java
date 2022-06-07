package async.controller.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import async.controller.model.Courses;
import async.controller.model.Employees;
import async.controller.model.Students;
import async.controller.service.AsyncService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AsyncController {

	@Autowired
	private AsyncService asyncService;

	@SneakyThrows
	@GetMapping(value = "/data", produces = APPLICATION_JSON_VALUE)
	public Map<String, Object> findData() {
		log.info("getting students, courses, employees");

		CompletableFuture<Students> students = asyncService.findAllStudents();
		CompletableFuture<Courses> courses = asyncService.findAllCourses();
		CompletableFuture<Employees> employees = asyncService.findAllEmployees();

		// wait until all apis are done
		CompletableFuture.allOf(students, courses, employees).join();

		Map<String, Object> result = new HashMap<>();
		result.put("students", students.get());
		result.put("courses", courses.get());
		result.put("employees", employees.get());

		return result;
	}
}
