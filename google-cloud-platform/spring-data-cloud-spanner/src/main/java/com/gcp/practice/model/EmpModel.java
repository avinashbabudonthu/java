package com.gcp.practice.model;

import com.gcp.practice.entity.EmpEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpModel {

    private Long empNo;
    private String ename;
    private String job;
    private Long salary;

    public EmpEntity buildEntity(){
        EmpEntity empEntity = new EmpEntity();
        empEntity.setEmpNo(empNo);
        empEntity.setEname(ename);
        empEntity.setJob(job);
        empEntity.setSalary(salary);
        return empEntity;
    }
}
