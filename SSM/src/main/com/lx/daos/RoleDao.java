package com.lx.daos;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.learn.lx.pojo.Role;

@Repository
public interface RoleDao {
	public int insertRole(Role role);
	public int updateRole(Role role);
	public int deleteRole(Long id);
	public Role getRole(Long id);
	public List<Role> findRoles(String roleName,RowBounds rowBounds);
}
