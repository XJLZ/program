package com.service.Impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User login(User loginuser) {
        return userDao.login(loginuser);
    }

    public boolean register(User registeruser) {
        return userDao.register(registeruser);
    }

    public User findOne(String username) {
        return userDao.findOne(username);
    }
}
