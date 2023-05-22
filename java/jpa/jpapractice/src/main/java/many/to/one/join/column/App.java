package many.to.one.join.column;

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

		CD5 cd = new CD5("cd5_name");
		Musician5 musician1 = new Musician5("jack", cd);
		Musician5 musician2 = new Musician5("jill", cd);

		entityManager.getTransaction().begin();
		entityManager.persist(musician1);
		entityManager.getTransaction().commit();

		entityManager.getTransaction().begin();
		entityManager.persist(musician2);
		entityManager.getTransaction().commit();

		String queryString = "select o from Musician5 o";
		Query query = entityManager.createQuery(queryString);
		List<Musician5> result = query.getResultList();
		result.stream().forEach(System.out::println);
	}
}