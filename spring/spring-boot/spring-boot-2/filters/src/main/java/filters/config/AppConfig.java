package filters.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import filters.all.FilterFive;
import filters.all.FilterFour;
import filters.all.FilterThree;

@Configuration
public class AppConfig {

	@Autowired
	private FilterThree filterThree;

	@Autowired
	private FilterFour filterFour;

	@Autowired
	private FilterFive filterFive;

	@Bean
	public FilterRegistrationBean<FilterThree> registerApiOneFilter() {
		FilterRegistrationBean<FilterThree> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(filterThree);
		registrationBean.addUrlPatterns("/api/v1/*");

		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<FilterFour> registerApiTwoFilter() {
		FilterRegistrationBean<FilterFour> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(filterFour);
		registrationBean.addUrlPatterns("/api/v2/*");

		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<FilterFive> registerFilterFive() {
		FilterRegistrationBean<FilterFive> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(filterFive);
		registrationBean.setUrlPatterns(Arrays.asList("/api/v1/*", "/api/v2/*"));

		return registrationBean;
	}

}