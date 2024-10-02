package com.java.controller;

import com.java.model.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Tag(name = "Get APIs")
@RequestMapping(value = "/get/api")
public interface GetController {

    /**
     * API to return Simple Text
     * @return {@link String}
     */
    @Operation(summary = "Hello World GET API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hello World",
                content = {@Content(mediaType = TEXT_PLAIN_VALUE, schema = @Schema(implementation = String.class))}
            )
    })
    @GetMapping(value = "/v1/hello-world", produces = TEXT_PLAIN_VALUE)
    String helloWorld();

    /**
     * Return student
     * @return {@link Student}
     */
    @Operation(summary = "Return Student object as response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return Student object as response",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))}
            )
    })
    @GetMapping(value = "/v1/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV1();

    /**
     * Return student
     * @return {@link ResponseEntity}&lt;{@link Student}&gt;
     */
    @Operation(summary = "Return Student object as response in ResponseEntity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return Student object as response in ResponseEntity",

                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))}
            )
    })
    @GetMapping(value = "/v2/students", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Student> studentsV2();

    /**
     * Get all students
     * @return {@link List}&lt;{@link Student}&gt;
     */
    @Operation(summary = "Return list of Student objects as response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return list of Student objects as response",
                    content = {
                        @Content(
                                mediaType = APPLICATION_JSON_VALUE,
                                array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }
            )
    })
    @GetMapping(value = "/v3/students", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    List<Student> studentsV3();

    /**
     * Get student with name and book passed as request headers
     * @param name Student name header
     * @param book Book name header
     * @return {@link Student}
     */
    @Operation(summary = "Get name and book as request headers and return Student object as response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get name and book as request headers and return Student object as response",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))}
            )
    })
    @GetMapping(value = "/v4/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV4(@RequestHeader("name") String name, @RequestHeader("book") String book);

    /**
     * Get student with name and book passed as request headers
     * @param name Student name request parameter
     * @param book Book name request parameter
     * @return {@link Student}
     */
    @Operation(summary = "Get name and book as request parameters and return Student object as response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get name and book as request parameters and return Student object as response",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))}
            )
    })
    @GetMapping(value = "/v5/students", produces = APPLICATION_JSON_VALUE)
    Student studentsV5(@RequestParam("name") String name, @RequestParam("book") String book);

    /**
     * Get student with name and book passed as request headers
     * @param name Student name path variable
     * @param book Book name path variable
     * @return {@link Student}
     */
    @Operation(summary = "Get name and book as path variables and return Student object as response")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get name and book as path variables and return Student object as response",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Student.class))}
            )
    })
    @GetMapping(value = "/v6/students/{name}/{book}", produces = APPLICATION_JSON_VALUE)
    Student studentsV6(@PathVariable("name") String name, @PathVariable("book") String book);

    /**
     * Get API with pagination.
     * {@link ParameterObject} is optional. This annotation used to correctly document {@link Pageable} object
     *
     * springdoc-openapi-ui:
     * This library automatically generates OpenAPI 3.0 compliant documentation for Spring Boot applications.
     *
     * {@link ParameterObject}
     * This annotation ensures that Pageable is properly documented in the Swagger UI, showing parameters like page, size, and sort.
     *
     * @param pageable {@link Pageable}
     * @return {@link List}&lt;{@link Student}&gt;
     */
    @Operation(summary = "Get Students with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Students with pagination",
                    content = {
                    @Content(mediaType = APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Student.class)))
                    }
            )
    })
    @GetMapping(value = "v7/students", produces = APPLICATION_JSON_VALUE)
    List<Student> studentsV7(@ParameterObject Pageable pageable);

}