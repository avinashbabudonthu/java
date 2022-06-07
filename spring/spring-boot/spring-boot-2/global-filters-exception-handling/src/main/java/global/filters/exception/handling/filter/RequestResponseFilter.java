package global.filters.exception.handling.filter;

import static global.filters.exception.handling.util.Constants.TRANSACTION_ID;
import static global.filters.exception.handling.util.ErrorsEnum.REQUEST_HEADER_MISSING;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import global.filters.exception.handling.util.Utils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class RequestResponseFilter implements Filter {

	@Autowired
	private Utils utils;

	@SneakyThrows
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("{} doFilter method", RequestResponseFilter.class.getName());

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader(TRANSACTION_ID, UUID.randomUUID().toString());

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String appName = httpServletRequest.getHeader("app");

		if (StringUtils.isBlank(appName)) {
			throw utils.buildAppException(REQUEST_HEADER_MISSING.getCode(), REQUEST_HEADER_MISSING.getMessage(), null,
					"app").get();
		}

		chain.doFilter(request, response);
	}

}
