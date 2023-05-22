package dependency.injection.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	/**
	 * @see dependency.injection.setter.StudentService#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return studentRepository.findStudent();
	}
}
