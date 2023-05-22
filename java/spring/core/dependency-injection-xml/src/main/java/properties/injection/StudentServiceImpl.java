package properties.injection;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentServiceImpl implements StudentService {

	@Setter
	private StudentRepository studentRepository;

	/**
	 * @see properties.injection.StudentService#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return studentRepository.findStudent();
	}
}
