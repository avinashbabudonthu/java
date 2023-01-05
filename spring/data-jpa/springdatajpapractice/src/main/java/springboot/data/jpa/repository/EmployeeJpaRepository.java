package springboot.data.jpa.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.data.jpa.model.Employee;

@Repository(value = "employeeJpaRepository")
@Transactional
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>, EmployeeJpaRepositoryCustom {

	public abstract List<Employee> findByName(String value);

	public abstract List<Employee> findByNameIs(String value);

	public abstract List<Employee> findByNameEquals(String value);

	public abstract List<Employee> findByNameNot(String value);

	// select * from emp where where name like 'test'
	public abstract List<Employee> findByNameLike(String value);

	public abstract List<Employee> findByNameNotLike(String value);

	public abstract Long countByName(String value);

	public abstract List<Employee> findByNameAndJob(String value1, String value2);

	public abstract List<Employee> findByNameOrJob(String value1, String value2);

	public abstract List<Employee> findByNameNotAndJob(String value1, String value2);

	// where name like "value%"
	public abstract List<Employee> findByNameStartingWith(String value);

	//where name like "%value"
	public abstract List<Employee> findByNameEndingWith(String value);

	//where name like "%value%"
	public abstract List<Employee> findByNameContaining(String value);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, 
	 * employee0_.hiredate as hiredate4_0_, employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, 
	 * employee0_.sal as sal8_0_ from emp employee0_ where employee0_.sal<?
	 */
	public abstract List<Employee> findBySalaryLessThan(Long value);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, 
	 * employee0_.hiredate as hiredate4_0_, employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, 
	 * employee0_.sal as sal8_0_ from emp employee0_ where employee0_.sal<=?
	 */
	public abstract List<Employee> findBySalaryLessThanEqual(Long value);

	// where salary > value
	public abstract List<Employee> findBySalaryGreaterThan(Long value);

	//where salary >= value
	public abstract List<Employee> findBySalaryGreaterThanEqual(Long value);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_, 
	 * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ 
	 * from emp employee0_ where employee0_.sal>? and employee0_.sal<?
	 */
	public abstract List<Employee> findBySalaryGreaterThanAndSalaryLessThan(Long value1, Long value2);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_, 
	 * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_ 
	 * where employee0_.hiredate<?
	 */
	public abstract List<Employee> findByHiredateBefore(Date value);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_, 
	 * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_ 
	 * where employee0_.hiredate>?
	 */
	public abstract List<Employee> findByHiredateAfter(Date value);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_, 
	 * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_ 
	 * where employee0_.hiredate between ? and ?
	 */
	public abstract List<Employee> findByHiredateBetween(Date startDate, Date endDate);

	/**
	 * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_, 
	 * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_, 
	 * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.active=1
	 */
	public abstract List<Employee> findByActiveTrue();

	/**
	 * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_, 
	 * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_, 
	 * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.active=0
	 */
	public abstract List<Employee> findByActiveFalse();

	/**
	 * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_, 
	 * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_, 
	 * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is null
	 */
	public abstract List<Employee> findByManagerIsNull();

	/**
	 * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_, 
	 * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_, 
	 * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is not null
	 */
	public abstract List<Employee> findByManagerIsNotNull();

	/**
	 * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_, 
	 * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_, 
	 * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is not null
	 */
	public abstract List<Employee> findByManagerNotNull();

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ 
	 * from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno 
	 * where department1_.dname in (?)
	 */
	public abstract List<Employee> findByDepartmentDeptNameIn(List<String> departments);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ 
	 * from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno 
	 * where department1_.dname not in  (?)
	 */
	public abstract List<Employee> findByDepartmentDeptNameNotIn(List<String> departments);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where upper(employee0_.ename)=upper(?)
	 */
	public abstract List<Employee> findByNameIgnoreCase(String name);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where upper(employee0_.ename) like upper('name%')
	 */
	public abstract List<Employee> findByNameStartingWithIgnoreCase(String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.job=? order by employee0_.sal asc
	 */
	public abstract List<Employee> findByJobOrderBySalaryAsc(String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.job=? order by employee0_.sal desc
	 */
	public abstract List<Employee> findByJobOrderBySalaryDesc(String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename like ? limit 1
	 */
	public abstract Employee findFirstByNameLike(String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename like ? limit 5
	 */
	public abstract List<Employee> findTop5ByNameLike(String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename=?
	 */
	@Query("select e from Employee e where e.name = :inputName")
	public abstract List<Employee> queryByName(@Param("inputName") String value);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.sal>?
	 */
	@Query("from Employee e where e.salary > :sal")
	public abstract List<Employee> queryBySalaryGreaterThan(@Param("sal") Long value);

	/**
	 * select * from emp where ename = ?
	 */
	@Query(value = "select * from emp where ename = :inputName", nativeQuery = true)
	public abstract List<Employee> queryBySQLName(@Param("inputName") String value);

	/**
	 * update emp set ename=? where ename=?
	 */
	@Modifying
	@Query("update Employee e set e.name = :newName where e.name=:oldName")
	public abstract int updateByName(@Param("oldName") String value1, @Param("newName") String value2);

	/**
	 * Named Query example. Query is defined with NamedQuery annotation on Employee class
	 */
	@Query(name = "Employee.namedFindByDeptName")
	public abstract List<Employee> namedQueryFindByDeptName(@Param("inputDeptName") String name);

	/**
	 * Native SQL Query example. Query is defined with NamedNativeQuery annotation on Employee class
	 */
	@Query(name = "Employee.namedNativeFindByName")
	public abstract List<Employee> namedNativeQueryByName(@Param("inputName") String name);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.sal>? limit ?
	 */
	@Query("from Employee e where e.salary > :sal")
	public abstract Page<Employee> queryBySalaryGreaterThanWithPageable(@Param("sal") Long value,
			Pageable pageable);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, 
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ 
	 * from emp employee0_ 
	 * where employee0_.sal>? order by employee0_.ename asc limit ?
	 */
	@Query("from Employee e where e.salary > :sal")
	public abstract Page<Employee> queryBySalaryGreaterThanWithPageableSort(@Param("sal") Long value,
			Pageable pageable);

	/**
	 * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
	 * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, 
	 * employee0_.sal as sal8_1_ 
	 * from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno 
	 * where department1_.dname=? order by employee0_.hiredate desc, employee0_.ename asc limit ?
	 * 
	 * @param deptName
	 * @return
	 */
	public abstract Employee findTop1ByDepartmentDeptNameOrderByHiredateDescNameAsc(String deptName);
}