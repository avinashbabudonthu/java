package one.to.one.join.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class App {

	@Test
	public void persist() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Musician2 musician = new Musician2("jack");
		CD2 cd = new CD2("jack-cd", musician);
		entityManager.getTransaction().begin();
		entityManager.persist(cd);
		entityManager.getTransaction().commit();

		String queryString = "select o from CD2 o";
		Query query = entityManager.createQuery(queryString);
		List<CD2> result = query.getResultList();
		System.out.println(result);
	}
}