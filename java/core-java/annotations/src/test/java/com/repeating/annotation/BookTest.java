package com.repeating.annotation;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookTest {

	@Test
	public void classLevelRepeatableAnnotation() {
		Class<Book> bookClass = Book.class;
		Authors annotations = bookClass.getAnnotation(Authors.class);
		log.info("{}", annotations);

		Author[] authorAnnotationsArray = annotations.value();
		for (Author author : authorAnnotationsArray) {
			log.info("{}", author);
		}
	}
}