package com.emp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

/**
 * Created by Developer PC on 10/31/2017.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView()
    private int taskid;
    @JsonView()
    private String description;
    @JsonView
    @ManyToOne
    @JoinColumn(name = "employee_employeeid", referencedColumnName = "employeeid")
    @JsonIgnore
    private Employee employee;

    public Task() {
    }

    public Task(int taskid) {
        this.taskid = taskid;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
