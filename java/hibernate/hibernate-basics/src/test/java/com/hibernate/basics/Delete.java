package com.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.basics.model.Student;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({ "deprecation" })
@Slf4j
public class Delete {

	@Test
	public void delete() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// find all students
		Student student = (Student) session.get(Student.class, 1);
		log.info("student={}", student);

		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();

		// close session
		session.close();
	}
}
