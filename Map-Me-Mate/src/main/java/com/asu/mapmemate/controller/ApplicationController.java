package com.asu.mapmemate.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asu.mapmemate.models.User;
import com.asu.mapmemate.services.UserService;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/user-registration")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		user.setUsername(user.getMail());
		userService.saveUser(user);
		request.setAttribute("mode", "MODE_REG");
		return "welcomepage";
	}
	@RequestMapping("/logout")
	public String logoutUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveUser(user);
		request.setAttribute("mode", "MODE_HOME_LOGOUT");
		return "welcomepage";
	}

	@RequestMapping("/accomdation-details")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("apartments", userService.showAllUsers());
		request.setAttribute("mode", "MODE_RESULTS");
		return "homepage";
	}
	
	
	@RequestMapping("/search")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		user = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(user != null) {
			request.setAttribute("firstname", user.getFirstname());
			request.setAttribute("mode", "MODE_SEARCH");
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password, try again!");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}

}
