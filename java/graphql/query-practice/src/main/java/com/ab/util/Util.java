package com.ab.util;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public static final Faker FAKER = Faker.instance();

}