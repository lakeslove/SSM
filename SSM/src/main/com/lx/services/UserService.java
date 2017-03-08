package com.lx.services;

import java.util.List;

import com.lx.models.User;
import com.lx.utils.PageData;

public interface UserService extends Service<User, Long>{
	public PageData<User> serchUsers(User user,int currentPage);
	public User getUser(Long id);
	public int insertUser(User user);
	public int deleteUser(Long id);
	public int updateUser(User user);
	public List<User> findUsers(String userName,int start,int limit);
}
