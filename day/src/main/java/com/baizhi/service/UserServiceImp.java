package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Permission;
import com.baizhi.entity.Role;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserName(String name) {
        return userDao.queryName(name);
    }

    @Override
    public void regis(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.insert(user);
    }

    @Override
    public Set<Role> queryRolesByUsername(String name) {
        return userDao.findRolesByUsername(name);
    }

    @Override
    public Set<Permission> queryPermissionByUsername(String name) {
        return userDao.findPermissionsByUsername(name);
    }
}
