package data.jpa.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

	private Integer id;
	private String name;
	private Integer deptId;
	private String job;
	private Long salary;
	private Long comm;
	private Integer manager;
	private Date hiredate;
	private Boolean active;

}