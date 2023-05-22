package date.injection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	@Setter
	private Student student;

	@Override
	public Student findStudent() {
		log.info("find student");
		return student;
	}
}
