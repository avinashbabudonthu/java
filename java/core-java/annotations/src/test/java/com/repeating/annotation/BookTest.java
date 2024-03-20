package com.repeating.annotation;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j
public class BookTest {

	private Logger log = LoggerFactory.getLogger(BookTest.class);

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