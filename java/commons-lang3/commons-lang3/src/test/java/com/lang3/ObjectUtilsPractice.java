package com.lang3;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectUtilsPractice {

	@Test
	public void isEmpty() {
		Object nullObject = null;
		log.info("nullObject.isEmpty={}", ObjectUtils.isEmpty(nullObject)); // true

		Object object = new Object();
		log.info("object.isEmpty={}", ObjectUtils.isEmpty(object)); // false

		String nullName = null;
		log.info("nullName.isEmpty={}", ObjectUtils.isEmpty(nullName));// true

		String emptyName = StringUtils.EMPTY;
		log.info("emptyName.isEmpty={}", ObjectUtils.isEmpty(emptyName));// true

		String name = "jack";
		log.info("name.isEmpty={}", ObjectUtils.isEmpty(name));// false

		Integer nullInteger = null;
		log.info("nullInteger.isEmpty={}", ObjectUtils.isEmpty(nullInteger));// true

		Integer number = 10;
		log.info("number.isEmpty={}", ObjectUtils.isEmpty(number));// false

		Person nullPerson = null;
		log.info("nullPerson.isEmpty={}", ObjectUtils.isEmpty(nullPerson));// true

		Person person = new Person();
		log.info("person.isEmpty={}", ObjectUtils.isEmpty(person));// false
	}

	@Test
	public void isNotEmpty() {
		Object nullObject = null;
		log.info("nullObject.isEmpty={}", ObjectUtils.isNotEmpty(nullObject)); // false

		Object object = new Object();
		log.info("object.isEmpty={}", ObjectUtils.isNotEmpty(object)); // true

		String nullName = null;
		log.info("nullName.isEmpty={}", ObjectUtils.isNotEmpty(nullName));// false

		String emptyName = StringUtils.EMPTY;
		log.info("emptyName.isEmpty={}", ObjectUtils.isNotEmpty(emptyName));// false

		String name = "jack";
		log.info("name.isEmpty={}", ObjectUtils.isNotEmpty(name));// true

		Integer nullInteger = null;
		log.info("nullInteger.isEmpty={}", ObjectUtils.isNotEmpty(nullInteger));// false

		Integer number = 10;
		log.info("number.isEmpty={}", ObjectUtils.isNotEmpty(number));// true

		Person nullPerson = null;
		log.info("nullPerson.isEmpty={}", ObjectUtils.isNotEmpty(nullPerson));// false

		Person person = new Person();
		log.info("person.isEmpty={}", ObjectUtils.isNotEmpty(person));// true
	}
}