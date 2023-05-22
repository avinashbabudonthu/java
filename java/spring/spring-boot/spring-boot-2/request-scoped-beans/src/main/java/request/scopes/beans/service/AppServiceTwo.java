package request.scopes.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import request.scopes.beans.model.Student;

@Service
public class AppServiceTwo {

	@Autowired
	private Student student;

	public Student setName() {
		student.setName("jack-" + student.getId());
		return student;
	}
}