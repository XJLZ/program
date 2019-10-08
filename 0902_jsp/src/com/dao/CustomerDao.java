package com.dao;

import com.domain.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> findAll();
}
