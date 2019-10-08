package com;

import com.domain.Customer;
import com.service.CustomerService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
//junit4.12及以上
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class crud {

    @Autowired
    private CustomerService cs = null;

    @Test
    public void findAll(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        List<Customer> customers = cs.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    @Test
    public void save(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        Customer customer = new Customer();
        customer.setId(10);
        customer.setName("张三测试3");
        customer.setAddress("中国北京");
        cs.save(customer);
    }
    @Test
    public void delete(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
       cs.delete(71);
    }
    @Test
    public void update(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        Customer customer = new Customer();
        customer.setId(6);
        customer.setName("张三改");
        customer.setAddress("中国北京");
        cs.update(customer);
    }
    @Test
    public void findOne(){

        Customer one = cs.findOne(1);
        System.out.println(one);

    }
}
