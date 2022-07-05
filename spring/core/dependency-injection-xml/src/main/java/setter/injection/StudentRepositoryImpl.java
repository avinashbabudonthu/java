package setter.injection;

import java.util.Arrays;
import java.util.List;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	@Setter
	private Student student;

	public List<Student> findAllStudents() {
		log.info("find student");
		return Arrays.asList(student);
	}
}
