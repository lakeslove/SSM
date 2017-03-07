package com.lx.daos;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.learn.lx.pojo.User;

@Repository
public interface UserDao {
	public User getUser(Long id);
	public int insertUser(User user);
	public int deleteUser(Long id);
	public int updateUser(User user);
	public List<User> findUsers(String userName,RowBounds rowBounds);
}
