package around.aspect;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepository {

	public Student5 findStudent() {
		log.info("find student");
		return Student5.builder().id(1L).name("jill").joiningDate(new Date()).build();
	}
}
