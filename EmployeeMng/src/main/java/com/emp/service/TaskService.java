package com.emp.service;

import com.emp.model.Role;
import com.emp.model.Task;
import com.emp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/31/2017.
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll(){
        List<Task>tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getTask(Integer id) {
        return taskRepository.findOne(id);
    }

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void delete(Integer id){
        taskRepository.delete(id);
    }
}
