package com.hibernate.basics;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.basics.model.Student;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings({ "deprecation", "unchecked" })
@Slf4j
public class Read {

	@Test
	public void findAll() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// find all students
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> studentsList = criteria.list();
		studentsList.stream().forEach(student -> log.info("student={}", student));

		// close session
		session.close();
	}

	@Test
	public void get() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// find all students
		Student student = (Student) session.get(Student.class, 1);
		log.info("student={}", student);

		// close session
		session.close();
	}
}
