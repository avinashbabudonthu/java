package com.web.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.rest.clients.model.Employee;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class WebClientMock {

	private Employee webClientAPICall(WebClient webClient) {
		MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
		multiValueMap.add("id", "1");
		multiValueMap.add("name", "name1");
		multiValueMap.add("joiningDate", "16-01-2020 04:41 PM");

		Mono<Employee> employeeMono = webClient.post().uri("/post/v1/api-3")
				.header("Content-Type", "application/x-www-form-urlencoded").syncBody(multiValueMap).retrieve()
				.bodyToMono(Employee.class);

		Employee employee = employeeMono.block();

		log.info("employee={}", employee);

		return employee;
	}

	@Test
	public void mockWebClientCalls() {
		WebClient webClientMock = Mockito.mock(WebClient.class);
		RequestBodyUriSpec requestBodyUriSpecMock = Mockito.mock(RequestBodyUriSpec.class);
		RequestBodySpec requestBodySpecUriMock = Mockito.mock(RequestBodySpec.class);
		RequestBodySpec requestBodySpecHeaderMock = Mockito.mock(RequestBodySpec.class);
		RequestHeadersSpec requestHeadersSpecMock = Mockito.mock(RequestHeadersSpec.class);
		ResponseSpec responseSpecMock = Mockito.mock(ResponseSpec.class);

		// @formatter:off
		Mockito.when(webClientMock.post()).thenReturn(requestBodyUriSpecMock);
		Mockito.when(requestBodyUriSpecMock.uri("/post/v1/api-3")).thenReturn(requestBodySpecUriMock);
		Mockito.when(requestBodySpecUriMock.header("Content-Type", "application/x-www-form-urlencoded")).thenReturn(requestBodySpecHeaderMock);
		Mockito.when(requestBodySpecHeaderMock.syncBody(Mockito.any())).thenReturn(requestHeadersSpecMock);
		Mockito.when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
		Mockito.when(responseSpecMock.bodyToMono(Employee.class)).thenReturn(Mono.just(Employee.builder().id(100L).build()));
		// @formatter:on

		Employee employee = webClientAPICall(webClientMock);

		log.info("employee-id={}", employee.getId());
	}
}