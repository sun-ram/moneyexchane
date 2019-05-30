package com.amg.exchange.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface ICommonDao<T> {
	
	void save(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> findByName(String name); 
	List<T> findById(int id); 
	List<T> findAll();
	List<T> findAll(DetachedCriteria criteria);
}
