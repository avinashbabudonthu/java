package afterreturn.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/")
public class IntegrationTest {

	@Test
	public void run() {
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"afterreturn.aspect/applicationContext.xml")) {
			StudentService studentService = context.getBean(StudentService.class);
			String studentName = studentService.findStudent();
			log.info("student-name={}", studentName);
		}
	}
}
