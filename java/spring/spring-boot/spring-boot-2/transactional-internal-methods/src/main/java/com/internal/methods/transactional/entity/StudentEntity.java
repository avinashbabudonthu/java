package com.internal.methods.transactional.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.internal.methods.transactional.model.StudentModel;

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
@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@GenericGenerator(name = "custom-primary-key-generator", strategy = "com.internal.methods.transactional.util.PrimaryKeyGenerator")
	@GeneratedValue(generator = "custom-primary-key-generator")
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "course")
	private String course;

	@Column(name = "joining_date")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	public StudentModel buildModel() {
		log.info("Building StudentModel");
		return StudentModel.builder().id(id).name(name).course(course).joiningDate(joiningDate).build();
	}

}
