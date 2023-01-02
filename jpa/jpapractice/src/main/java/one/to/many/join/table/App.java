package one.to.many.join.table;

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

		Musician4 musician1 = new Musician4("jack");
		Musician4 musician2 = new Musician4("jill");

		Set<Musician4> musicians = new HashSet<>();
		musicians.add(musician1);
		musicians.add(musician2);

		CD4 cd4 = new CD4("cd4", musicians);

		entityManager.getTransaction().begin();
		entityManager.persist(cd4);
		entityManager.getTransaction().commit();

		String queryString = "select o from CD4 o";
		Query query = entityManager.createQuery(queryString);
		List<CD4> cds = query.getResultList();
		cds.stream().forEach(System.out::println);
	}
}