package com.java.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id"})
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    /*@GenericGenerator(name = "custom-primary-key-generator", type = PrimaryKeyGenerator.class)
    @GeneratedValue(generator = "custom-primary-key-generator")*/
    @MyPrimaryKeyGenerator(name = "custom-primary-key-generator")
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @JsonFormat(shape = STRING, pattern = "ddMMyyyy", timezone = "IST", locale = "en")
    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

}