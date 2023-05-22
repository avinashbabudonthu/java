package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.app.model.EmployeeModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMP")
public class Employee {

	@Id
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

	@SneakyThrows
	public EmployeeModel buildModel() {
		EmployeeModel employeeModel = new EmployeeModel();
		BeanUtils.copyProperties(employeeModel, this);
		return employeeModel;
	}
}