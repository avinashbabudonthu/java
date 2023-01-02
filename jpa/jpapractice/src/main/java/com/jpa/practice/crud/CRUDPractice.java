package com.jpa.practice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.practice.datatype.mapping.Book;

public class CRUDPractice {

	public static void main(String[] args) {
		CRUDPractice crudPractice = new CRUDPractice();

		crudPractice.createBook();
		System.out.println("Book Created");

		Book book = crudPractice.readBook();
		System.out.println("Book: " + book);

		crudPractice.updateBook();
		Book book2 = crudPractice.readBook();
		System.out.println("Updated Book: " + book2);

		crudPractice.deleteBook();
		Book book3 = crudPractice.readBook();
		System.out.println("Book after deleting: " + book3);
	}

	public void createBook() {
		Book book = new Book(1L, "java", "java-fundamentals", 1.23, "java1234");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	}

	public Book readBook() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Book book = entityManager.find(Book.class, 1L);
		return book;
	}

	public void updateBook() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Book book = entityManager.find(Book.class, 1L);

		if (null != book) {
			entityManager.getTransaction().begin();
			book.setUnitCost(1.12);
			entityManager.getTransaction().commit();
		}
	}

	public void deleteBook() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Book book = entityManager.find(Book.class, 1L);

		entityManager.getTransaction().begin();
		entityManager.remove(book);
		entityManager.getTransaction().commit();
	}
}