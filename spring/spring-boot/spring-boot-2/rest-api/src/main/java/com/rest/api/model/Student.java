package com.rest.api.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	private String id;
	private List<String> idList;
	private String name;
	private String course;
	private Date joiningDate;
}
