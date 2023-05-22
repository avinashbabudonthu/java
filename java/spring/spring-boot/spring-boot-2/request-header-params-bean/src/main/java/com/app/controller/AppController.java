package com.app.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.RequestParamsModel;
import com.app.util.HeadersEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AppController {

	@GetMapping(value = "/request-params", produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestParamsModel requestParams(RequestParamsModel requestParamsModel) {
		log.info("request param1={}, param2={}", requestParamsModel.getReqParam1(), requestParamsModel.getReqParam2());
		return requestParamsModel;
	}

	@GetMapping(value = "/request-params-and-headers", produces = MediaType.APPLICATION_JSON_VALUE)
	public RequestParamsModel requestParamsAndHeaders(RequestParamsModel requestParamsModel,
			@RequestHeader Map<String, Object> requestHeaders) {
		log.info("request param1={}, param2={}", requestParamsModel.getReqParam1(), requestParamsModel.getReqParam2());
		log.info("header1={}, header2={}", requestHeaders.get(HeadersEnum.HEADER1.getCode()),
				requestHeaders.get(HeadersEnum.HEADER2.getCode()));
		return requestParamsModel;
	}
}