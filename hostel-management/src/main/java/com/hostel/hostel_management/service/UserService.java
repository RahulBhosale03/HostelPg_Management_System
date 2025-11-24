package com.hostel.hostel_management.service;

import java.util.List;
import java.util.Optional;

import com.hostel.hostel_management.model.User;

public interface UserService {
	User saveUser(User user);
	
	Optional<User> getUserById(Long id);
	
	List<User> getAllUsers();
	
	User updateUser(Long id,User user);
	
	void deleteUser(Long id);
}
