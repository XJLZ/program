package com.service.Impl;

import com.dao.CustomerDao;
import com.domain.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

//    public void setCustomerDao(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }

    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public void delete(Integer id) {
        customerDao.delete(id);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public Customer findOne(Integer id) {
        return customerDao.findOne(id);
    }
}
