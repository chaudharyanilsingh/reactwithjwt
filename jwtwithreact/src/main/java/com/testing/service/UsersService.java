package com.testing.service;

import com.testing.modelDto.UsersDto;

public interface UsersService {

	public void saveUser(UsersDto usersDto);

	public UsersDto getUserById(int id);
	
}
