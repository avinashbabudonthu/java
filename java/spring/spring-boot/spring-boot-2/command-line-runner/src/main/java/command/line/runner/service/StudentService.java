package command.line.runner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.line.runner.model.Student;
import command.line.runner.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student findStudent() {
		return studentRepository.findStudent();
	}
}