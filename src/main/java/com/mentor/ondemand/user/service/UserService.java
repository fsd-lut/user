package com.mentor.ondemand.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mentor.ondemand.user.entity.User;

@Service
public interface UserService {
	User save (User user);
	
	List<User> saveAll(List<User> list);
	
	void delete(User user);
	
	List<User> findAll();
	
	User findById(Long id);
	
	User findByUserName(String username);
}