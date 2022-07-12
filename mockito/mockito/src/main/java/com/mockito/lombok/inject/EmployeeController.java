package com.mockito.lombok.inject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	public String getName() {
		log.info("Getting employee name");
		return employeeService.getName();
	}
}
