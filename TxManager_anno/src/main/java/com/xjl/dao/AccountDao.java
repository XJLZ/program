package com.xjl.dao;

import com.xjl.domain.TxAccount;

import java.util.List;

public interface AccountDao {

   List<TxAccount> findAll();

   TxAccount findByName(String name);

   void updateByName(String name, double money);

}
