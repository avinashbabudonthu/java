package com.spring.security.controller;

import com.spring.security.entity.CustomerEntity;
import com.spring.security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CustomerEntity createUser(@RequestBody CustomerEntity customerEntity) {
        String hashPwd = passwordEncoder.encode(customerEntity.getPwd());
        customerEntity.setPwd(hashPwd);
        return customerRepository.save(customerEntity);
    }

}