package autowire.constructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	private Student student;

	public StudentRepositoryImpl(Student student) {
		this.student = student;
	}

	/**
	 * 
	 * @see autowire.constructor.StudentRepository#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return this.student;
	}
}
