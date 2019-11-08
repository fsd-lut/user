package com.mentor.ondemand.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.ondemand.user.entity.User;
import com.mentor.ondemand.user.repository.UserRepository;
import com.mentor.ondemand.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> saveAll(List<User> list) {
		// TODO Auto-generated method stub
		return userRepository.saveAll(list);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> result = userRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		System.out.println("find by user");
		return userRepository.findByUserName(username);
	}

}
