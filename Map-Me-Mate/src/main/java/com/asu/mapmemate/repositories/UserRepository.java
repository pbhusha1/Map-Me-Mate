package com.asu.mapmemate.repositories;

import org.springframework.data.repository.CrudRepository;

import com.asu.mapmemate.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {	
	
	public User findByUsernameAndPassword(String username, String password);
}
