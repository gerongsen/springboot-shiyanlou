package com.shiyanlou.springboot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.springboot.dao.jpa.one.UserRepositoryOne;
import com.shiyanlou.springboot.entity.jpa.UserOne;

@Service
public class UserServiceOne {
	
	@Autowired
	private UserRepositoryOne userRepositoryOne;
	
	@Transactional
	public UserOne save(UserOne userOne) {
		return userRepositoryOne.save(userOne);
	}
}
