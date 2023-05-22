package one.to.one.join.column;

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

		Musician1 musician = new Musician1("jack");
		CD1 cd = new CD1("jack-cd", musician);
		entityManager.getTransaction().begin();
		entityManager.persist(cd);
		entityManager.getTransaction().commit();

		String queryString = "select o from CD1 o";
		Query query = entityManager.createQuery(queryString);
		List<CD1> result = query.getResultList();
		System.out.println(result);
	}
}