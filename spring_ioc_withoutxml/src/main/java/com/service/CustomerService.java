package com.service;

import com.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    void delete(Integer id);

    void update(Customer customer);

    Customer findOne(Integer id);
}
