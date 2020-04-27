package com.testing.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.modelDto.UsersDto;
import com.testing.service.UsersService;


@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	
	@PostMapping("/register")
	public String RegisterUser(@RequestBody UsersDto usersDto) {
		System.out.println(usersDto+"controller");
		
		usersService.saveUser(usersDto);
		return "success to use spring boot";
	}
	@GetMapping("/{id}")
	public UsersDto getUser(@PathVariable(value="id") int id) {
		System.out.println(id);
		return usersService.getUserById(id);
	}

}