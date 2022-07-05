package after.throwing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/after.throwing/applicationContext.xml")
public class IntegrationTest {

	@Autowired
	private StudentService studentService;

	@Test(expected = RuntimeException.class)
	public void run() {
		Student4 student = studentService.findStudent();
		log.info("student={}", student);
	}
}
