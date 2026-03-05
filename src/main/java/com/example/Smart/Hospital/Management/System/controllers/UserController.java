package com.example.Smart.Hospital.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Smart.Hospital.Management.System.entities.User;
import com.example.Smart.Hospital.Management.System.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// save
	
	@PostMapping
	public User createUser(@RequestBody User user){
		
		
		return userService.createUser(user);
		
	}
	
	
	
	// update
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.updateUser(user,id));
		
	}
	
	
	
	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(userService.deleteUser(id));
		
	}
	
	
	// find single data
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUserById(@PathVariable Long id){
		
		return ResponseEntity.ok(userService.getByIdUser(id));
	}
	
	
	// find all data
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		
		return ResponseEntity.ok(userService.getAllUser());
	}

}
