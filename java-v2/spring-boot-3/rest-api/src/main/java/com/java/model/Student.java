package com.java.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Min(value = 5, message = "Id value should be minimum 5 characters long alphanumeric value")
    private String id;

    @Schema(name = "name", description = "Student name", example = "ABCD", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    @NotBlank
    private String name;

    @Schema(name = "book", description = "Student book name", example = "JAVA", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    @NotBlank
    private String book;

}
