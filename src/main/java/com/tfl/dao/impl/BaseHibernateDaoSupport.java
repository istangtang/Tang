package com.tfl.dao.impl;

import com.tfl.dao.BaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class BaseHibernateDaoSupport<T> extends HibernateDaoSupport
      implements BaseDao<T> {
    @Override
    public void save(T instance) {
        this.getHibernateTemplate().save(instance);
    }

    @Override
    public void update(T instance) {
        this.getHibernateTemplate().update(instance);
    }

    @Override
    public void saveOrUpdate(T instance) {
        this.getHibernateTemplate().saveOrUpdate(instance);
    }

    @Override
    public T merge(T instance) {
        return this.getHibernateTemplate().merge(instance);
    }

    @Override
    public void delete(T instance) {
        this.getHibernateTemplate().delete(instance);
    }

    @Override
    public void delete(Collection<T> instance) {
        this.getHibernateTemplate().deleteAll(instance);
    }

    @Override
    public Integer delete(final Object[] ids, final Class<T> cls) {
        return this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session argo) throws HibernateException, SQLException {
                String hql="delete from "+cls.getSimpleName()+"where id in(:ids)";
                return argo.createQuery(hql).setParameterList("ids",ids).executeUpdate();
            }
        });
    }

    @Override
    public T get(Class<T> cls, Serializable id) {
        return this.getHibernateTemplate().get(cls, id);
    }

    @Override
    public List<T> findAll(Class<T> cls) {
        return null;
    }

    @Override
    public <E> List<E> findForPage(String hql, int pageNo, int pageSize, Object... values) {
        return null;
    }

    @Override
    public Number getTotalCount(String hql, Object... values) {
        return null;
    }

    @Override
    public <E> List<E> find(String hql, Object... values) {
        return null;
    }
}
