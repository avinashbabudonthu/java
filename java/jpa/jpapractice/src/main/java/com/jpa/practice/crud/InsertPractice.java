package com.jpa.practice.crud;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.jpa.practice.datatype.mapping.Book;
import com.jpa.practice.datatype.mapping.DateMapping;
import com.jpa.practice.datatype.mapping.DaysEnum;
import com.jpa.practice.datatype.mapping.EnumMapping;

@SuppressWarnings("unchecked")
public class InsertPractice {

	@Test
	public void insert() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			Book book = new Book(1L, "jpa", "jpa fundamentals", 1.23, "1234agrts");

			entityManager.getTransaction().begin();
			entityManager.persist(book);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void persistEntityWithDateFields() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		DateMapping entityWithDateMapping = new DateMapping("jack", new Date(), new Date(), new Date());

		entityManager.getTransaction().begin();
		entityManager.persist(entityWithDateMapping);
		entityManager.getTransaction().commit();

		String queryString = "select o from DateMapping o";
		Query query = entityManager.createQuery(queryString);
		List<DateMapping> result = query.getResultList();
		result.stream().forEach(System.out::println);
	}

	@Test
	public void persistEntityWithEnum() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EnumMapping enumMapping = new EnumMapping(DaysEnum.Saturday, DaysEnum.Saturday);
		entityManager.getTransaction().begin();
		entityManager.persist(enumMapping);
		entityManager.getTransaction().commit();

		String queryString = "select o from EnumMapping o";
		Query query = entityManager.createQuery(queryString);
		List<EnumMapping> result = query.getResultList();
		result.stream().forEach(System.out::println);
	}
}