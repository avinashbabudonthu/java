package com.gcp.practice.entity;

import com.gcp.practice.model.EmpModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp")
public class EmpEntity {

    @PrimaryKey
    @Column(name = "empno")
    private Long empNo;

    @Column(name = "ename")
    private String ename;

    @Column(name = "job")
    private String job;

    @Column(name = "salary")
    private Long salary;

    public EmpModel buildModel(){
        EmpModel empModel = new EmpModel();
        empModel.setEmpNo(empNo);
        empModel.setEname(ename);
        empModel.setJob(job);
        empModel.setSalary(salary);
        return empModel;
    }

}