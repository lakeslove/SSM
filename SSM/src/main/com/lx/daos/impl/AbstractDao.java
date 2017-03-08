package com.lx.daos.impl;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lx.daos.Dao;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {
	private static final Logger log = LogManager.getLogger(AbstractDao.class);

}
