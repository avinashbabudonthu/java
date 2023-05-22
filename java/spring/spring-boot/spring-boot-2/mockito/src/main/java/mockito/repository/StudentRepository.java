package mockito.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mockito.model.Student;
import mockito.utils.Utils;

@Repository
public class StudentRepository {

	@Autowired
	private Utils utils;

	public Student findStudent() {
		return utils.createStudent();
	}
}
