package autowire.constructor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	/**
	 * @see autowire.constructor.StudentService#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return studentRepository.findStudent();
	}
}
