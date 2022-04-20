package com.learnSecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnSecurity.models.User;
import com.learnSecurity.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	// all users
	@GetMapping("/")
	public  List<User> getAllUsers(){
		return this.userService.getAllUsers();
	}
	
	// return single user
//	@PreAuthorize("hasRole('ADMIN')") // isko sirf admin hi access kar payega or jab bhi aap PreAuthorize use karte ho to @Configuration me @EnableGlobalMethodSecurity(prePostEnabled = true)
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	// user body me aayega as JSON
	// @RequestBody ;- jo JSON aa raha hoga isme wo deserialize ho jayega
	@PostMapping("/")
	public User add(@RequestBody User user) {
		return this.userService.addUser(user);
	}
}
