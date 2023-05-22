package pointcut.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/pointcut.annotation/applicationContext.xml")
public class IntegrationTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void run() {
		Student7 student = studentService.findStudent();
		log.info("student={}", student);
	}
}
