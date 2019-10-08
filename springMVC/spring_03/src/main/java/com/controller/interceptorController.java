package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class interceptorController {

    @RequestMapping("/forbidden")
    public String toSuccess(){
        System.out.println("toSuccess.........");
        return "success";
    }
}
