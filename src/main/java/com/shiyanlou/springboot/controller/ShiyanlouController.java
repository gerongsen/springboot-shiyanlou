package com.shiyanlou.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PropertySource(value="classpath:shiyanlou.properties")
public class ShiyanlouController {
	
	@Value("${shiyanlou.test}")
	private String myproperties;
	
	@RequestMapping("/shiyanlou")
	@ResponseBody
	public String shiyanlou() {
		return  myproperties;
	}
	
	@RequestMapping("shiyanlouview")
	public String shiyanlouvies() {
		return "shiyanlou";
	}

}
