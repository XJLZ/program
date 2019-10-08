package xjl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xjl.domain.Customer;
import xjl.mapper.CustomerMapper;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Customer> queryUser(){
        List<Customer> customers = customerMapper.findAll();
        return customers;
    }

    @RequestMapping("/test02")
    @ResponseBody
    public String test02(){
        return "weqweqwe";
    }
}
