package com.chinasofti.framework;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;
/**
 * author:胡瑶
 * date:2019/4/24
 * time:18:50
 */
public interface BaseDao<T>{
	void add(T t);

	void update(T t);

	void delete(Integer id);

	T query(Integer id);

	List<T>queryByPageBean(T t, int firstResult, int maxResults, Object... params);

	long getCounts();

	DetachedCriteria createDetachedCriteria(T t, Object... param);

	List<T>queryAll();
}
