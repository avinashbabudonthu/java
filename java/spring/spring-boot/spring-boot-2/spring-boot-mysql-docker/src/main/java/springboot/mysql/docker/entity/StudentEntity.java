package springboot.mysql.docker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.beanutils.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import springboot.mysql.docker.model.StudentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "joining_date")
	@Temporal(value = TemporalType.DATE)
	private Date joiningDate;

	@SneakyThrows
	public StudentModel buildModel() {
		StudentModel studentModel = new StudentModel();
		BeanUtils.copyProperties(studentModel, this);
		return studentModel;
	}
}