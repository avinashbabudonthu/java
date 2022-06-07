package springboot.mysql.docker.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mysql.docker.entity.StudentEntity;
import springboot.mysql.docker.model.StudentModel;
import springboot.mysql.docker.repository.StudentRepository;

@RestController
public class AppController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping(value = "/students", produces = APPLICATION_JSON_VALUE)
	public List<StudentModel> findAllStudents() {
		List<StudentEntity> studentEntityList = studentRepository.findAll();
		List<StudentModel> studentModelList = studentEntityList.stream().map(StudentEntity::buildModel)
				.collect(Collectors.toList());
		return studentModelList;
	}

}