package com;

import com.domain.Customer;
import com.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class crud {

    @Autowired
    private CustomerService cs;

    @Test
    public void findAll(){
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        List<Customer> customers = cs.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
    @Test
    public void save(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        Customer customer = new Customer();
        customer.setId(6);
        customer.setName("张三");
        customer.setAddress("中国北京");
        cs.save(customer);
    }
    @Test
    public void delete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
       cs.delete(6);
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        CustomerService cs = ac.getBean("customerService", CustomerService.class);
        Customer one = cs.findOne(1);
        System.out.println(one);

    }
}
