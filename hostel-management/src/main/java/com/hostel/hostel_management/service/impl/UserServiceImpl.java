package com.hostel.hostel_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hostel.hostel_management.model.User;
import com.hostel.hostel_management.repository.UserRepository;
import com.hostel.hostel_management.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updatedUser = existingUser.get();
			updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setPhone(user.getPhone());
            updatedUser.setRole(user.getRole());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setJoinDate(user.getJoinDate());
            return userRepository.save(updatedUser);
		}else {
		return null;
		}
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}

}
