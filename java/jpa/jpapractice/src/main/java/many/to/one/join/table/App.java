package many.to.one.join.table;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class App {

	@Test
	public void persist() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CD6 cd = new CD6("cd6_name");
		Musician6 musician1 = new Musician6("jack", cd);
		Musician6 musician2 = new Musician6("jill", cd);

		entityManager.getTransaction().begin();
		entityManager.persist(musician1);
		entityManager.getTransaction().commit();

		entityManager.getTransaction().begin();
		entityManager.persist(musician2);
		entityManager.getTransaction().commit();

		String queryString = "select o from Musician6 o";
		Query query = entityManager.createQuery(queryString);
		List<Musician6> result = query.getResultList();
		result.stream().forEach(System.out::println);
	}
}