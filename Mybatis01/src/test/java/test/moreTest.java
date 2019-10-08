package test;

import dao.RoleDao;
import domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class moreTest {
    private InputStream in = null;
    private SqlSessionFactoryBuilder builder = null;
    private SqlSessionFactory factory = null;
    private SqlSession session = null;
    private RoleDao roleDao = null;
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
        roleDao = session.getMapper(RoleDao.class);
    }
    @After
    public void destroy() throws IOException {
        //6，释放资源
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("------每个角色的信息-------");
            System.out.println(role.toString());
            System.out.println(role.getUsers());
        }
    }
}
