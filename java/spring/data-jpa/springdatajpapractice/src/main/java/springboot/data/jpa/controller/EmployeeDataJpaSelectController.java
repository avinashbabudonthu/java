package springboot.data.jpa.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import springboot.data.jpa.model.Employee;
import springboot.data.jpa.repository.EmployeeJpaRepository;

@RestController
public class EmployeeDataJpaSelectController {

	@Autowired
	@Qualifier("employeeJpaRepository")
	private EmployeeJpaRepository employeeJpaRepository;

	@Autowired
	@Qualifier("objectMapper")
	private ObjectMapper objectMapper;

	/**
	 * Url: http://localhost:8080/findOne
	 * 
	 * Query:
	 * Hibernate: select employee0_.empno as empno1_1_0_, employee0_.active as active2_1_0_, employee0_.comm as comm3_1_0_, employee0_.deptno as deptno9_1_0_, employee0_.hiredate as hiredate4_1_0_, employee0_.job as job5_1_0_, employee0_.mgr as mgr6_1_0_, employee0_.ename as ename7_1_0_, employee0_.sal as sal8_1_0_, department1_.deptno as deptno1_0_1_, department1_.dname as dname2_0_1_, department1_.loc as loc3_0_1_ from emp employee0_ left outer join dept department1_ on employee0_.deptno=department1_.deptno where employee0_.empno=?
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/findOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String findOne() throws JsonProcessingException {
		Employee employee = employeeJpaRepository.findOne(7839);
		return objectMapper.writeValueAsString(employee);
	}

	/**
	 * Url:
	 * http://localhost:8080/findAll
	 * 
	 * Queries:
	 * Hibernate: select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, employee0_.sal as sal8_1_ from emp employee0_
	 * Hibernate: select department0_.deptno as deptno1_0_0_, department0_.dname as dname2_0_0_, department0_.loc as loc3_0_0_ from dept department0_ where department0_.deptno=?
	 * Hibernate: select department0_.deptno as deptno1_0_0_, department0_.dname as dname2_0_0_, department0_.loc as loc3_0_0_ from dept department0_ where department0_.deptno=?
	 * Hibernate: select department0_.deptno as deptno1_0_0_, department0_.dname as dname2_0_0_, department0_.loc as loc3_0_0_ from dept department0_ where department0_.deptno=?
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findAll() {
		List<Employee> employeeList = employeeJpaRepository.findAll();
		return employeeList;
	}

	/**
	 * Url:
	 * http://localhost:8080/findByName/BLAKE
	 * 
	 * Query:
	 * Hibernate: select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename=?
	 * Hibernate: select department0_.deptno as deptno1_0_0_, department0_.dname as dname2_0_0_, department0_.loc as loc3_0_0_ from dept department0_ where department0_.deptno=?
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> find(@PathVariable("name") String name) {
		return employeeJpaRepository.findByName(name);
	}

	/**
	 * Url:
	 * http://localhost:8080/findByNameLike?name=KING
	 * 
	 * Query:
	 * Hibernate: select employee0_.empno as empno1_1_, employee0_.active as active2_1_, employee0_.comm as comm3_1_, employee0_.deptno as deptno9_1_, employee0_.hiredate as hiredate4_1_, employee0_.job as job5_1_, employee0_.mgr as mgr6_1_, employee0_.ename as ename7_1_, employee0_.sal as sal8_1_ from emp employee0_ where employee0_.ename like ?
	 * Hibernate: select department0_.deptno as deptno1_0_0_, department0_.dname as dname2_0_0_, department0_.loc as loc3_0_0_ from dept department0_ where department0_.deptno=?
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/findByNameLike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameLike(@RequestParam("name") String name) {
		return employeeJpaRepository.findByNameLike(name + "%");
	}

	@RequestMapping(value = "/countByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String countByName(@PathVariable("name") String name) {
		return "No.of Records: " + employeeJpaRepository.countByName(name);
	}

	@RequestMapping(value = "/findByNameAndJob", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameAndJob(@RequestParam("name") String name,
			@RequestParam("job") String job) {
		return employeeJpaRepository.findByNameAndJob(name, job);
	}

	@RequestMapping(value = "/findByNameOrJob", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameOrJob(@RequestParam("name") String name,
			@RequestParam("job") String job) {
		return employeeJpaRepository.findByNameOrJob(name, job);
	}

	@RequestMapping(value = "/findByNameIs/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameIs(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameIs(name);
	}

	@RequestMapping(value = "/findByNameEquals/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameEquals(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameEquals(name);
	}

	@RequestMapping(value = "/findByNameNot/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameNot(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameNot(name);
	}

	@RequestMapping(value = "/findByNameNotAndJob", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameNotAndJob(@RequestParam("name") String name,
			@RequestParam("job") String job) {
		return employeeJpaRepository.findByNameNotAndJob(name, job);
	}

	@RequestMapping(value = "/findByNameNotLike/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameNotLike(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameNotLike(name + "%");
	}

	@RequestMapping(value = "/findByNameStartingWith/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameStartingWith(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameStartingWith(name);
	}

	@RequestMapping(value = "/findByNameEndingWith/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameEndingWith(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameEndingWith(name);
	}

	@RequestMapping(value = "/findByNameContaining/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findByNameContaining(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameContaining(name);
	}

	@RequestMapping(value = "/findBySalaryLessThan/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findBySalaryLessThan(@PathVariable("salary") Long salary) {
		return employeeJpaRepository.findBySalaryLessThan(salary);
	}

	@RequestMapping(value = "/findBySalaryLessThanEqual/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findBySalaryLessThanEqual(@PathVariable("salary") Long salary) {
		return employeeJpaRepository.findBySalaryLessThanEqual(salary);
	}

	@RequestMapping(value = "/findBySalaryGreaterThan/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findBySalaryGreaterThan(@PathVariable("salary") Long salary) {
		return employeeJpaRepository.findBySalaryGreaterThan(salary);
	}

	@RequestMapping(value = "/findBySalaryGreaterThanEqual/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findBySalaryGreaterThanEqual(@PathVariable("salary") Long salary) {
		return employeeJpaRepository.findBySalaryGreaterThanEqual(salary);
	}

	@RequestMapping(value = "/findBySalaryGreterThanAndSalaryLessThan/{salary1}/{salary2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findBySalaryGreterThanAndSalaryLessThan(
			@PathVariable("salary1") Long value1, @PathVariable("salary2") Long value2) {
		return employeeJpaRepository.findBySalaryGreaterThanAndSalaryLessThan(value1, value2);
	}

	@RequestMapping(value = "/findByHiredateBefore/{year}/{month}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByHiredateBefore(@PathVariable("year") int year,
			@PathVariable("month") int month, @PathVariable("date") int dayOfMonth) {
		Date date = Date
				.from(LocalDate.of(year, month, dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
		return employeeJpaRepository.findByHiredateBefore(date);
	}

	@RequestMapping(value = "/findByHiredateAfter/{year}/{month}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByHiredateAfter(@PathVariable("year") int year,
			@PathVariable("month") int month, @PathVariable("date") int dayOfMonth) {
		Date date = Date
				.from(LocalDate.of(year, month, dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
		return employeeJpaRepository.findByHiredateAfter(date);
	}

	@RequestMapping(value = "/findByHiredateBetween/{year}/{month}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByHiredateBetween(@PathVariable("year") int year,
			@PathVariable("month") int month, @PathVariable("date") int dayOfMonth) {
		Date startDate = Date
				.from(LocalDate.of(year, month, dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		return employeeJpaRepository.findByHiredateBetween(startDate, endDate);
	}

	@RequestMapping(value = "/findByActiveTrue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByActiveTrue() {
		return employeeJpaRepository.findByActiveTrue();
	}

	@RequestMapping(value = "/findByActiveFalse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByActiveFalse() {
		return employeeJpaRepository.findByActiveFalse();
	}

	@RequestMapping(value = "/findByManagerIsNull", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByManagerIsNull() {
		return employeeJpaRepository.findByManagerIsNull();
	}

	@RequestMapping(value = "/findByManagerIsNotNull", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByManagerIsNotNull() {
		return employeeJpaRepository.findByManagerIsNotNull();
	}

	@RequestMapping(value = "/findByManagerNotNull", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByManagerNotNull() {
		return employeeJpaRepository.findByManagerNotNull();
	}

	@RequestMapping(value = "/findByDepartmentDeptNameIn/{deptName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByDepartmentDeptNameIn(@PathVariable("deptName") String deptName) {
		return employeeJpaRepository.findByDepartmentDeptNameIn(Arrays.asList(deptName));
	}

	@RequestMapping(value = "/findByDepartmentDeptNameNotIn/{deptName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByDepartmentDeptNameNotIn(@PathVariable("deptName") String deptName) {
		return employeeJpaRepository.findByDepartmentDeptNameNotIn(Arrays.asList(deptName));
	}

	@RequestMapping(value = "/findByNameIgnoreCase/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByNameIgnoreCase(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameIgnoreCase(name);
	}

	@RequestMapping(value = "/findByNameStartingWithIgnoreCase/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByNameStartingWithIgnoreCase(@PathVariable("name") String name) {
		return employeeJpaRepository.findByNameStartingWithIgnoreCase(name);
	}

	@RequestMapping(value = "/findByJobOrderBySalaryAsc/{job}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByJobOrderBySalaryAsc(@PathVariable("job") String job) {
		return employeeJpaRepository.findByJobOrderBySalaryAsc(job);
	}

	@RequestMapping(value = "/findByJobOrderBySalaryDesc/{job}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByJobOrderBySalaryDesc(@PathVariable("job") String job) {
		return employeeJpaRepository.findByJobOrderBySalaryDesc(job);
	}

	@RequestMapping(value = "/findFirstByNameLike/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee findFirstByNameLike(@PathVariable("name") String name) {
		return employeeJpaRepository.findFirstByNameLike(name + "%");
	}

	@RequestMapping(value = "/findTop5ByNameLike/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> findTop5ByNameLike(@PathVariable("name") String name) {
		return employeeJpaRepository.findTop5ByNameLike(name + "%");
	}

	@RequestMapping(value = "/queryByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> queryByName(@PathVariable("name") String name) {
		return employeeJpaRepository.queryByName(name);
	}

	@RequestMapping(value = "/queryBySalaryGreaterThan/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> queryBySalaryGreaterThan(@PathVariable("salary") Long salary) {
		return employeeJpaRepository.queryBySalaryGreaterThan(salary);
	}

	@RequestMapping(value = "/queryBySQLName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> queryBySQLName(@PathVariable("name") String name) {
		return employeeJpaRepository.queryBySQLName(name);
	}

	@RequestMapping(value = "/namedQueryFindByDeptName/{deptName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> namedQueryFindByDeptName(@PathVariable("deptName") String deptName) {
		return employeeJpaRepository.namedQueryFindByDeptName(deptName);
	}

	@RequestMapping(value = "/namedNativeQueryByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Employee> namedNativeQueryByName(@PathVariable("name") String name) {
		return employeeJpaRepository.namedNativeQueryByName(name);
	}

	@RequestMapping(value = "/queryBySalaryGreaterThanWithPageable/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Employee> queryBySalaryGreaterThanWithPageable(@PathVariable("salary") Long salary) {
		Pageable pageable = new PageRequest(0, 3);
		Page<Employee> employees = employeeJpaRepository.queryBySalaryGreaterThanWithPageable(salary,
				pageable);

		System.out.println(
				"EmployeeDataJpaSelectController.queryBySalaryGreaterThanWithPageable -> employees.getTotalElements(): "
						+ employees.getTotalElements());
		System.out.println(
				"EmployeeDataJpaSelectController.queryBySalaryGreaterThanWithPageable -> employees.getSize(): "
						+ employees.getSize());
		System.out.println(
				"EmployeeDataJpaSelectController.queryBySalaryGreaterThanWithPageable -> employees.getTotalPages(): "
						+ employees.getTotalPages());

		return employees;
	}

	@RequestMapping(value = "/queryBySalaryGreaterThanWithPageableSort/{salary}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Employee> queryBySalaryGreaterThanWithPageableSort(@PathVariable("salary") Long salary) {
		Sort sort = new Sort(Sort.Direction.ASC, "name");
		/*Sort sort = new Sort(Sort.Direction.DESC, "name");*/
		Pageable pageable = new PageRequest(0, 3, sort);
		Page<Employee> employees = employeeJpaRepository.queryBySalaryGreaterThanWithPageableSort(salary,
				pageable);
		return employees;
	}

	@RequestMapping(value = "/customMethod", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String cutomMethod() {
		return employeeJpaRepository.cutomMethod();
	}

	@GetMapping(value = "/findByDeptNameOrderByHireDateAndName", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Employee findTop1ByDeptNameOrderByHireDateDescNameAsc(
			@RequestParam("deptName") String deptName) {
		return employeeJpaRepository.findTop1ByDepartmentDeptNameOrderByHiredateDescNameAsc(deptName);
	}

}