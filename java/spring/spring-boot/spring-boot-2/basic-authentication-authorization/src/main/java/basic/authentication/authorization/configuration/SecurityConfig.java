package basic.authentication.authorization.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	// authentication
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		//@formatter:off
		authenticationManagerBuilder.jdbcAuthentication()
		.dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select auth.username, role.role from authorities auth join t_role role on auth.role_id = role.id where auth.username = ?");
		//@formatter:on
	}

	// authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		//@formatter:off
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/**").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/public/**").permitAll()
		.and()
		.httpBasic();
		//@formatter:on
	}

	/* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
						.allowedOrigins("*").allowedHeaders("*");
			}
		};
	}

}
