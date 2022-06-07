package com.app.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeadersEnum {

	//@formatter:off
	HEADER1("header1"),
	HEADER2("header2")
	;
	//@formatter:on

	private String code;

}
