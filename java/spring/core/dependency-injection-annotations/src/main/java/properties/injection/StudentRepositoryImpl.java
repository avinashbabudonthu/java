package properties.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Value("${student.id}")
	private String id;

	@Value("${student.name}")
	private String name;

	/**
	 * @see properties.injection.StudentRepository#findStudent()
	 */
	@Override
	public Student findStudent() {
		log.info("find student");
		return Student.builder().id(Long.parseLong(id)).name(name).build();
	}
}
