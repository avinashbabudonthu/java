package mockito.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lombok.extern.slf4j.Slf4j;
import mockito.model.Student;
import mockito.utils.Utils;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class StudentRepositoryTest {

	@InjectMocks
	private StudentRepository studentRepository;

	@Spy
	private Utils utils = new Utils();

	@Test
	public void findStudent() {
		Student student = studentRepository.findStudent();
		log.info("student={}", student);
	}
}