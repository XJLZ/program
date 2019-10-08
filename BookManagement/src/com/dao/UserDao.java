package com.dao;

import com.domain.User;

public interface UserDao {

    User login(User loginuser);

    boolean register(User registeruser);

    User findOne(String username);
}