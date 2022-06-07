package com.app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

	private Integer id;
	private String name;
	private String job;
	private Long salary;
	private Long comm;
	private Integer manager;
	private Date hiredate;
	private Boolean active;
}
