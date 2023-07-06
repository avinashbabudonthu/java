package com.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String id;
    private String username;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

}