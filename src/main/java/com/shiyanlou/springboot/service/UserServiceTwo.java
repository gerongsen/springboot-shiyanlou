package com.shiyanlou.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.springboot.dao.jpa.two.UserRepositoryTwo;
import com.shiyanlou.springboot.entity.jpa.UserTwo;

@Service
public class UserServiceTwo {
	
	@Autowired
	private UserRepositoryTwo userRepositoryTwo;
	
	@Transactional
	public UserTwo save(UserTwo userTwo) {
		return userRepositoryTwo.save(userTwo);
	}
	
}
