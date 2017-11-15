package com.emp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Developer PC on 10/31/2017.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView
    private int employeeid;
    @JsonView
    private String name;
    @JsonView
    @ManyToOne
    private Role role;
    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Collection<Task> taskCollection;

    public Employee() {
    }

    public Employee(int employeeid){
        this.employeeid = employeeid;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "roleid")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }
}
