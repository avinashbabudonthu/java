package com.hibernate.basics;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.basics.model.CourseEnum;
import com.hibernate.basics.model.CourseRankEnum;
import com.hibernate.basics.model.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
public class Create {

	@Test
	public void save() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// save student
		Student student = Student.builder().name("jack").courseName(CourseEnum.JAVA).courseRank(CourseRankEnum.ONE)
				.courseStartDate(new Date()).build();
		session.beginTransaction();
		Serializable id = session.save(student);
		log.info("id={}", id);
		session.getTransaction().commit();

		// close the session
		session.close();
	}

	@Test
	public void persist() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// save student
		Student student = Student.builder().name("jack").courseName(CourseEnum.HIBERNATE).courseRank(CourseRankEnum.TWO)
				.courseStartDate(new Date()).build();
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();

		// close the session
		session.close();
	}

	@Test
	public void saveOrUpdate() {
		// create session
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// save student
		Student student = Student.builder().name("jack").courseName(CourseEnum.JAVA).courseRank(CourseRankEnum.ONE)
				.courseStartDate(new Date()).build();
		session.beginTransaction();
		Serializable id = session.save(student);
		log.info("id={}", id);
		session.getTransaction().commit();

		// save or update
		student.setName("jane");
		session.beginTransaction();
		session.saveOrUpdate(student);
		session.getTransaction().commit();

		// close the session
		session.close();
	}
}
