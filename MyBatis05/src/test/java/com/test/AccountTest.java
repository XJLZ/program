package com.test;

import com.dao.AccountDao;
import com.dao.UserDao;
import com.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.InputStream;
import java.net.PortUnreachableException;
import java.util.List;

public class AccountTest {
    InputStream in = null;
    SqlSessionFactory factory = null;
    SqlSession session =  null;
    AccountDao accountDao = null;
    @Before
    public void init() throws Exception{
        //1.获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建SqlsessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlsessionFactory生产一个Sqlsession
        session = factory.openSession();
        //4.使用Sqlsession获取Dao代理对象
        accountDao = session.getMapper(AccountDao.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public void findAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("---每个账户的信息---");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void tt(){
        List<Account> accountByUid = accountDao.findAccountByUid(46);
        for (Account account : accountByUid) {
            System.out.println(account);
        }
    }
}
