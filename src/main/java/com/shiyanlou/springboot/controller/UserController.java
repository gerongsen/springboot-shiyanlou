package com.shiyanlou.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.springboot.entity.mybatis.User;
import com.shiyanlou.springboot.entity.mybatis.UserOne;
import com.shiyanlou.springboot.service.IUserService;
import com.shiyanlou.springboot.service.IUserServiceOne;


@RestController
@RequestMapping("user")
public class UserController {
	
	private final IUserServiceOne userService;
	
	@Autowired
	public UserController(IUserServiceOne userService) {
		this.userService = userService;
	}
	
	//使用post请求新建
	@PostMapping()
	public String save(UserOne user) {
		userService.save(user);
		return "save sucess";
	}
	
	//使用put请求更新数据，会拦截类似/user/1 这种形式的路径
	@PutMapping("{id}")
	public String update(UserOne user,@PathVariable int id) {
		//当数据不存在的时候
		if(userService.findById(id) == null) {
			return "数据不存在";
		}
		//防止传入的user对象与实际请求的id不一致
		if(user.getId() != id ) {
			return "请求数据非法";
		}
		userService.update(user);
		return "update sucess";
	}
	
	//使用delete 请求删除数据
	@DeleteMapping("{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "delete sucess";
	}
	
	//使用get请求查询 
	@GetMapping()
	public List<UserOne> list(){
		return userService.list();
	}
	
	//使用get请求查询单个数据
	@GetMapping("{id}")
	public UserOne findById(@PathVariable int id) {
		return userService.findById(id);
	}
}
