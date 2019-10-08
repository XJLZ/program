package com.xjl.service;

import com.xjl.domain.TxAccount;

import java.util.List;

public interface AccountService {

    List<TxAccount> findAll();

    TxAccount findByName(String name);

    void updateByName(String name,double money);

    void change(String one, String another, double money);
}
