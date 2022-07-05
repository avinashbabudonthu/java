package autowire.by.type;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	@Setter
	private Student student;

	/**
	 * @see autowire.by.type.StudentRepository#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("Find student");
		return student;
	}
}
