package com.shiyanlou.springboot.entity.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity(name = "UserOne")
public class UserOne {
	
	/**
	 * 设置主键生成策略
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public int id;
	
	@Column
	private String username;
	
	@Column
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User{" +
				"id = " + id +
				"username = '" + username +"\'"+
				"password = '" + password + "\'"+
				"}";
	}

}
