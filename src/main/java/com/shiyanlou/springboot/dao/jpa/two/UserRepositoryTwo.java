package com.shiyanlou.springboot.dao.jpa.two;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shiyanlou.springboot.entity.jpa.UserTwo;

@Repository
public interface UserRepositoryTwo extends CrudRepository<UserTwo, Integer> {

}
