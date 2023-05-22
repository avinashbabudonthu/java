package data.jpa.custom.repository;

import java.util.List;

import data.jpa.entity.EmployeeEntity;

public interface CustomEmployeeRespository {

	List<EmployeeEntity> findAllEmployees();

	List<EmployeeEntity> findAllEmployeesByDeptId(Integer deptId);

}