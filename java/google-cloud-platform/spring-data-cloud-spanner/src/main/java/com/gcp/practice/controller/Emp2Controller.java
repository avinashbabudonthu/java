package com.gcp.practice.controller;

import com.gcp.practice.model.Emp2Model;
import com.gcp.practice.service.Emp2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Emp2Controller {

    @Autowired
    private Emp2Service emp2Service;

    @PostMapping(value = "/emp2s", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Emp2Model saveEmp2Model(@RequestBody Emp2Model emp2Model){
        return emp2Service.saveEmp2Model(emp2Model);
    }

    @GetMapping(value = "/emp2s", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Emp2Model> findEmp2ModelList(){
        return emp2Service.findEmp2ModelList();
    }

}
