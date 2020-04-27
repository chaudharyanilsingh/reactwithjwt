package com.testing.controller;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testing.common.Response;
import com.testing.modelDto.TaskDto;
import com.testing.service.TaskService;
 
@RestController 
@RequestMapping(value="task")
public class TaskController 
{

	@Autowired
	private TaskService taskService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@PostMapping
	public ResponseEntity<Response> addtask(@RequestBody TaskDto taskdto)
	{
		
		return new ResponseEntity<>(new Response("ok").setResult(taskService.saveTask(taskdto)),HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String>  updatetask(@RequestBody TaskDto taskdto)
	{
		             //Task task1=taskService.showById(task.getTicketNumber()).get();
		
		taskService.upadateTask(taskdto);
		return new ResponseEntity<>("update ok ",HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public String deletatask(@PathVariable(value="id") int id)
	{
		
		taskService.deletetask(id);
		return "data of id  "+id+"  deleted";
	}
	@GetMapping
	public List<TaskDto> showall()
	{

		List<TaskDto> taskdto=(List<TaskDto>) taskService.showall();
		return taskdto;
		
		
	}
	@GetMapping(value="{id}")
	public TaskDto showtaskbyid(@PathVariable(value="id") int id)
	{

		TaskDto taskdto=taskService.showById(id);
		return taskdto;
		
	}
}
