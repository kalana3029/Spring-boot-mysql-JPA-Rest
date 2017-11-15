package com.emp.repository;

/**
 * Created by Developer PC on 10/31/2017.
 */
import com.emp.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
