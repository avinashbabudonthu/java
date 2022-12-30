package com.jackson.json;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.json.model.Days;
import com.jackson.json.model.Employee;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonStringToObject {

	/**
	 * Input Json: [{"name": "jim", "value": {"id": "1", "name": "jim"}}, {"name": "jill", "value": {"id": "2", "name": "jill"}}]
	 * 
	 * Output: List<Map<String, Employee>>
	 */
	@SneakyThrows
	@Test
	public void jsonStringToMapOfStringAndObject() {
		final String jsonString = "[{\"emp1\": {\"id\": \"1\", \"name\": \"jim\"}}, {\"emp2\": {\"id\": \"2\", \"name\": \"jill\"}}]";
		List<Map<String, Employee>> employeesMap = new ObjectMapper().readValue(jsonString,
				new TypeReference<List<Map<String, Employee>>>() {
				});

		// input-json=[{"emp1": {"id": "1", "name": "jim"}}, {"emp2": {"id": "2", "name": "jill"}}]
		log.info("input-json={}", jsonString);

		// employees-map=[{emp1=Employee(id=1, name=jim)}, {emp2=Employee(id=2, name=jill)}]
		log.info("employees-map={}", employeesMap);
	}

	@SneakyThrows
	@Test
	public void jsonStringToObjectList() {
		final String jsonString = "[{\"id\": \"1\", \"name\": \"jim\"}, {\"id\": \"2\", \"name\": \"jill\"}]";

		// method 1
		List<Employee> employeeList = new ObjectMapper().readValue(jsonString, new TypeReference<List<Employee>>() {
		});
		log.info("employee-list={}", employeeList);

		// method 2
		Employee[] employeeList2 = new ObjectMapper().readValue(jsonString, Employee[].class);
		Arrays.stream(employeeList2).forEach(System.out::println);

		// method 3
		List<Employee> employeeList3 = Arrays.asList(new ObjectMapper().readValue(jsonString, Employee[].class));
		log.info("employee-list3={}", employeeList3);
	}

	@SneakyThrows
	@Test
	public void enumJsonToEnumObject() {
		String enumJsonString = new ObjectMapper().writeValueAsString(Days.MONDAY);
		log.info("enumJsonString={}", enumJsonString);
	}

	@SneakyThrows
	@Test
	public void jsonStringToJsonNode(){
		final String jsonString = "[{\"id\": \"1\", \"name\": \"jim\"}, {\"id\": \"2\", \"name\": \"jill\"}]";

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonString);
		System.out.println(jsonNode);

		JsonNode index0 = jsonNode.get(0);
		System.out.println(index0);

		JsonNode id = index0.get("id");
		JsonNode name = index0.get("name");
		System.out.println(id); // "1"
		System.out.println(name); // "jim"
		System.out.println(id.textValue()); // 1
		System.out.println(name.textValue()); // jim
	}

}