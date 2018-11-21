package com.shiyanlou.springboot.dao.jpa.one;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shiyanlou.springboot.entity.jpa.UserOne;

@Repository
public interface UserRepositoryOne extends CrudRepository<UserOne, Integer>{

}
