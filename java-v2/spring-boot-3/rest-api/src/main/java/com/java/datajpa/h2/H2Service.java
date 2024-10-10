package com.java.datajpa.h2;

import com.java.entity.EmployeeEntity;

import java.util.List;

public interface H2Service {
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    List<EmployeeEntity> saveEmployeeEntityList(List<EmployeeEntity> employeeEntityList);

    List<EmployeeEntity> findAllEmployeeEntities();
}
