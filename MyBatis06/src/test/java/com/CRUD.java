package com;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.AccountDao;
import dao.UserDao;
import domain.Account;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRUD {

    private InputStream in;
    private SqlSession session;
    private UserDao userDao;
    private AccountDao accountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
        userDao = session.getMapper(UserDao.class);
        accountDao = session.getMapper(AccountDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.err.println(user);
        }
        PageHelper.startPage(1,3);
        List<User> list = userDao.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        pageInfo.getList().forEach(System.out::println);
        //上一页
        System.out.println(pageInfo.getPrePage());
        //下一页
        System.out.println(pageInfo.getNextPage());
        //总条数
        System.out.println(pageInfo.getTotal());
        //当前页数
        System.out.println(pageInfo.getPageNum());
        //总页数
        System.out.println(pageInfo.getPages());
        //每页条数
        System.out.println(pageInfo.getSize());
    }

    @Test
    public void findByColumn(){
        List<User> users = userDao.findByColumn("username","老王");
        System.err.println(users);
    }

    @Test
    public void updateById(){
        List<User> user = userDao.findByColumn("id", "55");
//        user.get(0).setID(55);
//        user.get(0).setADDRESS("New York");
//        Integer i = userDao.updateById(user.get(0));
//        System.err.println(i);
    }

    @Test
    public void insertUser(){
//        User user = new User();
//        user.setUsername("Tom");
//        user.setSex("男");
//        user.setBirthday(new Date());
//        user.setAddress("New York");
//        Integer i = userDao.insertUser(user);
//        System.err.println(i);
    }

    @Test
    public void deleteById(){
        Integer i = userDao.deleteById(55);
        System.err.println(i);
    }

    @Test
    public void findAccounts(){
        List<User> accounts = userDao.findAccounts();
        for (User user : accounts) {
            System.out.println("------每个用户的信息-------");
            System.out.println(user.toString());
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void findByUid(){
        List<Account> accounts = accountDao.findByUid(45);
        System.out.println(accounts);
    }

    @Test
    public void findUserAccounts(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("--------每个account的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findUserByIds(){
        Integer [] ids = {41,43};
        List<User> users = userDao.findByIds(ids);
        for (User u : users) {
            System.out.println(u.toString());
        }
    }
}
