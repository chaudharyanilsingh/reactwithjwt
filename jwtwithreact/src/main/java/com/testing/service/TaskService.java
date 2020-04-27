package com.testing.service;

import java.util.List;
import java.util.Optional;

import com.testing.model.Task;
import com.testing.modelDto.TaskDto;

public interface TaskService extends Iservice<TaskDto> {

	

	List<TaskDto> showall();

	TaskDto showById(int id);


}
