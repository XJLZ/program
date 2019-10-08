package com.xjl;

import com.xjl.dao.CustomerDao;
import com.xjl.dao.CustomerDao_jpa;
import com.xjl.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest_jpa {

    @Autowired
    private CustomerDao_jpa dao;

    @Test
    public void findAll(){
        List<Customer> customers = dao.findAllCustomer();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
