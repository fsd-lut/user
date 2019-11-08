package com.mentor.ondemand.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mentor.ondemand.user.entity.User;
import com.mentor.ondemand.user.service.UserService;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserApplicationTests extends TestCase {
	@Autowired
	private UserService userService;
	
	@Test
	public void getUserByName() {
		User user = userService.findByUserName("daniel");
		user.getActive();
		user.getConfirmedSignUp();
		user.getContactNumber();
		user.getFirstName();
		user.getId();
		user.getLastName();
		user.getLinkedinUrl();
		user.getRegCode();
		user.getResetPassword();
		user.getResetPasswordDate();
		user.getRole();
		user.getUserName();
		user.getYearsOfExperience();
	}
	
	@Test
	public void getAll() {
		userService.findAll();
	}
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setUserName("testname");
		user.setPassword("testpwd");
		user.setActive(true);
		user.setConfirmedSignUp(false);
		user.setContactNumber("1234567809");
		user.setFirstName("Lu");
		user.setLastName("ting");
		user.setLinkedinUrl("www.helloworld.com");
		user.setRegCode("027");
		user.setResetPassword(false);
		user.setRole("user");
		user.setYearsOfExperience((float) 20220202);
		userService.save(user);
		
	}
	
	@Test
	public void deleteUser() {
		User user = new User();
		user.setUserName("testname");
		user.setPassword("testpwd");
		userService.delete(user);
	}

	@Test
	public void saveAll() {
		User user = new User();
		user.setUserName("testname");
		user.setPassword("testpwd");
		user.setActive(true);
		user.setConfirmedSignUp(false);
		user.setContactNumber("1234567809");
		user.setFirstName("Lu");
		user.setLastName("ting");
		user.setLinkedinUrl("www.helloworld.com");
		user.setRegCode("027");
		user.setResetPassword(false);
		user.setRole("user");
		user.setYearsOfExperience((float) 20220202);
		List<User> list = new ArrayList<User>();
		list.add(user);
		userService.saveAll(list);
		
	}
}