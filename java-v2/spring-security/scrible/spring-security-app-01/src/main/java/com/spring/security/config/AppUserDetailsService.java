package com.spring.security.config;

import com.spring.security.entity.CustomerEntity;
import com.spring.security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity customerEntity = customerRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found for username=" + username)
        );
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(customerEntity.getRole()));
        return new User(customerEntity.getEmail(), customerEntity.getPwd(), grantedAuthorities);
    }

}