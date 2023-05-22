package data.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import data.jpa.model.StudentModel;
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
@Table(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "course")
	private String course;

	@Column(name = "joining_date")
	private Date joiningDate;

	@SneakyThrows
	public StudentModel buildModel() {
		StudentModel studentModel = new StudentModel();
		BeanUtils.copyProperties(studentModel, this);
		return studentModel;
	}

}
