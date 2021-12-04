package com.asu.mapmemate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asu.mapmemate.models.User;
import com.asu.mapmemate.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username,@RequestParam String mail, 
			@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String university,
			@RequestParam String password) {
		User user = new User(mail, firstname, lastname, university, password);
		userService.saveUser(user);
		return "User Saved";
	}
}

