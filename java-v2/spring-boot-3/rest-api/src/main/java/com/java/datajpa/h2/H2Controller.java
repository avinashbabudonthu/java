package com.java.datajpa.h2;

import com.java.entity.EmployeeEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "/h2/apis")
public interface H2Controller {

    @PostMapping(value = "/v1/employees", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity);

    @PostMapping(value = "/v2/employees", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    List<EmployeeEntity> saveEmployeeEntityList(@RequestBody List<EmployeeEntity> employeeEntityList);

    @GetMapping(value = "/v1/employees", produces = APPLICATION_JSON_VALUE)
    List<EmployeeEntity> findAllEmployeeEntities();

}