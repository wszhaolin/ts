package com.baizhi.service;

import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;

import java.util.Set;

public interface UserService {
    public User findUserName(String name);
    public void regis(User user);
    public Set<Role> queryRolesByUsername(String name);
    public Set<Permission> queryPermissionByUsername(String name);
}
