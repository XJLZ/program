package test;
import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

import java.util.List;

public class MyBatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1，读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2，创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3，使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4，使用SqlSession创建接口代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5，使用代理对象执行方法
//        User byId = userDao.findById(41);
//        System.out.println(byId);

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

//        User user = new User();
//        user.setUsername("modify User property");
//        user.setAddress("北京市顺义区");
//        user.setSex("男");
//        user.setBirthday(new Date());
//        userDao.saveUser(user);

        //1.根据 id 查询
//         User user = userDao.findById(41);
        //2.更新操作
//         user.setAddress("北京");
//         userDao.updateUser(user);

        //根据 id 删除
//         userDao.deleteUser(49);

        //模糊查询
//        List<User> users = userDao.findByName("%王%");
//        for (User user : users) {
//            System.out.println(user);
//        }
        //聚合函数
//        int count = userDao.findTotal();
//        System.out.println(count);

        //6，释放资源
        session.commit();
        session.close();
        in.close();

    }
}
