package com.service.Impl;

import com.dao.AccountDao;
import com.dao.Impl.AccountDaoImpl;
import com.service.AccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        System.out.println("保存账户");
//        int i = 1/0;
    }

    public void updateAccount(int id) {
        System.out.println("更新账户");
    }

    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }

}
