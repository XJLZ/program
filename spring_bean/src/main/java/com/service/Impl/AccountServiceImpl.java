package com.service.Impl;

import com.service.AccountService;

public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("dao执行了。。。。。。。。");
    }
    public void init() {
        System.out.println("容器初始化。。。。。。。。");
    }
    public void destroy() {
        System.out.println("容器销毁了。。。。。。。。");
    }
}
