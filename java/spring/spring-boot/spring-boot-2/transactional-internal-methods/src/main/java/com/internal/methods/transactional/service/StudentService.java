package com.internal.methods.transactional.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.methods.transactional.entity.StudentEntity;
import com.internal.methods.transactional.model.StudentModel;
import com.internal.methods.transactional.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<StudentModel> saveAndCommitEachStudentModel() {
		return saveAndCommitEachStudentEntity().stream().map(StudentEntity::buildModel).collect(Collectors.toList());
	}

	/**
	 * Save and Commit Each StudentEntity
	 * 
	 * @return
	 */
	@Transactional
	private List<StudentEntity> saveAndCommitEachStudentEntity() {
		List<StudentEntity> studentEntities = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			StudentEntity studentEntity = StudentEntity.builder().name("name-" + i).course("course-" + i)
					.joiningDate(new Date()).build();
			studentRepository.save(studentEntity);
			studentEntities.add(studentEntity);
		}

		return studentEntities;
	}

	@Transactional
	public List<StudentModel> saveAndCommitAllStudentModels() {
		return saveAndCommitAllStudentEntities().stream().map(StudentEntity::buildModel).collect(Collectors.toList());
	}

	/**
	 * Save and Commit Each StudentEntity
	 * 
	 * @return
	 */

	private List<StudentEntity> saveAndCommitAllStudentEntities() {
		List<StudentEntity> studentEntities = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			StudentEntity studentEntity = StudentEntity.builder().name("name-" + i).course("course-" + i)
					.joiningDate(new Date()).build();
			studentRepository.save(studentEntity);
			studentEntities.add(studentEntity);
		}

		return studentEntities;
	}
}