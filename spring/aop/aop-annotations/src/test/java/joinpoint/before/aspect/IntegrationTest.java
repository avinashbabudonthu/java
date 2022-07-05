package joinpoint.before.aspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/joinpoint.before.aspect/applicationContext.xml" })
public class IntegrationTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void findStudent() {
		Student2 student = studentService.findStudent();
		log.info("student={}", student);
	}
}
