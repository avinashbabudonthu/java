package properties.injection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	@Setter
	private Student student;

	/**
	 * @see properties.injection.StudentRepository#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return student;
	}
}
