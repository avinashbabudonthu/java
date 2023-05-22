package dynamic.filtering.controller;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import dynamic.filtering.model.AppModel;

@RestController
public class AppController {

	@GetMapping(value = "/api1", produces = MediaType.APPLICATION_JSON_VALUE)
	public MappingJacksonValue api1() {
		AppModel appModel = AppModel.builder().field1("value1").field2("value2").field3("value3").build();
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1",
				"field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AppModelFilter",
				simpleBeanPropertyFilter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(appModel);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

	@GetMapping(value = "/api2", produces = MediaType.APPLICATION_JSON_VALUE)
	public MappingJacksonValue api2() {
		AppModel appModel = AppModel.builder().field1("value1").field2("value2").field3("value3").build();
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2",
				"field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AppModelFilter",
				simpleBeanPropertyFilter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(appModel);
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;
	}

}