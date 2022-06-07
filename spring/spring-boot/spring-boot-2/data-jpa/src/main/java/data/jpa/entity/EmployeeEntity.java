package data.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import data.jpa.model.EmployeeDeptModel;
import data.jpa.model.EmployeeModel;
import data.jpa.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMP")
// @formatter:off
@SqlResultSetMappings({
	@SqlResultSetMapping(name = Constants.FIND_ALL_EMPLOYEES_RESULT_SET_MAPPING, classes = @ConstructorResult(targetClass = EmployeeDeptModel.class, columns = {
			@ColumnResult(name = "empno", type = Integer.class), @ColumnResult(name = "ename", type = String.class),
			@ColumnResult(name = "job", type = String.class), @ColumnResult(name = "sal", type = Long.class),
			@ColumnResult(name = "comm", type = Long.class), @ColumnResult(name = "mgr", type = Integer.class),
			@ColumnResult(name = "hiredate", type = Date.class), @ColumnResult(name = "deptno", type = Integer.class),
			@ColumnResult(name = "dname", type = String.class), @ColumnResult(name = "loc", type = String.class) })
		),
	
	@SqlResultSetMapping(
			name = Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_RESULT_SET_MAPPING, 
			classes = @ConstructorResult(targetClass = EmployeeDeptModel.class, columns = {
			@ColumnResult(name = "empno", type = Integer.class), @ColumnResult(name = "ename", type = String.class),
			@ColumnResult(name = "job", type = String.class), @ColumnResult(name = "sal", type = Long.class),
			@ColumnResult(name = "comm", type = Long.class), @ColumnResult(name = "mgr", type = Integer.class),
			@ColumnResult(name = "hiredate", type = Date.class), @ColumnResult(name = "deptno", type = Integer.class),
			@ColumnResult(name = "dname", type = String.class), @ColumnResult(name = "loc", type = String.class) })
		)
})
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = Constants.FIND_ALL_EMPLOYEES_NAME, 
				procedureName = Constants.FIND_ALL_EMPLOYEES_SP, 
				resultSetMappings = {Constants.FIND_ALL_EMPLOYEES_RESULT_SET_MAPPING }),
		
		@NamedStoredProcedureQuery(
				name = Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_NAME, 
				procedureName = Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_SP,
				resultSetMappings = { Constants.FIND_ALL_EMPLOYEES_BY_DEPT_ID_RESULT_SET_MAPPING })
		})
// @formatter:on
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPNO")
	private Integer id;

	@Column(name = "ENAME")
	private String name;

	@Column(name = "JOB")
	private String job;

	@Column(name = "SAL")
	private Long salary;

	@Column(name = "COMM")
	private Long comm;

	@Column(name = "MGR")
	private Integer manager;

	@Column(name = "HIREDATE")
	private Date hiredate;

	@Column(name = "ACTIVE")
	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
	private DepartmentEntity department;

	@SneakyThrows
	public EmployeeModel buildModel() {
		EmployeeModel employeeModel = new EmployeeModel();
		BeanUtils.copyProperties(employeeModel, this);
		return employeeModel;
	}

}
