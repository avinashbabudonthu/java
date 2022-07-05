package afterreturn.aspect;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepository {

	public String findStudent() {
		log.info("find student");
		return "jill";
	}
}
