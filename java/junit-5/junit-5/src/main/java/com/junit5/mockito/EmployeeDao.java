package com.junit5.mockito;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeDao {

	public List<String> getEmployeeNames() {
		log.info("inside getEmployeeNames()");
		List<String> names = new ArrayList<>();
		names.add("jack");
		names.add("jill");
		return names;
	}

}