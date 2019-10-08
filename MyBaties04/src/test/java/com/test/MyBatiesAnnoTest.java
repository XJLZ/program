package com.test;

import com.dao.UserDao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatiesAnnoTest {
    public static void main(String[] args) throws Exception {
        //1.获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据字节输入流构建SqlsessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlsessionFactory生产一个Sqlsession
        SqlSession session = factory.openSession();
        //4.使用Sqlsession获取Dao代理对象
        UserDao userdao = session.getMapper(UserDao.class);
        //5.执行Dao方法
        List<User> users = userdao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
