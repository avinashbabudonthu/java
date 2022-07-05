package after.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student3 findStudent() {
		log.info("find student");
		return studentRepository.findStudent();
	}

}