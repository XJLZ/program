package com.dao.Impl;

import com.dao.CustomerDao;
import com.domain.Customer;
import com.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Customer> findAll() {
        List<Customer> customers = null;
        try {
            String sql = "select * from Customer";
            customers = template.query(sql, new BeanPropertyRowMapper<>(Customer.class));
            return customers;
        }catch (Exception e){
            return null;
        }

    }
}
