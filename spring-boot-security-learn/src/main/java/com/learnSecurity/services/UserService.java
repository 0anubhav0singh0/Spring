package com.learnSecurity.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learnSecurity.models.User;

@Service
public class UserService {
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("abc","abc","ABC@GMAIL. com"));
		list.add(new User("xyz","abcxyz","XYZ@GMAIL. com"));
	}
	
	// get all users
	public List<User> getAllUsers(){
		return this.list;
	}
	
	// get single user
	public User getUser(String username) {
//		return (User) this.list.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
		return (User) this.list.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	// add new user
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
