package com.example.Smart.Hospital.Management.System.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Smart.Hospital.Management.System.entities.User;
import com.example.Smart.Hospital.Management.System.exception.ResourceNotFoundException;
import com.example.Smart.Hospital.Management.System.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Transactional
	@Override
	public User createUser(User user) {
		
		
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		
		
	
		return repo.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {
		
		User user1 = getByIdUser(id);
			 user1.setName(user1.getName());
			 user1.setEmail(user1.getEmail());
			 user1.setPassword(user1.getPassword());
			 user1.setPhone(user1.getPhone());
			 user1.setStatus(user1.getStatus());
			 user1.setRoles(user1.getRoles());
			 user1.setCreatedAt(user1.getCreatedAt());
			 user1.setUpdatedAt(user1.getUpdatedAt());
		
		return repo.saveAndFlush(user1);
	}

	@Override
	public User deleteUser(Long id) {
		
		User user = getByIdUser(id);
		
		if(!user.equals(null)) {
			repo.delete(user);
			return user;
		}
		return null;
	}

	@Override
	public User getByIdUser(Long id) {
		
		return repo.getById(id);
//		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("This is not match id : "));
	}

	@Override
	public List<User> getAllUser() {
	
		
		return repo.findAll();
	}
	
	

}
