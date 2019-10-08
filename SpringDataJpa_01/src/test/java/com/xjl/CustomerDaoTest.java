package com.xjl;

import com.xjl.dao.CustomerDao;
import com.xjl.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao dao;

    /**
     * 根据id查询
     */
    @Test
    public void findOne(){
        Customer one = dao.findOne(1L);
        System.out.println(one);
    }

    /**
     * 保存对象
     */
    @Test
    public void save(){
        Customer customer = new Customer();
        customer.setCustName("Jerry");
        dao.save(customer);
    }
    @Test

    /**
     * 删除
     */
    public void delete(){
        dao.delete(1L);
        Customer one = dao.findOne(1L);
        dao.delete(one);
    }
}
