package data.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import data.jpa.entity.StudentEntity;
import data.jpa.model.StudentModel;
import data.jpa.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * 	select studentent0_.id as id1_3_, studentent0_.course as course2_3_, studentent0_.joining_date as joining_3_3_, studentent0_.name as name4_3_ from student studentent0_ where studentent0_.id in (? , ?)
	 * delete from student where id=?
	 * delete from student where id=?
	 * 
	 * @param studentIdList
	 * @return
	 */
	@Transactional
	public List<StudentModel> deleteStudentEntityListByIdList(List<Long> studentIdList) {
		List<StudentEntity> studentEntityList = studentRepository.deleteByIdIn(studentIdList);
		studentEntityList = ListUtils.emptyIfNull(studentEntityList);
		List<StudentModel> studentModelList = studentEntityList.stream().map(StudentEntity::buildModel)
				.collect(Collectors.toList());
		return studentModelList;
	}
}
