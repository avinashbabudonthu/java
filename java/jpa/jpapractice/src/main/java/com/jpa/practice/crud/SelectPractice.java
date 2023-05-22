package com.jpa.practice.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.jpa.practice.datatype.mapping.Book;

public class SelectPractice {

	@Test
	public void findById() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// insert book object to DB
		Book book = new Book(1L, "coreJava", "core-java-fundamentals", 2.12, "cjava3143");
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();

		Book book2 = entityManager.find(Book.class, 1L);
		System.out.println(book2);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void findAll() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			String queryString = "select b from Book b";
			Query query = entityManager.createQuery(queryString);
			List<Book> result = query.getResultList();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}