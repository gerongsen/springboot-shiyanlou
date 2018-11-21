package com.shiyanlou.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.springboot.dao.jpa.one.UserRepository;
import com.shiyanlou.springboot.entity.jpa.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		
		return userRepository.save(user);
	}
}
