package com.jpa.queries.practice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMP")
public class Employee {

	private Integer id;
	private String name;
	private String job;
	private Long salary;
	private Long comm;
	private Integer manager;
	private Date hiredate;
	private Boolean active;
	private Department department;

	public Employee() {
	}

	public Employee(String name, String job, Long salary, Long comm, Integer manager, Date hiredate) {
		this.name = name;
		this.job = job;
		this.salary = salary;
		this.comm = comm;
		this.manager = manager;
		this.hiredate = hiredate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee-sequence")
	@SequenceGenerator(name = "employee-sequence", sequenceName = "EMP_SEQ")
	@Column(name = "EMPNO")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ENAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "JOB")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "SAL")
	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Column(name = "COMM")
	public Long getComm() {
		return comm;
	}

	public void setComm(Long comm) {
		this.comm = comm;
	}

	@Column(name = "MGR")
	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HIREDATE")
	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@ManyToOne
	@JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + ", comm=" + comm + ", manager="
				+ manager + ", hiredate=" + hiredate + ", active=" + active + "]";
	}
}