package com.java.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Schema(name = "id", description = "Student ID any alphanumeric", example = "ABC123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String id;

    @Schema(name = "name", description = "Student name", example = "ABCD", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(name = "book", description = "Student book name", example = "JAVA", requiredMode = Schema.RequiredMode.REQUIRED)
    private String book;

}
