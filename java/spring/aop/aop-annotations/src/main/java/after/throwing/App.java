package after.throwing;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test(expected = RuntimeException.class)
	public void run() {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"after.throwing/applicationContext.xml")) {
			StudentService studentService = context.getBean(StudentService.class);
			Student4 student = studentService.findStudent();
			log.info("student={}", student);
		}
	}
}
