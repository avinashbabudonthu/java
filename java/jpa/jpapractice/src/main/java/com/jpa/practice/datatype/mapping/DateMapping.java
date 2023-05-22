package com.jpa.practice.datatype.mapping;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "date_mapping")
public class DateMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DATE_COLUMN")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "TIME_COLUMN")
	@Temporal(TemporalType.TIME)
	private Date time;

	@Column(name = "TIME_STAMP_COLUMN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	@Transient
	private String transientField;

	public DateMapping(String name, Date date, Date time, Date timeStamp) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.timeStamp = timeStamp;
	}

	public DateMapping() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTransientField() {
		return transientField;
	}

	public void setTransientField(String transientField) {
		this.transientField = transientField;
	}

	@Override
	public String toString() {
		return "EntityWithDateMapping [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", timeStamp="
				+ timeStamp + ", transientField=" + transientField + "]";
	}

}