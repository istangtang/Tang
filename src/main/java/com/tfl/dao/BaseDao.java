package com.tfl.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao<T>{
    public  void save(T instance);

    public void  update(T instance);

    public void  saveOrUpdate(T instance);

    public  T merge(T instance);

    public void  delete(T instance);

    public void  delete(Collection<T> instance);

    public Integer delete(Object[] ids,Class<T> cls);

    public  T get(Class<T> cls, Serializable id);

    public List<T>findAll(Class<T> cls);

    public <E> List<E> findForPage(String hql,int pageNo,int pageSize,Object...values);  //投影查询

    public  Number getTotalCount(String hql,Object... values);

    public <E> List<E> find(String hql,Object... values);
}
