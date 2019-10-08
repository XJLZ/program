package com.service.Impl;

import com.dao.CustomerDao;
import com.dao.Impl.CustomerDaoImpl;
import com.domain.Customer;
import com.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = dao.findAll();
        return customers;
    }
}
