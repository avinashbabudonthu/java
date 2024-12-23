package com.practice.annotations.repeating;

import java.lang.annotation.Repeatable;

@Repeatable(Authors.class)
public @interface Author {

	String name() default "unknown";
}