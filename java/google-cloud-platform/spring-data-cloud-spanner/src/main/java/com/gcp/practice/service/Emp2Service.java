package com.gcp.practice.service;

import com.gcp.practice.entity.Emp2Entity;
import com.gcp.practice.model.Emp2Model;
import com.gcp.practice.repository.Emp2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Emp2Service {

    @Autowired
    private Emp2Repository emp2Repository;

    public Emp2Model saveEmp2Model(Emp2Model emp2Model){
        Emp2Entity emp2Entity = emp2Model.buildEntity();
        Emp2Entity persistedEmp2Entity = emp2Repository.save(emp2Entity);
        return persistedEmp2Entity.buildModel();
    }

    public List<Emp2Model> findEmp2ModelList(){
        Iterable<Emp2Entity> emp2EntityIterable = emp2Repository.findAll();
        List<Emp2Model> emp2ModelList = new ArrayList<>();
        for(Emp2Entity emp2Entity: emp2EntityIterable){
            emp2ModelList.add(emp2Entity.buildModel());
        }

        return emp2ModelList;
    }
}