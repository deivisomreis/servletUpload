package com.agenda.dao;

import java.util.List;

public interface DAO<T> {
	
	void insert(T t);
	void remove(Integer id);
	void update(Integer id, T t);
	T getObject(Integer id);
	List<T> list();
	
	
}
