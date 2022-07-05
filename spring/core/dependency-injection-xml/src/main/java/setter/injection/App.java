package setter.injection;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"setter.injection/setter-injection.xml")) {
			StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
			List<Student> studentsList = studentService.findAllStudents();
			log.info("students-list={}", studentsList);
		}
	}
}
