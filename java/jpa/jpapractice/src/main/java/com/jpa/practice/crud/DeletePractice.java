package com.jpa.practice.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.jpa.practice.datatype.mapping.Book;

public class DeletePractice {

	@SuppressWarnings("unchecked")
	@Test
	public void deleteAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// get all books
		String queryString = "select b from Book b";
		Query query = entityManager.createQuery(queryString);
		List<Book> allBooks = query.getResultList();

		entityManager.getTransaction().begin();
		for (Book book : allBooks) {
			entityManager.remove(book);
		}
		entityManager.getTransaction().commit();
	}
}