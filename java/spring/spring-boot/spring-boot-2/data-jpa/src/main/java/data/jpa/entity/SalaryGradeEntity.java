package data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SALGRADE")
public class SalaryGradeEntity {

	@Id
	@Column(name = "GRADE")
	private Long highSalary;

	@Column(name = "HISAL")
	private Long lowSalary;

	@Column(name = "LOSAL")
	private Long grade;

}
