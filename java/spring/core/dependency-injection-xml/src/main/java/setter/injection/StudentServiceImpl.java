package setter.injection;

import java.util.List;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentServiceImpl implements StudentService {

	@Setter
	private StudentRepository studentRepository;

	public List<Student> findAllStudents() {
		log.info("find student");
		return studentRepository.findAllStudents();
	}
}
