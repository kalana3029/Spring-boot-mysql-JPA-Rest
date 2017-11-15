package com.emp.controller;

import com.emp.model.AjaxResponseBody;
import com.emp.model.Employee;
import com.emp.model.Task;
import com.emp.service.EmployeeService;
import com.emp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/31/2017.
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/get-employees", method= RequestMethod.GET)
    public List<Employee> getAll(){

        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        List<Employee> employees = employeeService.getAll();

        return employees;
    }

    @RequestMapping(value="/add-employee", method=RequestMethod.POST)
    public AjaxResponseBody addTask(@RequestBody Employee employee){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        employeeService.addEmployee(employee);
        ajaxResponseBody.setCode("201");
        ajaxResponseBody.setMsg("Saved");

        return ajaxResponseBody;
    }

    @RequestMapping(value="/employee/{id}", method=RequestMethod.GET)
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployee(Integer.parseInt(id));
    }
}
