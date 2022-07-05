package autowire.by.type;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"autowire.by.type/application-context.xml")) {
			StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
			log.info("student={}", studentService.findStudent());
		}
	}
}
