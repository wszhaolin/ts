package com.baizhi.dao;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;

import java.util.Set;

public interface UserDao {
    public User queryName(String name);
    public void insert(User user);
    public Set<Role> findRolesByUsername(String name);
    public Set<Permission> findPermissionsByUsername(String name);
}
