package com.jpa.queries.practice;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.junit.Test;

import com.jpa.queries.practice.model.Department;
import com.jpa.queries.practice.model.Employee;

@SuppressWarnings("unchecked")
public class JPQLPractice {

	@Test
	public void getAllEmployees() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			// method 1
			System.out.println("---- using Query -------");
			String queryString = "select o from Employee o";
			Query query = entityManager.createQuery(queryString);
			List<Employee> result = query.getResultList();
			result.stream().forEach(System.out::println);

			// method 2
			System.out.println("---- using TypedQuery -------");
			String queryString2 = "select o from Employee o";
			TypedQuery<Employee> query2 = entityManager.createQuery(queryString2, Employee.class);
			List<Employee> result2 = query2.getResultList();
			result2.stream().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getAllDepartments() {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			String queryString = "select o from Department o";
			Query query = entityManager.createQuery(queryString);
			List<Department> departments = query.getResultList();
			departments.stream().forEach(department -> {
				System.out.println(department);
				Set<Employee> employees = department.getEmployees();
				employees.stream().forEach(System.out::println);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void employeesCountInEachDepartment() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select d.deptName, count(e) from Department d left join d.employees e group by d.deptName";
		Query query = entityManager.createQuery(queryString);
		List<Object[]> results = query.getResultList();

		results.stream().forEach(result -> System.out.println(result[0] + " - " + result[1]));
	}

	@Test
	public void getEmployeeWithNameKING() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Employee o where lower(o.name) like 'king'";
		Query query = entityManager.createQuery(queryString);

		List<Employee> employees = query.getResultList();

		employees.stream().forEach(System.out::println);
	}

	@Test
	public void orderEmployeesByName() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("---- ascending order by name --");
		String acendingQuery = "select o from Employee o order by o.name asc";
		Query query = entityManager.createQuery(acendingQuery);
		List<Employee> employees = query.getResultList();
		employees.stream().forEach(System.out::println);

		System.out.println("-- descending order by name --");
		String descQuery = "select o from Employee o order by o.name desc";
		Query query2 = entityManager.createQuery(descQuery);
		List<Employee> employees2 = query2.getResultList();
		employees2.stream().forEach(System.out::println);
	}

	@Test
	public void getEmployeeWithNameKINGPositionalParameters() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Employee o where lower(o.name) like ?1";
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, "king");

		List<Employee> employees = query.getResultList();

		employees.stream().forEach(System.out::println);
	}

	@Test
	public void getEmployeeWithNameKingNamedParameters() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Employee o where lower(o.name) like :empName";
		Query query = entityManager.createQuery(queryString);
		query.setParameter("empName", "king");

		List<Employee> employees = query.getResultList();

		employees.stream().forEach(System.out::println);
	}

	@Test
	public void queryEmployeeByHireDate() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("queries-practice");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String queryString = "select o from Employee o where o.hiredate = :empHireDate";
		TypedQuery<Employee> query = entityManager.createQuery(queryString, Employee.class);
		query.setParameter("empHireDate", new Date(1982, 1, 23), TemporalType.DATE);

		List<Employee> employees = query.getResultList();

		employees.stream().forEach(System.out::println);
	}
}