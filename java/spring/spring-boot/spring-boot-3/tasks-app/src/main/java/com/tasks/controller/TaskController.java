package com.tasks.controller;

import com.tasks.model.Task;
import com.tasks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks")
    private String tasks(/*@RequestParam("name") String name*/ModelMap modelMap) {
        List<Task> taskList = taskService.findTaskList("admin");
        modelMap.put("tasks", taskList);
        return "tasks";
    }
}
