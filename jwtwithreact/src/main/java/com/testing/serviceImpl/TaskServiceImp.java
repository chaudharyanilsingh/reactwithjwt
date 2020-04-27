package com.testing.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testing.Repository.TaskRepository;
import com.testing.model.Task;
import com.testing.modelDto.TaskDto;
import com.testing.service.TaskService;

@Service
public class TaskServiceImp implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	private ModelMapper modelMapper=new ModelMapper();
	
	@Override
	public TaskDto saveTask(TaskDto taskdto) {

		String[] time = taskdto.getEstimatedHours().split(":");
		Float hour = Float.parseFloat(time[0]);
		Float mins = Float.parseFloat(time[1]);
		Float finaltime = hour + mins / 60;
		taskdto.setEstimatedHours(finaltime.toString());

		if (taskdto.getDateOfDelivery().compareTo(taskdto.getDeadLine()) > 0) {
			taskdto.setDelay(true);
		} else {
			taskdto.setDelay(false);
		}
		Task task=modelMapper.map(taskdto,Task.class);
		taskRepository.save(task);
		
		return modelMapper.map(task,TaskDto.class);

	}

	@Override
	public void deletetask(int id) {
		taskRepository.deleteById(id);

	}

	@Override
	public List<TaskDto> showall() {
		List<Task> task=(List<Task>)taskRepository.findAll();
		Type listType = new TypeToken<List<TaskDto>>() {}.getType();
		List<TaskDto> tasks = new ModelMapper().map(task, listType);
		
		return tasks;
	}

	@Override
	public TaskDto showById(int id) {
		Task task = taskRepository.findById(id).orElse(null);
		return modelMapper.map(task,TaskDto.class);
	}

	@Override
	public void upadateTask(TaskDto taskdto) {
		/*
		 * Optional<Task> tasks=taskRepository.findById(task.getTicketNumber()); Date
		 * date=tasks.get().getCreateAt(); task.setCreateAt(date);
		 */
		String[] time = taskdto.getEstimatedHours().split(":");
		Float hour = Float.parseFloat(time[0]);
		Float mins = Float.parseFloat(time[1]);
		Float finaltime = hour + mins / 60;
		taskdto.setEstimatedHours(finaltime.toString());

		if (taskdto.getDateOfDelivery().compareTo(taskdto.getDeadLine()) > 0) {
			taskdto.setDelay(true);
		} else {
			taskdto.setDelay(false);

		}
		Task task=modelMapper.map(taskdto,Task.class);
		taskRepository.save(task);

	}

}
