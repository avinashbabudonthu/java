package booleancolumn.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class App {

	@Test
	public void saveCertificate() {
		Certificate certificate = new Certificate();
		certificate.setName("certificate1");
		certificate.setIsValid(true);

		Certificate certificate2 = new Certificate();
		certificate2.setName("certificate2");
		certificate2.setIsValid(false);

		Certificate certificate3 = new Certificate();
		certificate3.setName("certificate3");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(certificate);
			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			entityManager.persist(certificate2);
			entityManager.getTransaction().commit();

			entityManager.getTransaction().begin();
			entityManager.persist(certificate3);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Test
	public void getAllRecords() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Certificate o";
		TypedQuery<Certificate> query = entityManager.createQuery(queryString, Certificate.class);
		List<Certificate> result = query.getResultList();
		result.stream().forEach(System.out::println);
	}

	@Test
	public void deleteAllRecords() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "delete from Certificate o";
		TypedQuery<Certificate> query = entityManager.createQuery(queryString, Certificate.class);

		try {
			entityManager.getTransaction().begin();
			int result = query.executeUpdate();
			entityManager.getTransaction().commit();
			System.out.println("result: " + result);
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}