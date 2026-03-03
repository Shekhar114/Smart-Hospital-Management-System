package com.example.Smart.Hospital.Management.System.service;

import java.util.List;

import com.example.Smart.Hospital.Management.System.entities.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User updateUser(User user, Long id);
	
	public User deleteUser(Long id);
	
	public User getByIdUser(Long id);
	
	public List<User> getAllUser();

}
