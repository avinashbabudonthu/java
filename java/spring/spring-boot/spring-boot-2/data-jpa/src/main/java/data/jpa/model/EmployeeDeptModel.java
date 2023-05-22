package data.jpa.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDeptModel {

	private Integer id;
	private String name;
	private String job;
	private Long salary;
	private Long comm;
	private Integer manager;
	private Date hiredate;
	private Integer deptId;
	private String deptName;
	private String location;

}
