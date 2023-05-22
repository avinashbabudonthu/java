package com.jpa.practice.datatype.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enum_mapping")
public class EnumMapping {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "day_name")
	@Enumerated(EnumType.ORDINAL)
	private DaysEnum day;

	@Column(name = "day_name2")
	@Enumerated(EnumType.STRING)
	private DaysEnum day2;

	public EnumMapping(DaysEnum day, DaysEnum day2) {
		this.day = day;
		this.day2 = day2;
	}

	public EnumMapping() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DaysEnum getDay() {
		return day;
	}

	public void setDay(DaysEnum day) {
		this.day = day;
	}

	public DaysEnum getDay2() {
		return day2;
	}

	public void setDay2(DaysEnum day2) {
		this.day2 = day2;
	}

	@Override
	public String toString() {
		return "EnumMapping [id=" + id + ", day=" + day + ", day2=" + day2 + "]";
	}

}