package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpringmvc {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello");
        return "success";
    }
}
