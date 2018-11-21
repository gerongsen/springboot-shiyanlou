package com.shiyanlou.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.springboot.entity.mybatis.UserOne;
import com.shiyanlou.springboot.entity.mybatis.UserTwo;
import com.shiyanlou.springboot.service.IUserServiceOne;
import com.shiyanlou.springboot.service.IUserServiceTwo;


@RestController
@RequestMapping("datasource")
public class dataSourceController {
	
	@Autowired
	private IUserServiceOne serviceOne;
	
	@Autowired
	private IUserServiceTwo serviceTwo;

	@GetMapping("one")
	public List<UserOne> listOne() {
		return serviceOne.list();
	}
	@GetMapping("two")
	public List<UserTwo> listTwo() {
		return serviceTwo.list();
	}
}
