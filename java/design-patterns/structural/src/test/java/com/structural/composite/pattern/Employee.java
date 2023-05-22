package com.structural.composite.pattern;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String dept;
	private List<Employee> reportees;

	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
		this.reportees = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Employee> getReportees() {
		return reportees;
	}

	public void setReportees(List<Employee> reportees) {
		this.reportees = reportees;
	}

	public void addReportee(Employee employee) {
		reportees.add(employee);
	}

	@Override
	public String toString() {
		return "Employee{name=" + name + ", dept=" + dept + "}";
	}

}