package com.lx.daos.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lx.daos.Dao;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T, ID extends Serializable> extends HibernateDaoSupport implements Dao<T, ID> {
	private static final Logger log = LogManager.getLogger(AbstractDao.class); 
	

}
