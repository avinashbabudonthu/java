package com.api.response.header.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.api.response.header.util.RequestUUIDGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class RequestResponseFilter implements Filter {

	private static final String TRANSACTION_ID = "global-transaction-id";

	@Autowired
	private RequestUUIDGenerator requestUUIDGenerator;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("{} doFilter method", RequestResponseFilter.class.getName());

		final String transactionId = requestUUIDGenerator.nextUUID();
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		ThreadContext.put(TRANSACTION_ID, transactionId);
		httpServletResponse.setHeader(TRANSACTION_ID, transactionId);

		chain.doFilter(request, response);
	}
}