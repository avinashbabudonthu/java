package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class AppConfig {

    /**
     * withDefaultPasswordEncoder() - is deprecated method.
     * If you want to use custom password encoded - use inMemoryUserDetailsManager2() method
     *
     */
    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("admin").password("dummy")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }*/

    /**
     * 1 user
     * Using custom password encoder.
     * If you want to use default password encoder - uncomment inMemoryUserDetailsManager() method
     */
    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager2() {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails1 = User.builder().passwordEncoder(passwordEncoder).username("admin2").password("dummy2").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails1);
    }*/

    /**
     * multiple users
     * Using custom password encoder.
     * If you want to use default password encoder - uncomment inMemoryUserDetailsManager() method
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager3() {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails1 = User.builder().passwordEncoder(passwordEncoder).username("admin1").password("dummy1").roles("USER", "ADMIN").build();
        UserDetails userDetails2 = User.builder().passwordEncoder(passwordEncoder).username("admin2").password("dummy2").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}