package com.rest.api.model;

import com.rest.api.util.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student2 {

	private String id;
	private List<String> idList;
	private String name;
	private String course;
	private GenderEnum gender;
}
