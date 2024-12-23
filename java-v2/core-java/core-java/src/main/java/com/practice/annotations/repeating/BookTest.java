package com.practice.annotations.repeating;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BookTest {

    /*
     * Output:
     *
     * @com.practice.annotations.repeating.Authors({@com.practice.annotations.repeating.Author(name="jack"), @com.practice.annotations.repeating.Author(name="jill")})
     * @com.practice.annotations.repeating.Author(name="jack")
     * @com.practice.annotations.repeating.Author(name="jill")
     */
    @Test
    public void test1() {
        Class<Book> bookClass = Book.class;
        Authors annotations = bookClass.getAnnotation(Authors.class);
        log.info("{}", annotations);

        Author[] authorAnnotationsArray = annotations.value();
        for (Author author : authorAnnotationsArray) {
            log.info("{}", author);
        }

    }
}