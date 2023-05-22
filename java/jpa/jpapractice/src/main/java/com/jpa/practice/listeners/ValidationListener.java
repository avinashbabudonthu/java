package com.jpa.practice.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ValidationListener {

	@PrePersist
	@PreUpdate
	public void validate(Object object) {
		Student2 student = (Student2) object;
		System.out.println(ValidationListener.class.getName() + ".validate()");
		if (null == student.getName() || student.getName().isEmpty()) {
			throw new RuntimeException("Illegal Name");
		}
	}
}