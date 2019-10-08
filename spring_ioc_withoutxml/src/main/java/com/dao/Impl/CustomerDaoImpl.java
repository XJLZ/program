package com.dao.Impl;

import com.dao.CustomerDao;
import com.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> findAll() {
        String sql = "select * from Customer";
        return template.query(sql,new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public void save(Customer customer) {
        String sql = "insert into Customer(Id, Name, Address) values (?, ?, ?)";
        template.update(sql,customer.getId(),customer.getName(),customer.getAddress());
    }

    public void delete(Integer id) {
        String sql ="delete from Customer where Id = ?";
        template.update(sql,id);
    }

    public void update(Customer customer) {
        String sql = "update Customer set Name = ?, Address = ? where Id = ?";
        template.update(sql, customer.getName(), customer.getAddress(),customer.getId());
    }

    public Customer findOne(Integer id) {
        String sql = "select * from Customer where id = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Customer>(Customer.class),id);
    }
}
