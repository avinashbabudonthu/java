package before.aspect;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepository {

	public Student findStudent() {
		log.info("find student");
		return Student.builder().id(1L).name("jill").joiningDate(new Date()).build();
	}
}
