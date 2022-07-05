package basic.constructor.injection;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"basic.constructor.injection/applicationContext.xml")) {
			StudentService studentService = applicationContext.getBean("studentServiceImpl", StudentService.class);
			Student student = studentService.findStudent();
			log.info("student={}", student);
		}
	}
}
