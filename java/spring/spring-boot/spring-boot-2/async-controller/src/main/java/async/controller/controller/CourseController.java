package async.controller.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import async.controller.model.Course;
import async.controller.model.Courses;

@RestController
public class CourseController {

	@GetMapping(value = "/courses", produces = APPLICATION_JSON_VALUE)
	public Courses findAllCourses() {
		Course course1 = Course.builder().name("java").duration(10).build();
		Course course2 = Course.builder().name("spring").duration(2).build();
		Course course3 = Course.builder().name("spring boot").duration(1).build();

		return Courses.builder().courses(Arrays.asList(course1, course2, course3)).build();
	}
}
