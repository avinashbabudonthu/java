package com.gcp.practice.entity;

import com.gcp.practice.model.Emp2Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp2")
public class Emp2Entity {

    @PrimaryKey
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "job")
    private String job;

    @Column(name = "lastupdateTimestamp", spannerCommitTimestamp = true)
    private Date lastupdateTimestamp;

    public Emp2Model buildModel(){
        Emp2Model emp2Model = new Emp2Model();
        emp2Model.setId(id);
        emp2Model.setName(name);
        emp2Model.setJob(job);
        emp2Model.setLastupdateTimestamp(lastupdateTimestamp);

        return emp2Model;
    }
}