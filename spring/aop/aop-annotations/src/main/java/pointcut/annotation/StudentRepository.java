package pointcut.annotation;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepository {

	public Student7 findStudent() {
		log.info("find student");
		return Student7.builder().id(1L).name("jill").joiningDate(new Date()).build();
	}
}
