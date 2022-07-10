package com.zuul.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggingFilter extends ZuulFilter {

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * Available values - 
	 * pre: before request
	 * post: after request
	 * error: for error request
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();

		log.info("URI={}", httpServletRequest.getRequestURI());

		return null;
	}

}
