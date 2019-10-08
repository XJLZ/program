package com.xjl.dao.Impl;

import com.xjl.dao.AccountDao;
import com.xjl.domain.TxAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<TxAccount> findAll() {
        String sql = "select * from TxAccount ";
        return template.query(sql,new BeanPropertyRowMapper<TxAccount>(TxAccount.class));
    }

    @Override
    public TxAccount findByName(String name) {
        String sql = "select * from TxAccount where name = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<TxAccount>(TxAccount.class),name);
    }

    @Override
    public void updateByName(String name, double money) {
        String sql = "update TxAccount set money = ? where name = ?";
        template.update(sql,money,name);
    }
}
