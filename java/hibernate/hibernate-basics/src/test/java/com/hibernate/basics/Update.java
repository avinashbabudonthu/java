package com.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.basics.model.CourseEnum;
import com.hibernate.basics.model.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Update {

	@SuppressWarnings("deprecation")
	@Test
	public void update() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// find all students
		Student student = (Student) session.get(Student.class, 2);
		log.info("student={}", student);

		student.setCourseName(CourseEnum.HIBERNATE);
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();

		// close session
		session.close();
	}
}
