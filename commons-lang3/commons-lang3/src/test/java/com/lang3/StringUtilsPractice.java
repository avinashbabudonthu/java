package com.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtilsPractice {

	@Test
	public void isNoneBlank() {
		String name1 = "john";
		String name2 = "jim";
		String name3 = "jane";
		String name4 = "";

		boolean result1 = StringUtils.isNoneBlank(name1, name2, name3);
		log.info("result1={}", result1); // true

		boolean result2 = StringUtils.isNoneBlank(name2, name3, name4);
		log.info("result2={}", result2); // false
	}

}