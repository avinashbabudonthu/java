package com.hibernate.basics.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = -1795419991289746646L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "COURSE_NAME")
	@Enumerated(EnumType.STRING)
	private CourseEnum courseName;

	@Column(name = "course_rank")
	@Enumerated(EnumType.ORDINAL)
	private CourseRankEnum courseRank;

	@Column(name = "COURSE_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date courseStartDate;

}