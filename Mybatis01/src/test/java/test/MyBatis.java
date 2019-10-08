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
import java.util.ArrayList;
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
        User user = userDao.findById(41);
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
         User user = userDao.findById(41);
//        2.更新操作
         user.setAddress("北京23333");
         userDao.updateUser(user);
    }

    @Test
    public void deleteById(){
        userDao.deleteUser(53);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("test User property");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }
    /**
     * 模糊查询
     */
    @Test
    public void findByName(){
        List<User> byName = userDao.findByName("王");
        for (User user : byName) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void total(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void findByDynamic(){
        User user = new User();
        user.setUsername("老王");
//        user.setSex("女");
        List<User> users = userDao.findByDynamic(user);
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void findByInIds(){
        User user = new User();
        List<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        user.setIds(list);
        List<User> users = userDao.findByInIds(user);
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void findRoles(){
        List<User> users = userDao.findRoles();
        for (User user : users) {
            System.out.println("------每个用户的信息-------");
            System.out.println(user.toString());
            System.out.println(user.getRoles());
        }
    }

    @After
    public void destroy() throws IOException {
        //6，释放资源
        session.commit();
        session.close();
        in.close();
    }
}
