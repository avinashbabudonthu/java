package after.throwing;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepository {

	public Student4 findStudent() {
		log.info("find student");

		if (true) {
			throw new RuntimeException("exception from StudentRepository");
		}

		return Student4.builder().id(1L).name("jill").joiningDate(new Date()).build();
	}
}
