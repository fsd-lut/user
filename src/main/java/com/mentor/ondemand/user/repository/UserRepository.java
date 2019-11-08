package com.mentor.ondemand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentor.ondemand.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}