package com.invillia.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.User;
import com.invillia.acme.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> get() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User getById(Long userId) {
		return userRepository.findOne(userId);
   }
	
	public void delete(Long userId) {	
		userRepository.delete(userId);
	}
	
	public void update(User user) {
		userRepository.save(user);
		
	}
}
