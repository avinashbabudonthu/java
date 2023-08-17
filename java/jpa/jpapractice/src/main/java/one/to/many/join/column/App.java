package one.to.many.join.column;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class App {

	@Test
	public void persisit() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Musician3 musician31 = new Musician3("jack");
		Musician3 musician32 = new Musician3("jill");

		Set<Musician3> musicians = new HashSet<>();
		musicians.add(musician31);
		musicians.add(musician32);

		CD3 cd3 = new CD3("cd3", musicians);

		entityManager.getTransaction().begin();
		entityManager.persist(cd3);
		entityManager.getTransaction().commit();

		String queryString = "select o from CD3 o";
		Query query = entityManager.createQuery(queryString);
		List<CD3> cds = query.getResultList();
		cds.forEach(System.out::println);
	}
}