package com.testing.Repository;

import org.springframework.data.repository.CrudRepository;

import com.testing.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

	Users findByName(String username);


}
