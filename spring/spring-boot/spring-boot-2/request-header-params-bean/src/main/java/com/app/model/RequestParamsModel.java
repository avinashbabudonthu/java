package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestParamsModel {

	@Builder.Default
	private Integer reqParam1 = 0;

	@Builder.Default
	private String reqParam2 = "no-value";

}