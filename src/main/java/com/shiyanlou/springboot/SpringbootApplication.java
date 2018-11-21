package com.shiyanlou.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@SpringBootApplication注解相当于同时使用@EnableAutoConfiguration、@ComponentScan、@Configurations三个注解  
//@EnableAutoConfiguration用于打开SpringBoot自动配置，而其余注解为Spring注解，这里不再赘述
//@ImportResource(value="classpath:config.xml")
@SpringBootApplication
//扫描mapper接口位置
@MapperScan(basePackages = "com.shiyanlou.springboot.dao.mybatis")
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
