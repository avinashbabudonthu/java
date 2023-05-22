package component.scan.with.annotations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class StudentServiceTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void findStudent() {
		Student student = studentService.findStudent();
		log.info("student={}", student);
	}
}
