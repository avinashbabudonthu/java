package before.aspect;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"before.aspect/applicationContext.xml")) {
			StudentService studentService = context.getBean(StudentService.class);
			Student student = studentService.findStudent();
			log.info("student={}", student);
		}
	}
}
