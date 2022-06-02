package com.gcp.practice.model;

import com.gcp.practice.entity.Emp2Entity;
import com.gcp.practice.service.Emp2Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp2Model {

    private Long id;
    private String name;
    private String job;
    private Date lastupdateTimestamp;

    public Emp2Entity buildEntity(){
        Emp2Entity emp2Entity = new Emp2Entity();
        emp2Entity.setId(id);
        emp2Entity.setName(name);
        emp2Entity.setJob(job);
        emp2Entity.setLastupdateTimestamp(lastupdateTimestamp);

        return emp2Entity;
    }
}