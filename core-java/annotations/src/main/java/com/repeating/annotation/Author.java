package com.repeating.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Authors.class)
public @interface Author {

	String name() default "no author";
}