package com.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

	private String name;
	private Double grade;

	// sorted order of grade
	@Override
	public int compareTo(Student that) {
		return this.grade.compareTo(that.getGrade());
	}

	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object that) {
		if (null == that) {
			return false;
		}

		Student thatStudent = (Student) that;

		return this.name.equalsIgnoreCase(thatStudent.getName());
	}

}