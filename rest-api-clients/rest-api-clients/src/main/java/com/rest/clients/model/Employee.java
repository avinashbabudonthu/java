package com.rest.clients.model;

import static com.rest.clients.util.Constants.DATE_FORMAT_DD_MM_YYYY_HH_MM_A;
import static com.rest.clients.util.Constants.EN;
import static com.rest.clients.util.Constants.IST;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Long id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_DD_MM_YYYY_HH_MM_A, timezone = IST, locale = EN)
	private Date joiningDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_DD_MM_YYYY_HH_MM_A, timezone = IST, locale = EN)
	private Date createDate;
}