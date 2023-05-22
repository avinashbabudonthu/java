package autowire.constructor;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"autowire.constructor/application-context.xml")) {
			StudentService studentService = applicationContext.getBean("studentServiceImpl", StudentService.class);
			Student student = studentService.findStudent();
			log.info("student={}", student);
		}
	}
}
