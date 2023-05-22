package com.gcp.practice.controller;

import com.gcp.practice.entity.EmpEntity;
import com.gcp.practice.model.EmpModel;
import com.gcp.practice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping(value = "/emps", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmpModel saveEmpModel(@RequestBody  EmpModel empModel){
        return empService.saveEmpModel(empModel);
    }

    @GetMapping(value = "/emps", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmpModel> findAllEmpEntityList(){
        return empService.findAllEmpEntityList();
    }

    @GetMapping(value = "/emps/{empno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpModel findEmpModelByEmpno(@PathVariable("empno") Long empno){
        return empService.findEmpModelByEmpno(empno);
    }

    @DeleteMapping(value = "/emps/{empno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpModel deleteEmpModelByEmpno(@PathVariable("empno") Long empno){
        return empService.deleteEmpModelByEmpno(empno);
    }
}