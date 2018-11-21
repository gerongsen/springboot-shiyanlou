package com.shiyanlou.springboot.dao.jpa.one;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shiyanlou.springboot.entity.jpa.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
