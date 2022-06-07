package com.internal.methods.transactional.model;

import java.util.Date;

import com.internal.methods.transactional.entity.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {

	private String id;
	private String name;
	private String course;
	private Date joiningDate;

	public StudentEntity buildEntity() {
		log.info("Building StudentEntity");
		return StudentEntity.builder().id(id).name(name).course(course).joiningDate(joiningDate).build();
	}
}
