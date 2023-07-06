package com.tasks.service;

import com.tasks.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    private static final List<Task> taskList = Arrays.asList(
      Task.builder().id("1").username("admin").description("aws").startDate(LocalDate.now()).endDate(LocalDate.now().plusMonths(1))
              .status("todo")
              .build(),
            Task.builder().id("2").username("admin").description("architecture").startDate(LocalDate.now()).endDate(LocalDate.now().plusMonths(1))
                    .status("todo")
                    .build()
    );

    public List<Task> findTaskList(String username) {
        return taskList;
    }
}