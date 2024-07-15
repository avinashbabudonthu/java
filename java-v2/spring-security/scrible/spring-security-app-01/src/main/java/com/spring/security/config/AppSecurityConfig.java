package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class AppSecurityConfig {

    /**
     * Refer {@link org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration} class defaultSecurityFilterChain method for default implementation
     * @param http {@link HttpSecurity}
     * @return {@link SecurityFilterChain}
     * @throws {@link Exception} propagates exceptions from authorizeHttpRequests, formLogin, httpBasic methods
     */
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
//         http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/hello-world", "/contacts", "/notices", "/error").permitAll()
                .requestMatchers("/my-account").authenticated());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    /**
     * {@link User} extends {@link UserDetails}
     * {@link InMemoryUserDetailsManager} extends {@link UserDetailsService}
     * @return In memory user details object with our users credentials
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // we need to prefix password with {noop} if we do not provide PasswordEncoder bean
        UserDetails user1 = User.withUsername("user1").password("{noop}12345").roles("read").build();
        UserDetails user2 = User.withUsername("user2").password("{bcrypt}$2a$12$Oxfjl53Ch6eZrQRK5ZCTTe.uTrbsXOoGPumEYlQWzi2wTADpzlkTG").roles("admin").build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

}