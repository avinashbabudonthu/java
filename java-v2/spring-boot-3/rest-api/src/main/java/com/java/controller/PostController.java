package com.java.controller;

import com.java.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RequestMapping(value = "/post/api")
public interface PostController {

    /**
     * Get Student json as text and convert to {@link Student} object
     * @param studentJsonAsText Input Student as json text
     * @return {@link Student}
     */
    @PostMapping(value = "/v1/students", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV1(@RequestBody String studentJsonAsText);

    /**
     * Get {@link Student} as request body
     * @param student Request body - {@link Student}
     * @return {@link Student}
     */
    @PostMapping(value = "/v2/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV2(@RequestBody Student student);

    /**
     * Get {@link Student} as request body. name and book as request headers
     * @param student request body {@link Student}
     * @param name request header
     * @param book request header
     * @return {@link Student}
     */
    @PostMapping(value = "/v3/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV3(@RequestBody Student student, @RequestHeader("name") String name, @RequestHeader("book") String book);

    /**
     * {@link Student} as request body. name and book as request parameters
     * @param student {@link Student}
     * @param name request parameter
     * @param book request parameter
     * @return {@link Student}
     */
    @PostMapping(value = "/v4/students", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV4(@RequestBody Student student, @RequestParam("name") String name, @RequestParam("book") String book);

    /**
     * {@link Student} as request body. name and book as path variables
     * @param student {@link Student}
     * @param name path variable
     * @param book path variable
     * @return {@link Student}
     */
    @PostMapping(value = "/v5/students/{name}/{book}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV5(@RequestBody Student student, @PathVariable("name") String name, @PathVariable("book") String book);

    /**
     * {@link Student} as request body. id as path variable. name as request header. book as request parameter
     * @param student {@link Student}
     * @param id path variable
     * @param name request header
     * @param book request parameter
     * @return {@link Student}
     */
    @PostMapping(value = "/v6/students/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    Student studentV6(@RequestBody Student student, @PathVariable("id") String id, @RequestHeader("name") String name, @RequestParam("book") String book);

}