package com.lx.services.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lx.daos.UserDao;
import com.lx.models.User;
import com.lx.services.UserService;
import com.lx.utils.PageData;

@Service
public class UserServiceImpl extends AbstractService<User, Long>implements UserService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(Long id) {
		return this.userDao.getUser(id);
	}

	@Override
	public int insertUser(User user) {
		return this.userDao.insertUser(user);
	}

	@Override
	public int deleteUser(Long id) {
		return this.userDao.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		return this.userDao.updateUser(user);
	}

	@Override
	public List<User> findUsers(String userName, int start, int limit) {
		return this.userDao.findUsers(userName, new RowBounds(start,limit));
	}
	
	@Override
	public PageData<User> serchUsers(User user, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
}