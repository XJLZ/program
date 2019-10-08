package com.xjl.service.Impl;

import com.xjl.dao.AccountDao;
import com.xjl.domain.TxAccount;
import com.xjl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public List<TxAccount> findAll() {
        return accountDao.findAll();
    }

    @Override
    public TxAccount findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    public void updateByName(String name,double money) {
        accountDao.updateByName(name,money);
    }

    @Override
    public void change(String one, String another, double money){
        TxAccount name0 = accountDao.findByName(one);
        TxAccount name1 = accountDao.findByName(another);
        double m0 = name0.getMoney() - money;
        accountDao.updateByName(one,m0);
        int i = 1/0;
        double m1 = name0.getMoney() + money;
        accountDao.updateByName(another,m1);
        System.out.println("OK");
    }
}
