package com.jpa.queries.practice.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DEPT")
public class Department {
	private Integer id;
	private String deptName;
	private String location;
	private Set<Employee> employees;

	public Department(Integer id, String deptName, String location, Set<Employee> employees) {
		this.id = id;
		this.deptName = deptName;
		this.location = location;
		this.employees = employees;
	}

	public Department() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_sequence")
	@SequenceGenerator(name = "dept_sequence", sequenceName = "DEPT_SEQ")
	@Column(name = "DEPTNO")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "DNAME")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "LOC")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", location=" + location + "]";
	}
}