package test.java;

import com.domain.User;
import com.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbctest {
    @Test
    public void findOne(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserService cs = ac.getBean("userService", UserService.class);

        User username = cs.findOne("root");
        System.out.println(username);
    }
}
