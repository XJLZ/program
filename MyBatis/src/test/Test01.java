package test;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class Test01 {


    private InputStream in;
    private SqlSession sqlSession;
    private dao.UserDao userDao;

   @Before
   public void init()throws Exception{
       //1.读取配置文件，生成字节输入流
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
       //2.获取SqlSessionFactory
       SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
       //3.获取SqlSession对象
       sqlSession = factory.openSession();
       //4.获取dao的代理对象
       userDao = sqlSession.getMapper(dao.UserDao.class);
   }
    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findByDynamic(){
        User user = new User();
        user.setUsername("");
    }
}
