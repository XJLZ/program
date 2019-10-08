package com.factory;

import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
