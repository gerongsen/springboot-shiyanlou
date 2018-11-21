package com.shiyanlou.springboot.dao.mybatis;

import java.util.List;

public interface BaseMapper<T> {
	/**
	 * 保存
	 * @param t
	 * @return
	 */
	Integer save(T t);
	
	/**
	 * 根据id 删除
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 根据id 查询
	 * @param id
	 * @return
	 */
	T findById(Integer id);
	
	/**
	 * 修改
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 返回所有
	 * @return
	 */
	List<T> list();
}
