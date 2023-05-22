package method.level.annotation.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/method.level.annotation.aspect/applicationContext.xml")
public class IntegrationTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void run() {
		Student6 student = studentService.findStudent();
		log.info("student={}", student);
	}
}
