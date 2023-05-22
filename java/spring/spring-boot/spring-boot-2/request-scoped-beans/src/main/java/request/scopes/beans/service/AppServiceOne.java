package request.scopes.beans.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import request.scopes.beans.model.Student;

@Service
public class AppServiceOne {

	@Autowired
	private Student student;

	public void setId() {
		student.setId(new Random().nextLong());
	}
}