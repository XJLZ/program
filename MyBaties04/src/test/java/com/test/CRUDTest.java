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
    public void save(){
        User user = new User();
        user.setAddress("北京");
        user.setUsername("注解测试_插入");
        userDao.saveUser(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(50);
        user.setUsername("注解测试_更新");
        userDao.updateUser(user);
    }
    @Test
    public void delete(){
        User user = new User();
        user.setId(56);
        userDao.deleteUser(user);
    }
    @Test
    public void findById(){
        User user = new User();
        user.setId(41);
        User u = userDao.select(user);
        System.out.println(u);
    }
    @Test
    public void findByName(){
        User user = new User();
        user.setUsername("%王%");
        List<User> u = userDao.findByName(user);
        for (User user1 : u) {
            System.out.println(user1);
        }
    }
    @Test
    public void findTotal(){
        int total = userDao.findTotal();
        System.out.println(total);

    }
}
