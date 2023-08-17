package many.to.many.join.table;

import one.to.many.join.column.CD3;
import one.to.many.join.column.Musician3;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class App {

	@Test
	public void persisit() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student3 student1 = Student3.builder()
				.name("student1")
				.build();
		Student3 student2 = Student3.builder()
				.name("student2")
				.build();

		Course3 course1 = Course3.builder()
				.name("course1")
				.build();

		Course3 course2 = Course3.builder()
				.name("course2")
				.build();

		List<Student3> student3List = new ArrayList<>();
		student3List.add(student1);
		student3List.add(student2);

		List<Course3> course3List = new ArrayList<>();
		course3List.add(course1);
		course3List.add(course2);

		student1.setCourses(course3List);
		student2.setCourses(course3List);

		course1.setStudents(student3List);
		course2.setStudents(student3List);

		entityManager.getTransaction().begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.getTransaction().commit();

		String queryString = "select o from Student3 o";
		Query query = entityManager.createQuery(queryString);
		List<CD3> cds = query.getResultList();
		cds.forEach(System.out::println);
	}
}