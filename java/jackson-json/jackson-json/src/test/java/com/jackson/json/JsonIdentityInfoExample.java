package com.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.json.model.Book;
import com.jackson.json.model.Student;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @JsonIdentityInfo is used when objects have parent child relationship.
 * @JsonIdentityInfo is used to indicate that object identity
 * will be used during serialization/de-serialization.
 */
@Slf4j
public class JsonIdentityInfoExample {

    /**
     * {
     *   "id" : 1,
     *   "rollNo" : 10,
     *   "name" : "jack",
     *   "books" : [ {
     *     "id" : 100,
     *     "name" : "java",
     *     "student" : 1
     *   }, {
     *     "id" : 101,
     *     "name" : "jackson-json",
     *     "student" : 1
     *   } ]
     * }
     * -------------
     * book1: {
     *   "id" : 100,
     *   "name" : "java",
     *   "student" : {
     *     "id" : 1,
     *     "rollNo" : 10,
     *     "name" : "jack",
     *     "books" : [ 100, {
     *       "id" : 101,
     *       "name" : "jackson-json",
     *       "student" : 1
     *     } ]
     *   }
     * }
     *
     */
    @SneakyThrows
    @Test
    public void jsonIdentityInfoExample1(){
        ObjectMapper objectMapper = new ObjectMapper();

        Student student = Student.builder().id(1).rollNo(10).name("jack").books(new ArrayList<>()).build();

        Book book1 = Book.builder().id(100).name("java").student(student).build();
        Book book2 = Book.builder().id(101).name("jackson-json").student(student).build();

        student.getBooks().add(book1);
        student.getBooks().add(book2);

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        log.info("{}", jsonString);
        String book1Json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book1);
        log.info("book1: {}", book1Json);
    }

}