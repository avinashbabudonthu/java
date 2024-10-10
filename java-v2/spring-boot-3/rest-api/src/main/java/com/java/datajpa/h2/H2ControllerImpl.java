package com.java.datajpa.h2;

import com.java.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class H2ControllerImpl implements H2Controller {

    private final H2Service h2Service;

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return h2Service.saveEmployee(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> saveEmployeeEntityList(List<EmployeeEntity> employeeEntityList) {
        return h2Service.saveEmployeeEntityList(employeeEntityList);
    }

    @Override
    public List<EmployeeEntity> findAllEmployeeEntities() {
        return h2Service.findAllEmployeeEntities();
    }

}
