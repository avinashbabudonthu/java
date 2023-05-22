package com.jpa.practice.callback.annotations;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class App {

	@Test
	public void persist() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			Student student1 = new Student("", new Date());
			entityManager.getTransaction().begin();
			entityManager.persist(student1);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		try {
			Student student2 = new Student("jim", new Date());
			entityManager.getTransaction().begin();
			entityManager.persist(student2);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Test
	public void findAllStudents() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Student o";
		TypedQuery<Student> query = entityManager.createQuery(queryString, Student.class);
		List<Student> results = query.getResultList();
		results.stream().forEach(System.out::println);
	}

}