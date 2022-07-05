package basic.constructor.injection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentRepositoryImpl implements StudentRepository {

	public Student student;

	public StudentRepositoryImpl(Student student) {
		this.student = student;
	}

	@Override
	public Student findStudent() {
		log.info("find student");
		return this.student;
	}

}
