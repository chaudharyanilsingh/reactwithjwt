package com.testing.service;

import java.util.List;

import com.testing.modelDto.UsersDto;

public interface UsersService {

	public void saveUser(UsersDto usersDto);

	public UsersDto getUserById(int id);

	public List<UsersDto> getAllUsers();
	
}
