package com.emp.service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/31/2017.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public Employee getEmployee(Integer id) {
        return employeeRepository.findOne(id);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(Integer id){
        employeeRepository.delete(id);
    }
}
