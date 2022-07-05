package autowire.by.type;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentServiceImpl implements StudentService {

	@Setter
	private StudentRepository studentRepository;

	/**
	 * @see autowire.by.type.StudentService#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("Find student");
		return studentRepository.findStudent();
	}
}
