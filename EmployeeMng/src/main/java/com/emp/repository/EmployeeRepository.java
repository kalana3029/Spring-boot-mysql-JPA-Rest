package com.emp.repository;

import com.emp.model.Employee;
import com.emp.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Developer PC on 10/31/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
