package com.emp.controller;

import com.emp.model.AjaxResponseBody;
import com.emp.model.Task;
import com.emp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/31/2017.
 */
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value="/get-tasks", method= RequestMethod.GET)
    public List<Task> getAll(){

        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        List<Task> tasks = taskService.getAll();

        return tasks;
    }

    @RequestMapping(value="/add-task", method=RequestMethod.POST)
    public AjaxResponseBody addTask(@RequestBody Task task){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        taskService.addTask(task);
        ajaxResponseBody.setCode("201");
        ajaxResponseBody.setMsg("Saved");

        return ajaxResponseBody;
    }

    @RequestMapping(value="/task/{id}", method=RequestMethod.GET)
    public Task getTask(@PathVariable String id){
        return taskService.getTask(Integer.parseInt(id));
    }
}
