package com.test;

import com.dao.UserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CRUDTest {
    InputStream in = null;
    SqlSessionFactory factory = null;
    SqlSession session =  null;
    UserDao userDao = null;
    @Before
    public void init() throws Exception{
        //1.获取字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建SqlsessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlsessionFactory生产一个Sqlsession
        session = factory.openSession();
        //4.使用Sqlsession获取Dao代理对象
        userDao = session.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws Exception{
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("--每个用户的信息--");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }

    @Test
    public void findById(){
        User u = userDao.findById(41);
        System.out.println(u);
    }

    @Test
    public void findByName(){
       String name = "%王%";
        List<User> u = userDao.findByName(name);
        for (User user1 : u) {
            System.out.println(user1);
        }
    }

}
