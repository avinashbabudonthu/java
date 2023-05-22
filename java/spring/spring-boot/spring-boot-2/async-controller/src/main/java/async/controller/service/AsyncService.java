package async.controller.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import async.controller.model.Courses;
import async.controller.model.Employees;
import async.controller.model.Students;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

	@Autowired
	private RestTemplate restTemplate;

	@Async("asyncExecutor")
	public CompletableFuture<Employees> findAllEmployees() throws InterruptedException {
		log.info("finding all employees");
		final String url = "http://localhost:9090/employees";
		Employees employees = restTemplate.getForObject(url, Employees.class);
		log.info("employees={}", employees);

		Thread.sleep(1000L * 5);

		return CompletableFuture.completedFuture(employees);
	}

	@Async("asyncExecutor")
	public CompletableFuture<Courses> findAllCourses() throws InterruptedException {
		log.info("finding all courses");
		final String url = "http://localhost:9090/courses";
		Courses courses = restTemplate.getForObject(url, Courses.class);
		log.info("courses={}", courses);

		Thread.sleep(1000L * 5);

		return CompletableFuture.completedFuture(courses);
	}

	@Async("asyncExecutor")
	public CompletableFuture<Students> findAllStudents() throws InterruptedException {
		log.info("finding all students");
		final String url = "http://localhost:9090/students";
		Students students = restTemplate.getForObject(url, Students.class);
		log.info("students={}", students);

		Thread.sleep(1000L * 5);

		return CompletableFuture.completedFuture(students);
	}
}
