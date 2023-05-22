package com.jpa.practice.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class AgeCalculateListener {

	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge(Object object) {
		Student2 student = (Student2) object;
		System.out.println(AgeCalculateListener.class.getName() + ".calculateAge()");
		student.setAge(21);
	}

}