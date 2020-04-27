package com.testing.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testing.model.Task;

@Repository 
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
