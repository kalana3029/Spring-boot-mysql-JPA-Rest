package com.emp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Developer PC on 10/30/2017.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView()
    private int roleid;
    @JsonView()
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Collection<Employee> employeeCollection;

    public Role() {
    }

    public Role(int roleid) {
        this.roleid = roleid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }
}
