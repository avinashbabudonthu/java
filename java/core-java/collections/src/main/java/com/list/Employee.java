package com.list;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {

	private Integer id;
	private String name;
	private LocalDate joiningDate;
	private String gender;
	private Long salary;
	private String department;
}
