package com.testing.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testing.Repository.UsersRepository;
import com.testing.model.Users;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users=usersRepository.findByName(username);
		
			return new User(users.getName(),users.getPassword(),
					new ArrayList<>());
		
	}
}	