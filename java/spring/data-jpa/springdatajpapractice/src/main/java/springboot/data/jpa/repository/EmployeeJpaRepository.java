package springboot.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.data.jpa.model.Employee;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository(value = "employeeJpaRepository")
@Transactional
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>, EmployeeJpaRepositoryCustom {

    List<Employee> findByName(String value);

    List<Employee> findByNameIs(String value);

    List<Employee> findByNameEquals(String value);

    List<Employee> findByNameNot(String value);

    // select * from emp where name like 'test'
    List<Employee> findByNameLike(String value);

    List<Employee> findByNameNotLike(String value);

    Long countByName(String value);

    List<Employee> findByNameAndJob(String value1, String value2);

    List<Employee> findByNameOrJob(String value1, String value2);

    List<Employee> findByNameNotAndJob(String value1, String value2);

    // where name like "value%"
    List<Employee> findByNameStartingWith(String value);

    //where name like "%value"
    List<Employee> findByNameEndingWith(String value);

    //where name like "%value%"
    List<Employee> findByNameContaining(String value);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_,
     * employee0_.hiredate as hiredate4_0_, employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_,
     * employee0_.sal as sal8_0_ from emp employee0_ where employee0_.sal<?
     */
    List<Employee> findBySalaryLessThan(Long value);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_,
     * employee0_.hiredate as hiredate4_0_, employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_,
     * employee0_.sal as sal8_0_ from emp employee0_ where employee0_.sal<=?
     */
    List<Employee> findBySalaryLessThanEqual(Long value);

    // where salary > value
    List<Employee> findBySalaryGreaterThan(Long value);

    //where salary >= value
    List<Employee> findBySalaryGreaterThanEqual(Long value);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_,
     * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_
     * from emp employee0_ where employee0_.sal>? and employee0_.sal<?
     */
    List<Employee> findBySalaryGreaterThanAndSalaryLessThan(Long value1, Long value2);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_,
     * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_
     * where employee0_.hiredate<?
     */
    List<Employee> findByHiredateBefore(Date value);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_,
     * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_
     * where employee0_.hiredate>?
     */
    List<Employee> findByHiredateAfter(Date value);

    /**
     * select employee0_.empno as empno1_0_, employee0_.comm as comm2_0_, employee0_.deptno as deptno3_0_, employee0_.hiredate as hiredate4_0_,
     * employee0_.job as job5_0_, employee0_.mgr as mgr6_0_, employee0_.ename as ename7_0_, employee0_.sal as sal8_0_ from emp employee0_
     * where employee0_.hiredate between ? and ?
     */
    List<Employee> findByHiredateBetween(Date startDate, Date endDate);

    /**
     * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_,
     * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_,
     * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.active=1
     */
    List<Employee> findByActiveTrue();

    /**
     * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_,
     * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_,
     * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.active=0
     */
    List<Employee> findByActiveFalse();

    /**
     * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_,
     * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_,
     * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is null
     */
    List<Employee> findByManagerIsNull();

    /**
     * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_,
     * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_,
     * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is not null
     */
    List<Employee> findByManagerIsNotNull();

    /**
     * select employee0_.empno as empno1_0_, employee0_.active as active2_0_, employee0_.comm as comm3_0_, employee0_.deptno as deptno4_0_,
     * employee0_.hiredate as hiredate5_0_, employee0_.job as job6_0_, employee0_.mgr as mgr7_0_, employee0_.ename as ename8_0_,
     * employee0_.sal as sal9_0_ from emp employee0_ where employee0_.mgr is not null
     */
    List<Employee> findByManagerNotNull();

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_
     * from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno
     * where department1_.dname in (?)
     */
    List<Employee> findByDepartmentDeptNameIn(List<String> departments);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_
     * from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno
     * where department1_.dname not in  (?)
     */
    List<Employee> findByDepartmentDeptNameNotIn(List<String> departments);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where upper(employee0_.ename)=upper(?)
     */
    List<Employee> findByNameIgnoreCase(String name);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where upper(employee0_.ename) like upper('name%')
     */
    List<Employee> findByNameStartingWithIgnoreCase(String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.job=? order by employee0_.sal asc
     */
    List<Employee> findByJobOrderBySalaryAsc(String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.job=? order by employee0_.sal desc
     */
    List<Employee> findByJobOrderBySalaryDesc(String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename like ? limit 1
     */
    Employee findFirstByNameLike(String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename like ? limit 5
     */
    List<Employee> findTop5ByNameLike(String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename=?
     */
    @Query("select e from Employee e where e.name = :inputName")
    List<Employee> queryByName(@Param("inputName") String value);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.sal>?
     */
    @Query("from Employee e where e.salary > :sal")
    List<Employee> queryBySalaryGreaterThan(@Param("sal") Long value);

    /**
     * select * from emp where ename = ?
     */
    @Query(value = "select * from emp where ename = :inputName", nativeQuery = true)
    List<Employee> queryBySQLName(@Param("inputName") String value);

    /**
     * update emp set ename=? where ename=?
     */
    @Modifying
    @Query("update Employee e set e.name = :newName where e.name=:oldName")
    int updateByName(@Param("oldName") String value1, @Param("newName") String value2);

    /**
     * Named Query example. Query is defined with NamedQuery annotation on Employee class
     */
    @Query(name = "Employee.namedFindByDeptName")
    List<Employee> namedQueryFindByDeptName(@Param("inputDeptName") String name);

    /**
     * Native SQL Query example. Query is defined with NamedNativeQuery annotation on Employee class
     */
    @Query(name = "Employee.namedNativeFindByName")
    List<Employee> namedNativeQueryByName(@Param("inputName") String name);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_ from emp employee0_ where employee0_.sal>? limit ?
     */
    @Query("from Employee e where e.salary > :sal")
    Page<Employee> queryBySalaryGreaterThanWithPageable(@Param("sal") Long value,
                                                        Pageable pageable);

    /**
     * select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_,
     * employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_,
     * employee0_.sal as sal8_1_
     * from emp employee0_
     * where employee0_.sal>? order by employee0_.ename asc limit ?
     */
    @Query("from Employee e where e.salary > :sal")
    Page<Employee> queryBySalaryGreaterThanWithPageableSort(@Param("sal") Long value,
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
    Employee findTop1ByDepartmentDeptNameOrderByHiredateDescNameAsc(String deptName);
}