package test;

import dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class MyBatis {

    private InputStream in = null;
    private SqlSessionFactoryBuilder builder = null;
    private SqlSessionFactory factory = null;
    private SqlSession session = null;
    private UserDao userDao = null;
    @Before
    public void init() throws IOException {
        //1，读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2，创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        //3，使用工厂生产SqlSession对象
        session = factory.openSession();
        //4，使用SqlSession创建接口代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @Test
    public void findById(){
        User user = userDao.findByColumn("username","老王");
        System.out.println(user.toString());
    }

    @Test
    public void findAll(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void update(){
//        1.根据 id 查询
         User user = userDao.findByColumn("id","41");
//        2.更新操作
         user.setAddress("北京");
         userDao.updateUser(user);
    }

    @Test
    public void deleteById(){
        userDao.deleteUser(42);
    }

    @Test
    public void insert(){
//        User user = new User("老李",new Date(),"男","上海");
        User user = new User();
        user.setUsername("modify User property");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }
    /**
     * 模糊查询
     */
    @Test
    public void findByName(){
        List<User> byName = userDao.findByName("%王%");
        for (User user : byName) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void total(){
        int total = userDao.findTotal();
        System.out.println(total);
    }


    @After
    public void destroy() throws IOException {
        //6，释放资源
        session.commit();
        session.close();
        in.close();
    }
}
