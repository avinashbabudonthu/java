package com.gcp.practice.service;

import com.gcp.practice.entity.EmpEntity;
import com.gcp.practice.model.EmpModel;
import com.gcp.practice.repository.EmpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    @Transactional
    public EmpModel saveEmpModel(EmpModel empModel){
        EmpEntity empEntity = empModel.buildEntity();
        EmpEntity persistedEmpEntity = empRepository.save(empEntity);
        return persistedEmpEntity.buildModel();
    }

    public List<EmpModel> findAllEmpEntityList(){
      Iterable<EmpEntity> empEntityIterable = empRepository.findAll();
      List<EmpModel> empModelList = new ArrayList<>();
      for(EmpEntity empEntity: empEntityIterable){
          empModelList.add(empEntity.buildModel());
      }
      return empModelList;
    }

    public EmpModel findEmpModelByEmpno(Long empno){
        Optional<EmpEntity> empEntityOptional = empRepository.findById(empno);
        EmpEntity empEntity = empEntityOptional.get();
        return empEntity.buildModel();
    }

    @Transactional
    public EmpModel deleteEmpModelByEmpno(Long empno){
        EmpEntity empEntity = empRepository.findById(empno).get();
        empRepository.deleteById(empno);
        return empEntity.buildModel();
    }

}