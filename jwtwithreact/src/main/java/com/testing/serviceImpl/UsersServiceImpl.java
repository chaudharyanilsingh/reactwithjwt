package com.testing.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testing.Repository.UsersRepository;
import com.testing.model.Task;
import com.testing.model.Users;
import com.testing.modelDto.TaskDto;
import com.testing.modelDto.UsersDto;
import com.testing.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public void saveUser(UsersDto usersDto) {
		
		Users users=modelMapper.map(usersDto,Users.class);
		users.setPassword(bcryptEncoder.encode(usersDto.getPassword()));
		usersRepository.save(users);
		
	}
	@Override
	public UsersDto getUserById(int id) {
		UsersDto userDto=modelMapper.map(usersRepository.findById(id).orElse(null),UsersDto.class);
		
		return userDto;
	}
	@Override
	public List<UsersDto> getAllUsers() {
			
		List<Users> users=(List<Users>) usersRepository.findAll();
		Type listType = new TypeToken<List<UsersDto>>() {}.getType();
		List<UsersDto> usersDto = new ModelMapper().map(users, listType);
		return usersDto;
	}

		
	}

	


