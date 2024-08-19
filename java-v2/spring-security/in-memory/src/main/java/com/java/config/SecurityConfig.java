package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    /**
     * {@link User} extends {@link UserDetails}
     * {@link InMemoryUserDetailsManager} extends {@link UserDetailsService}
     * @return In memory user details object with our users credentials
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("user1").password("{noop}pwd1").roles("read").build();
        UserDetails user2 = User.withUsername("user2").password("{noop}pwd2").roles("write").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

}