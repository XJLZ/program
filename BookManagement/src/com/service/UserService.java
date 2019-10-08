package com.service;

import com.domain.User;

public interface UserService {
    User login(User loginuser);

    boolean register(User registeruser);

    User findOne(String username);
}
