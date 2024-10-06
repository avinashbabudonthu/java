package com.java.service.impl;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.java.model.User;
import com.java.service.UserService;
import io.netty.handler.codec.base64.Base64Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static final Faker FAKER = Faker.instance();

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        IntStream.range(0, 10).forEach((num) ->
                users.add(User.builder()
                        .username(FAKER.name().username()).firstName(FAKER.name().firstName())
                        .lastName(FAKER.name().lastName()).password(FAKER.name().title())
                        .encryptedPassword(FAKER.random().hex())
                        .build())
        );
        return users;
    }

}
