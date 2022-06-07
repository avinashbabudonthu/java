package data.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import data.jpa.custom.repository.CustomEmployeeRespository;
import data.jpa.entity.EmployeeDepartmentEntity;
import data.jpa.entity.EmployeeEntity;
import data.jpa.model.EmployeeModel;
import data.jpa.model.ResponseModel;
import data.jpa.repository.EmployeeEntityRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

	@Autowired
	private CustomEmployeeRespository customEmployeeRepository;

	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;

	public List<EmployeeEntity> findAllEmployeesList() {
		List<EmployeeEntity> employeesList = customEmployeeRepository.findAllEmployees();

		return employeesList;
	}

	public List<EmployeeEntity> findAllEmployeesByDeptId(Integer deptId) {
		List<EmployeeEntity> employeesList = customEmployeeRepository.findAllEmployeesByDeptId(deptId);
		return employeesList;
	}

	public List<EmployeeDepartmentEntity> findEmployeeAndDept() {
		List<EmployeeDepartmentEntity> result = employeeEntityRepository.findEmployeeAndDept();

		result.stream().forEach(empDept -> {
			log.info("empno={}, ename={}, deptno={}, dname={}, loc={}, job={}, sal={}", empDept.getEmpno(),
					empDept.getEname(), empDept.getDeptno(), empDept.getDname(), empDept.getLoc(), empDept.getJob(),
					empDept.getSal());
		});
		return result;
	}

	/**
	 * select employeeen0_.empno as empno1_1_, employeeen0_.active as active2_1_, employeeen0_.comm as comm3_1_, 
	 * employeeen0_.deptno as deptno9_1_, employeeen0_.hiredate as hiredate4_1_, employeeen0_.job as job5_1_, employeeen0_.mgr as mgr6_1_, 
	 * employeeen0_.ename as ename7_1_, employeeen0_.sal as sal8_1_ from emp employeeen0_ limit ?
	 * @param page
	 * @param size
	 * @return
	 */
	public ResponseModel findEmployeeModelListAllByPagination(Integer page, Integer size) {
		page = Optional.ofNullable(page).orElse(0);
		size = Optional.ofNullable(size).orElse(Integer.MAX_VALUE);
		Pageable pageable = PageRequest.of(page, size);

		Page<EmployeeEntity> employeeEntityPage = employeeEntityRepository.findAll(pageable);
		List<EmployeeEntity> employeeEntityList = ListUtils.emptyIfNull(employeeEntityPage.getContent());
		List<EmployeeModel> employeeModelList = employeeEntityList.stream().map(EmployeeEntity::buildModel)
				.collect(Collectors.toList());

		ResponseModel responseModel = ResponseModel.builder().result(employeeModelList).count(employeeModelList.size())
				.totalCount(employeeEntityPage.getTotalElements()).build();
		return responseModel;
	}

	/**
	 * select employeeen0_.empno as empno1_1_, employeeen0_.active as active2_1_, employeeen0_.comm as comm3_1_, 
	 * employeeen0_.deptno as deptno9_1_, employeeen0_.hiredate as hiredate4_1_, employeeen0_.job as job5_1_, employeeen0_.mgr as mgr6_1_, 
	 * employeeen0_.ename as ename7_1_, employeeen0_.sal as sal8_1_ from emp employeeen0_ order by employeeen0_.ename asc, 
	 * employeeen0_.sal desc limit ?
	 * @return
	 */
	public ResponseModel findEmployeeModelListAllSortByENameAscAndSalaryDesc() {
		// prepare sort properties and order
		Sort.Order order1 = new Sort.Order(Sort.Direction.ASC, "name");
		Sort.Order order2 = new Sort.Order(Sort.Direction.DESC, "salary");
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		Sort sort = Sort.by(orders);

		// prepare pageable with above sort property
		Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, sort);

		// query
		Page<EmployeeEntity> employeeEntityPage = employeeEntityRepository.findAll(pageable);
		List<EmployeeEntity> employeeEntityList = ListUtils.emptyIfNull(employeeEntityPage.getContent());
		List<EmployeeModel> employeeModelList = employeeEntityList.stream().map(EmployeeEntity::buildModel)
				.collect(Collectors.toList());

		ResponseModel responseModel = ResponseModel.builder().result(employeeModelList).count(employeeModelList.size())
				.totalCount(employeeEntityPage.getTotalElements()).build();
		return responseModel;
	}
}