package com.xjl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test01")
    @ResponseBody
    public String test(){
        return "fsdfsdf请问请问按时大苏打";
    }
}
