package command.line.runner.repository;

import org.springframework.stereotype.Repository;

import command.line.runner.model.Student;

@Repository
public class StudentRepository {

	public Student findStudent() {
		// Actually to hit DB and get student. For POC we are mocking data
		return Student.builder().id(1).name("jack").build();
	}
}
