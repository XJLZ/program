package com.factory;

import com.service.AccountService;
import com.service.Impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
