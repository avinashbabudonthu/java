package com.spring.boot2.war.tomcat9.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMP")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPNO")
	private Integer id;

	@Column(name = "ENAME")
	private String name;

	@Column(name = "JOB")
	private String job;

	@Column(name = "SAL")
	private Long salary;

	@Column(name = "COMM")
	private Long comm;

	@Column(name = "MGR")
	private Integer manager;

	@Column(name = "HIREDATE")
	private Date hiredate;

	@Column(name = "ACTIVE")
	private Boolean active;
}
