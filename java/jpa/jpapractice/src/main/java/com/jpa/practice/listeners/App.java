package com.jpa.practice.listeners;

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
			Student2 student1 = new Student2("", new Date());
			entityManager.getTransaction().begin();
			entityManager.persist(student1);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		try {
			Student2 student2 = new Student2("jim", new Date());
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

		String queryString = "select o from Student2 o";
		TypedQuery<Student2> query = entityManager.createQuery(queryString, Student2.class);
		List<Student2> results = query.getResultList();
		results.stream().forEach(System.out::println);
	}

}