package com.serialization;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Employee implements Serializable {

	private static final long serialVersionUID = -8744539530476499266L;
	private String id;
	private double grade;

}