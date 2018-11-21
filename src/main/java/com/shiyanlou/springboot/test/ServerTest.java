package com.shiyanlou.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.shiyanlou.springboot.entity.jpa.UserOne;
import com.shiyanlou.springboot.entity.jpa.UserTwo;
import com.shiyanlou.springboot.service.UserServiceOne;
import com.shiyanlou.springboot.service.UserServiceTwo;

/**
 * applicationRunner接口可以在springboot启动后马上执行想要执行的方法
 * @author gnnt
 *
 */
@Component
public class ServerTest implements ApplicationRunner{
	
//	@Autowired
//	public UserService userService;
	
	@Autowired
	public UserServiceOne UserServiceOne;
	
	@Autowired
	public UserServiceTwo UserServiceTwo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		User user = new User();
//		user.setUsername("spring boot");
//		user.setPassword("password");
//		userService.save(user);
		
		UserOne userOne = new UserOne();
		userOne.setUsername("shiyanlou1");
		userOne.setPassword("password1");
		UserServiceOne.save(userOne);
		
		UserTwo userTwo = new UserTwo();
		userTwo.setUsername("shiyanlou2");
		userTwo.setPassword("password2");
		UserServiceTwo.save(userTwo);
	}

}
