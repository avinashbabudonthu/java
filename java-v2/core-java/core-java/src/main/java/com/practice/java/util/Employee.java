package com.practice.java.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements  Comparable<Employee> {

	private Integer id;
	private String name;
	private LocalDate joiningDate;
	private String gender;
	private Long salary;
	private String department;
	private String designation;

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof  Employee){
			Employee that = (Employee) obj;
			return this.name.equals(that.getName()) && this.designation.equals(that.getDesignation());
		}
		return false;
	}

	@Override
	public int compareTo(Employee that) {
		return  this.getDesignation().compareTo(that.getDesignation());
	}

}
