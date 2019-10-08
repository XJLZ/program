package com.xjl;

import com.xjl.dao.AccountDao;
import com.xjl.domain.Account;
import com.xjl.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testSpring {

    @Autowired
    private AccountService service;

    @Test
    public void testService(){
        List<Account> all = service.findAll();
        System.out.println(all);
    }

    @Test
    public void run2(){
        Account account = new Account();
        account.setName("Rose");
        account.setMoney(2000.00);
        service.saveAccount(account);

    }
}
