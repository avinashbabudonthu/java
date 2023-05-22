package component.scan.with.annotations;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	@Test
	public void run() {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			StudentService studentService = context.getBean(StudentService.class);
			Student student = studentService.findStudent();
			log.info("student={}", student);
		}
	}
}
